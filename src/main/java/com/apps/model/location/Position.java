package com.apps.model.location;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Position {

    private int x;
    private int y;
    private Integer angle;
    private final double distanceFromStar;

    public Position(int angle, double distanceFromStar) {
        this.angle = angle;
        this.distanceFromStar = distanceFromStar;
        this.updateCoordinates();
    }

    public Position(double x, double y) {
        setX(x);
        setY(y);
        this.distanceFromStar = Math.sqrt(Math.pow(this.getX(), 2) + Math.pow(this.getY(), 2));
        this.updateAngle();
    }

    private void updateAngle() {
        this.angle = (int) Math.toDegrees(Math.atan(this.getX()/this.getY()));
    }

    public void updateCoordinates() {
        double radians = Math.toRadians(this.getAngle());
        setX(Math.sin(radians)*distanceFromStar);
        setY(Math.cos(radians)*distanceFromStar);
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = (int) Math.round(x);
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = (int) Math.round(y);
    }

    public Integer getAngle() {
        return angle;
    }

    public void setAngle(Integer angle) {
        this.angle = angle;
    }

    public Incline getIncline(Position position) {
        final double incline = (this.getY() - position.getY()) / (this.getX() - position.getX());
        return new Incline(incline);
        //return roundedIncline == Double.NEGATIVE_INFINITY ? Double.POSITIVE_INFINITY : roundedIncline;
    }

    public boolean isAlignWithSun(Position position) {
        return this.getAngle().equals(position.getAngle())
                || this.getAngle() + 180 == position.getAngle()
                || this.getAngle() == position.getAngle() + 180;
    }

    public double getDistance(Position position) {
        return Math.sqrt(Math.pow(position.getX() - this.getX(), 2) + Math.pow(position.getY() - this.getY(), 2));
    }
}
