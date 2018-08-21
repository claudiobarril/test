package com.apps.util;

import com.apps.model.stars.Planet;
import com.apps.model.stars.SolarSystem;

import java.util.List;

public class SolarSystemPrinter {

    public static void printSystemLocations(SolarSystem solarSystem) {
        List<Planet> planets = solarSystem.getPlanets();
        printPlanetLocation(planets.get(0));
        printPlanetLocation(planets.get(1));
        printPlanetLocation(planets.get(2));
    }

    public static void printPlanetLocation(Planet planet) {
        System.out.println("Angle: " + planet.getAngle() + " X: " + planet.getX() + " Y: " + planet.getY());
    }
}
