package junia.lab.core.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Lesson extends GenericEntity implements Comparable<Lesson>  {

    private String title;

    @Enumerated(EnumType.STRING)
    private Language language;

    @ManyToMany
    @JoinTable(name = "Lesson_teacher", joinColumns = @JoinColumn(name = "lesson_id"), inverseJoinColumns = @JoinColumn(name = "teacher_id"))
    private Set<Teacher> teachers;

    @ManyToMany
    @JoinTable(name = "Lesson_student", joinColumns = @JoinColumn(name = "lesson_id"), inverseJoinColumns = @JoinColumn(name = "Student_id"))
    private Set<Student> students;

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

    public Set<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(Set<Teacher> teachers) {
        teachers = teachers;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    @Override public int compareTo(final Lesson o) {
        return title.compareTo(o.title);
    }

}
