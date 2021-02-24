package junia.web.dto;

import junia.lab.core.entity.Language;
import junia.lab.core.entity.Teacher;

import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.Set;

public class LessonDTO {

    private String title;
    private Language language;
    private Set<Teacher> Teachers;
    private Set<Teacher> Students;

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
        return Teachers;
    }

    public void setTeachers(Set<Teacher> teachers) {
        Teachers = teachers;
    }

    public Set<Teacher> getStudents() {
        return Students;
    }

    public void setStudents(Set<Teacher> students) {
        Students = students;
    }
}
