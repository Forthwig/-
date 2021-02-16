package web.dto;

import junia.lab06.core.entity.Review;

import java.util.List;
import java.util.Set;

public class BookDTO {

    private long id;

    private String title;

    private String image;

    private List<String> authors;

    private List<String> tags;

    private String language;

    private Set<Review> reviews;


    public long getId() {
        return id;
    }


    public void setId(final long idValue) {
        id = idValue;
    }


    public String getTitle() {
        return title;
    }


    public void setTitle(final String titleValue) {
        title = titleValue;
    }


    public String getImage() {
        return image;
    }


    public void setImage(final String imageValue) {
        image = imageValue;
    }


    public List<String> getAuthors() {
        return authors;
    }


    public void setAuthors(final List<String> authorsValue) {
        authors = authorsValue;
    }


    public List<String> getTags() {
        return tags;
    }


    public void setTags(final List<String> tagsValue) {
        tags = tagsValue;
    }


    public String getLanguage() {
        return language;
    }


    public void setLanguage(final String languageValue) {
        language = languageValue;
    }


    public Set<Review> getReviews() {
        return reviews;
    }


    public void setReviews(final Set<Review> reviewsValue) {
        reviews = reviewsValue;
    }
}
