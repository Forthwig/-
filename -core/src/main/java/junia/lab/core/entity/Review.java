package junia.lab.core.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Review implements Comparable<Review> {

    public Review() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private int score;

    private Date dateOfReview;

    @Override
    public int compareTo(final Review o) {
        return dateOfReview.compareTo(o.dateOfReview);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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
}
