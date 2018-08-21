package com.apps.model.location;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Incline {

    private double value;
    private boolean positive;

    public Incline(double value) {
        this.value = value;
        this.positive = value >= 0;
    }

    public Double getRoundedValue() {
        Double roundedValue = BigDecimal.valueOf(this.value).setScale(0, RoundingMode.HALF_UP).doubleValue();
        return roundedValue == Double.NEGATIVE_INFINITY ? Double.POSITIVE_INFINITY : roundedValue;
    }

    public boolean isPositive() {
        return positive;
    }

    public boolean equals(Incline incline) {
        return this.getRoundedValue().equals(incline.getRoundedValue()) && this.isPositive() == incline.isPositive();
    }
}
