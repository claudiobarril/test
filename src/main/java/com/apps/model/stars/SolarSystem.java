package com.apps.model.stars;

import com.apps.model.location.Position;
import com.google.common.collect.Lists;

import java.util.List;
import java.util.stream.Collectors;

public class SolarSystem {

    private Star star;
    private List<Planet> planets;

    public SolarSystem(Star star) {
        this.star = star;
        this.planets = Lists.newArrayList();
    }

    public void add(Planet planet) {
        this.planets.add(planet);
    }

    public void advance() {
        planets.forEach(Planet::advance);
    }

    public List<Planet> getPlanets() {
        return planets;
    }

    public Planet getFirst() {
        return planets.get(0);
    }

    public List<Position> getPlanetPositions() {
        return planets.stream().map(Planet::getPosition).collect(Collectors.toList());
    }

    public double getPerimeter() {
        final List<Position> positions = this.getPlanetPositions();
        double perimeter = 0;
        final int size = positions.size();
        for(int i = 0; i < size -1; i++) {
            perimeter += positions.get(i).getDistance(positions.get(i+1));
        }
        perimeter += positions.get(size-1).getDistance(positions.get(0));
        return perimeter;
    }
}
