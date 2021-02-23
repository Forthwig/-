package junia.lab.core.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Lesson extends GenericEntity implements Comparable<Lesson>  {

    private String title;

    @Enumerated(EnumType.STRING)
    private Language language;

    @ManyToMany
    @JoinTable(name = "Lesson_tag_teacher", joinColumns = @JoinColumn(name = "lesson_id"), inverseJoinColumns = @JoinColumn(name = "teacher_id"))
    private Set<Teacher> Teachers;

    @ManyToMany
    @JoinTable(name = "Lesson_tag_student", joinColumns = @JoinColumn(name = "lesson_id"), inverseJoinColumns = @JoinColumn(name = "Student_id"))
    private Set<Teacher> Students;

    private String image;

    @ManyToMany
    private Set<Tag> tags;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="lesson")
    private Set<Review> reviews;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    @Override public int compareTo(final Lesson o) {
        return title.compareTo(o.title);
    }

}
