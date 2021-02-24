package junia.lab.core.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student extends GenericEntity implements Comparable<Student> {

    private String email;

    private String password;

    private String role; //TODO Alaways Student

    private String enable; //TODO Alaways 1

    public Student() {
    }

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
    public int compareTo(Student o) {
        return Long.compare(o.getId(),getId());
    }
}
