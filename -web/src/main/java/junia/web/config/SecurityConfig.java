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
                    .usersByUsernameQuery("SELECT mail,password,enable FROM student WHERE mail=?")
                .authoritiesByUsernameQuery("SELECT mail,role FROM student WHERE mail=?");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/", "/home", "/js/**", "/css/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .authorizeRequests()
                .antMatchers("/list","/form","/list/**","/logout").hasAnyRole("STUDENT")
        .and()
            .formLogin()
            .loginPage("/login")
                .defaultSuccessUrl("/profil")
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
