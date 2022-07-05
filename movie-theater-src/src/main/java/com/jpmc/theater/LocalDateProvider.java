package com.jpmc.theater;

import java.time.LocalDate;

//making changes for thread safe
public class LocalDateProvider {
    private static volatile LocalDateProvider instance = null;

    /**
     * @return make sure to return singleton instance
     */


    public static LocalDateProvider singleton() {
        // Adding synchronized make sure if there are more than one class instance this singleton
        // As synchronized is expensive process we need not check for every instance we create hence null check
        if(instance==null) {
            synchronized (LocalDateProvider.class) {
                if (instance == null) {
                    instance = new LocalDateProvider();
                }
            }
        }
            return instance;
    }

    public LocalDate currentDate() {
            return LocalDate.now();
    }
}
