package com.apps.model.location;

public abstract class Orbit {

    private final Integer distanceFromStar;
    private final Integer angularVelocity;
    private final Position position;

    public Orbit(Integer distanceFromStar, Integer angularVelocity) {
        this.distanceFromStar = distanceFromStar;
        this.angularVelocity = angularVelocity;
        this.position = new Position(0, distanceFromStar);
        this.position.updateCoordinates();
    }

    public void advance() {
        this.updateAngle();
        this.position.updateCoordinates();
    }

    public abstract void updateAngle();

    public Integer getAngularVelocity() {
        return angularVelocity;
    }

    public Position getPosition() {
        return position;
    }

    public Integer getAngle() {
        return position.getAngle();
    }

    public Integer getDistanceFromStar() {
        return distanceFromStar;
    }

    public void setAngle(Integer angle) {
        this.position.setAngle(angle);
    }

    public double getX() {
        return position.getX();
    }

    public double getY() {
        return position.getY();
    }
}
