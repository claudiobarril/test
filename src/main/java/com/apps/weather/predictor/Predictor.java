package com.apps.weather.predictor;

import com.apps.model.location.Position;
import com.apps.model.stars.SolarSystem;
import com.apps.weather.Weather;

import java.util.List;

public abstract class Predictor {

    private Weather weatherPredicted;

    public Predictor(Weather weatherPredicted) {
        this.weatherPredicted = weatherPredicted;
    }

    public Weather predict(SolarSystem solarSystem) {
        return satisfyPrediction(solarSystem.getPlanetPositions()) ? weatherPredicted : null;
    }

    protected abstract boolean satisfyPrediction(List<Position> positions);
}
