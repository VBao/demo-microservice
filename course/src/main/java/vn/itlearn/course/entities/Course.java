package vn.itlearn.course.entities;

import java.util.List;

public class Course {
    private int id;
    private List<Object> images;

    public Course() {
    }
    public Course(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Object> getImages() {
        return images;
    }

    public void setImages(List<Object> images) {
        this.images = images;
    }


}
