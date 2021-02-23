package junia.lab.core.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Teacher extends GenericEntity implements Comparable<Teacher> {

    private String email;

    private String password;

    private String role; //TODO Alaways Teacher

    private String enable; //TODO Alaways 1

    @ManyToMany(mappedBy = "Teacher")
    private List<Lesson> Lessons;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int compareTo(Teacher o) {
        return Long.compare(o.getId(),getId());
    }
}
