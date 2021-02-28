package junia.lab.core.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Student extends GenericEntity implements Comparable<Student> {

    private String mail;

    private String surnom;

    private String password;

    private String image;

    @Enumerated(EnumType.STRING)
    private Promo promo;

    private String role; //TODO Alaways Student

    private String enable; //TODO Alaways 1

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "student")
    private List<Review> reviews;

    public Student() {
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getSurnom() {
        return surnom;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setSurnom(String surnom) {
        this.surnom = surnom;
    }

    public Promo getPromo() {
        return promo;
    }

    public void setPromo(Promo promo) {
        this.promo = promo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return mail;
    }

    public void setEmail(String email) {
        this.mail = email;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    @Override
    public int compareTo(Student o) {
        return Long.compare(o.getId(),getId());
    }
}
