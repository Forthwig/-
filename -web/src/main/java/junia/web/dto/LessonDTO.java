package junia.web.dto;

import junia.lab.core.entity.Review;

import java.util.List;
import java.util.Set;

public class LessonDTO {

    private String title;
    private String language;
    private List<String> Teachers;
    private List<String> Students;
    private Set<Review> Reviews;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public List<String> getTeachers() {
        return Teachers;
    }

    public void setTeachers(List<String> teachers) {
        Teachers = teachers;
    }

    public List<String> getStudents() {
        return Students;
    }

    public void setStudents(List<String> students) {
        Students = students;
    }

    public Set<Review> getReviews() {
        return Reviews;
    }

    public void setReviews(Set<Review> reviews) {
        Reviews = reviews;
    }
}
