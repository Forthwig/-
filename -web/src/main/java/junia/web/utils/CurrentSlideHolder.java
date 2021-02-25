package junia.web.utils;

import junia.web.dto.Slide;

public class CurrentSlideHolder {

    private Slide slide;
    private static CurrentSlideHolder instance;

    private CurrentSlideHolder() {
        instance = this;
    }

    public Slide getCurrentSlide() {
        return slide;
    }

    public void setSlide(Slide slide) {
        this.slide = slide;
    }

    public static CurrentSlideHolder getInstance(){
        if(instance == null)
            return new CurrentSlideHolder();
        return instance;
    }

}
