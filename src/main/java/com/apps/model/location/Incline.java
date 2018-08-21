package com.apps.model.location;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Incline {

    private double value;
    private boolean positive;

    public Incline(double value) {
        this.value = value;
        this.positive = value >= 0 || this.value == Double.NEGATIVE_INFINITY;
    }

    public Double getRoundedValue() {
        if (this.value == Double.NEGATIVE_INFINITY || this.value == Double.POSITIVE_INFINITY) {
            return Double.POSITIVE_INFINITY;
        } else {
            return BigDecimal.valueOf(this.value).setScale(0, RoundingMode.HALF_UP).doubleValue();
        }
    }

    public boolean isPositive() {
        return positive;
    }

    public boolean equals(Incline incline) {
        return this.getRoundedValue().equals(incline.getRoundedValue()) && this.isPositive() == incline.isPositive();
    }
}
