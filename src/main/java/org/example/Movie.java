package org.example;

public class Movie {
    private  String name; //영화 이름
    private String genre;// 장르
    private int runningTime; //상영 시간
    private int viewor;// 누적 관객수
    private int rating_Age;//영화 등급
    private double rating_Point;//영화 평점
    public Movie() {
    }
    public Movie(String name, String genre, int runningTime, int viewor, int rating_Age, double rating_Point){
        this.name = name;
        this.genre = genre;
        this.runningTime = runningTime;
        this.viewor = viewor;
        this.rating_Age = rating_Age;
        this. rating_Point= rating_Point;
    }
    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", genre='" + genre + '\'' +
                ", runningTime=" + runningTime +
                ", viewor=" + viewor +
                ", rating_Age=" + rating_Age +
                ", rating_Point=" + rating_Point +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getRunningTime() {
        return runningTime;
    }

    public void setRunningTime(int runningTime) {
        this.runningTime = runningTime;
    }

    public int getViewor() {
        return viewor;
    }

    public void setViewor(int viewor) {
        this.viewor = viewor;
    }

    public int getRating_Age() {
        return rating_Age;
    }

    public void setRating_Age(int rating_Age) {
        this.rating_Age = rating_Age;
    }

    public double getRating_Point() {
        return rating_Point;
    }

    public void setRating_Point(double rating_Point) {
        this.rating_Point = rating_Point;
    }
}
