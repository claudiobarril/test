package com.apps.model.location;

public class ClockWise extends Orbit {
    public ClockWise(Integer distanceFromStar, Integer angularVelocity) {
        super(distanceFromStar, angularVelocity);
    }

    @Override
    public void updateAngle() {
        Integer newAngle = this.getAngle() + this.getAngularVelocity();
        this.setAngle(newAngle > 180 ? newAngle - 360 : newAngle);
    }
}
