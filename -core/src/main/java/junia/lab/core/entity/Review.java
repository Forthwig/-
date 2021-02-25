package junia.lab.core.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Review extends GenericEntity implements Comparable<Review> {

    private int score;

    private Date dateOfReview;

    private int StudenId;

    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) //We need this annotation for the deserialization only
    private Lesson lesson;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Date getDateOfReview() {
        return dateOfReview;
    }

    public void setDateOfReview(Date dateOfReview) {
        this.dateOfReview = dateOfReview;
    }

    public int getStudenId() {
        return StudenId;
    }

    public void setStudenId(int studenId) {
        StudenId = studenId;
    }

    public Lesson getLesson() { return lesson; }

    public void setLesson(Lesson lesson) { this.lesson = lesson; }

    @Override
    public int compareTo(final Review o) {
        return dateOfReview.compareTo(o.dateOfReview);
    }
}
