package com.myapp.collegesocial;

public class CollegeModel {

    String collegeName;
    int collegeImage;

    public CollegeModel(String collegeName, int collegeImage) {
        this.collegeName = collegeName;
        this.collegeImage = collegeImage;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public int getCollegeImage() {
        return collegeImage;
    }

    public void setCollegeImage(int collegeImage) {
        this.collegeImage = collegeImage;
    }
}
