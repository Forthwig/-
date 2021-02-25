package junia.lab.core.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@JsonIgnoreProperties({ "Lessons" }) //eviter les boucle infinie en formats JSON
public class Teacher extends GenericEntity implements Comparable<Teacher> {

    private String email;

    private String password;

    private String role; //TODO Alaways Teacher

    private String enable; //TODO Alaways 1

    @ManyToMany(mappedBy = "Teachers")
    private List<Lesson> Lessons;

    public Teacher() {
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

    public List<Lesson> getLessons() {
        return Lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        Lessons = lessons;
    }

    @Override
    public int compareTo(Teacher o) {
        return Long.compare(o.getId(),getId());
    }
}
