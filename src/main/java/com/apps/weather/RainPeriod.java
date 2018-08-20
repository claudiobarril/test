package com.apps.weather;

import com.apps.model.stars.SolarSystem;

public class RainPeriod extends Period {

    private long pinnacle;
    private long maxPerimeter;

    public RainPeriod(long firstDay, double maxPerimeter) {
        super(firstDay);
        this.pinnacle = firstDay;
        this.maxPerimeter = (long) maxPerimeter;
    }

    @Override
    public void update(SolarSystem solarSystem, long dayNumber) {
        super.update(solarSystem, dayNumber);
        final double currentPerimeter = solarSystem.getPerimeter();
        if (currentPerimeter > maxPerimeter) {
            this.maxPerimeter = (long) currentPerimeter;
            this.pinnacle = dayNumber;
        }
    }

    public long getPinnacle() {
        return pinnacle;
    }
}
