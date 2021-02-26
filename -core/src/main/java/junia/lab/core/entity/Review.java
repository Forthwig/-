package junia.lab.core.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Review extends GenericEntity implements Comparable<Review> {

    private String title;

    private String text;

    private Date dateOfReview;

    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) //We need this annotation for the deserialization only
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Student student;

    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) //We need this annotation for the deserialization only
    @JoinColumn(name = "teacher_id", referencedColumnName = "id")
    private Teacher teacher;

    public String getText() { return text; }

    public void setText(String text) { this.text = text; }

    public Date getDateOfReview() {
        return dateOfReview;
    }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public Student getStudent() { return student; }

    public void setStudent(Student student) { this.student = student; }

    public void setDateOfReview(Date dateOfReview) {
        this.dateOfReview = dateOfReview;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public int compareTo(final Review o) {
        return dateOfReview.compareTo(o.dateOfReview);
    }
}
