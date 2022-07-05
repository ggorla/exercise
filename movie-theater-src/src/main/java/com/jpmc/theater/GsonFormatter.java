package com.jpmc.theater;

import java.time.LocalDateTime;

public class GsonFormatter {
    private int sequenceOfTheDay = 0;
    private LocalDateTime startTime ;
    private  String movieTitle;
    private String runTime;
    private double movieFee;

    public GsonFormatter(int sequenceOfTheDay, LocalDateTime startTime, String movieTitle, String runTime, double movieFee) {
        this.sequenceOfTheDay = sequenceOfTheDay;
        this.startTime = startTime;
        this.movieTitle = movieTitle;
        this.runTime = runTime;
        this.movieFee = movieFee;
    }

    public int getSequenceOfTheDay() {
        return sequenceOfTheDay;
    }

    public void setSequenceOfTheDay(int sequenceOfTheDay) {
        this.sequenceOfTheDay = sequenceOfTheDay;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getRunTime() {
        return runTime;
    }

    public void setRunTime(String runTime) {
        this.runTime = runTime;
    }

    public double getMovieFee() {
        return movieFee;
    }

    public void setMovieFee(double movieFee) {
        this.movieFee = movieFee;
    }
}
