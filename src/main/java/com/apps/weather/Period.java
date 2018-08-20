package com.apps.weather;

import com.apps.model.stars.SolarSystem;

public class Period {

    private long firstDay;
    private long lastDay;
    private long durationInDays;

    public Period(long firstDay) {
        this.firstDay = firstDay;
        this.durationInDays = 1;
    }

    public long getLastDay() {
        return lastDay;
    }

    public void setLastDay(long lastDay) {
        this.lastDay = lastDay;
        this.durationInDays = lastDay - firstDay;
    }

    public long getFirstDay() {
        return firstDay;
    }

    public void setFirstDay(long firstDay) {
        this.firstDay = firstDay;
    }

    public long getDurationInDays() {
        return this.durationInDays;
    }

    public void update(SolarSystem solarSystem, long dayNumber) {
        this.durationInDays++;
    }
}
