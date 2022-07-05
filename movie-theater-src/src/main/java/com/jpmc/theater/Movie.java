package com.jpmc.theater;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Objects;

public class Movie {
    private static int MOVIE_CODE_SPECIAL = 1;

    private String title;
    private String description;
    private Duration runningTime;
    private double ticketPrice;
    private int specialCode;

    public Movie(String title, Duration runningTime, double ticketPrice, int specialCode) {
        this.title = title;
        this.runningTime = runningTime;
        this.ticketPrice = ticketPrice;
        this.specialCode = specialCode;
    }

    public String getTitle() {
        return title;
    }

    public Duration getRunningTime() {
        return runningTime;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public double calculateTicketPrice(int sequenceOfTheDay, LocalDateTime showStartTime) {

        return ticketPrice - getDiscount(sequenceOfTheDay, showStartTime.getHour());
    }

    private double getDiscount(int showSequence, int showHour) {

        double specialDiscount = 0;
        // as 25 % has higher discount  checking for the 11th and 16th hour else check for special code
        // this is done to avoid to maintain 2 different variables
        if (showHour >= 11 && showHour <= 16) {
            specialDiscount =   ticketPrice * 0.25;
        }
        else if (MOVIE_CODE_SPECIAL == specialCode) {
            specialDiscount = ticketPrice * 0.2;  // 20% discount for special movie
        }

        double sequenceDiscount = 0;
        if (showSequence == 1) {
            sequenceDiscount = 3; // $3 discount for 1st show
        } else if (showSequence == 2) {
            sequenceDiscount = 2; // $2 discount for 2nd show
        }
        else if (showSequence==7){
            sequenceDiscount = 1; //7th movie gets $1 discount
        }

//        else {
//            throw new IllegalArgumentException("failed exception");
//        }

        // biggest discount wins
        return specialDiscount > sequenceDiscount ? specialDiscount : sequenceDiscount ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Double.compare(movie.ticketPrice, ticketPrice) == 0
                && Objects.equals(title, movie.title)
                && Objects.equals(description, movie.description)
                && Objects.equals(runningTime, movie.runningTime)
                && Objects.equals(specialCode, movie.specialCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, runningTime, ticketPrice, specialCode);
    }
}