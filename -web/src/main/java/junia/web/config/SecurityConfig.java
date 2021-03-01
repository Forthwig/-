package junia.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder authManagerBuilder) throws Exception {
        // Users in memory.
        authManagerBuilder.inMemoryAuthentication().withUser("1@1.fr").password("111").roles("STUDENT");

        // For User in database.
        authManagerBuilder.jdbcAuthentication().dataSource(dataSource)
                        .usersByUsernameQuery("SELECT mail,password,enable FROM student s WHERE s.mail=?")
                        .authoritiesByUsernameQuery("SELECT mail,role FROM student s WHERE s.mail=?")
                .and()
                    .jdbcAuthentication().dataSource(dataSource)
                        .usersByUsernameQuery("UNION SELECT mail,password,enable FROM teacher t WHERE t.mail=?")
                        .authoritiesByUsernameQuery("UNION SELECT mail,role FROM teacher t WHERE t.mail=?");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/resources/**","/","/login/add","/home","/rank").permitAll()
                .and()
                .authorizeRequests()
                .antMatchers("/student/**","/logout").hasRole("STUDENT")
                .antMatchers("/teacher/**","/logout").hasRole("TEACHER")
                .anyRequest().authenticated()
        .and()
            .formLogin()
            .loginPage("/login")
                .defaultSuccessUrl("/")
                .failureUrl("/login?error=true")
                .permitAll()
        .and()
            .logout()
            .logoutSuccessUrl("/login?logout=true")
            .invalidateHttpSession(true)
            .permitAll()
        .and()
            .csrf()
            .disable();
    }


}
