package com.apps.model.stars;

import com.apps.model.location.Orbit;
import com.apps.model.location.Position;

public class Planet {

    private Star star;
    private Orbit orbit;

    public Planet(Star star, Orbit orbit) {
        this.star = star;
        this.orbit = orbit;
    }

    public void advance() {
        this.orbit.advance();
    }

    public int getAngle() {
        return this.orbit.getAngle();
    }

    public double getX() {
        return this.orbit.getX();
    }

    public double getY() {
        return this.orbit.getY();
    }

    public Position getPosition() {
        return orbit.getPosition();
    }
}
