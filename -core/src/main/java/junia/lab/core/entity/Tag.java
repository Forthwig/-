package junia.lab.core.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@JsonIgnoreProperties({ "Lesson" })
public class Tag extends GenericEntity implements Comparable<Tag> {

    private String name;

    @ManyToMany(mappedBy = "tags")
    private List<Lesson> Lessons;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Lesson> getBooks() {
        return Lessons;
    }

    public void setBooks(List<Lesson> books) {
        this.Lessons = books;
    }

    @Override
    public int compareTo(final Tag o) {
        return name.compareTo(o.name);
    }

}
