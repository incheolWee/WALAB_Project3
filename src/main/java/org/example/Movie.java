package org.example;

public class Movie {
    private int num; //순서
    private  String name; //영화 이름
    private String genre;// 장르
    private int runningTime; //상영 시간
    private int viewor;// 누적 관객수
    private String regDate;// 기록 날짜
    private double rating_Point;//영화 평점
    public Movie() {
    }
    public Movie(int num, String name, String genre, int runningTime, int viewor,double rating_Point,String regDate){
        this.num = num;
        this.name = name;
        this.genre = genre;
        this.runningTime = runningTime;
        this.viewor = viewor;
        this. rating_Point= rating_Point;
        this.regDate= regDate;
    }

    @Override
    public String toString() {
        return num+"\t"
                +name +"\t\t"+
                genre +"\t\t" +
                runningTime +"\t\t"+
                viewor+"M"+"\t\t"+
                regDate+"\t\t"+
                String.format("%.1f",rating_Point);
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
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


    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public double getRating_Point() {
        return rating_Point;
    }

    public void setRating_Point(double rating_Point) {
        this.rating_Point = rating_Point;
    }
}
