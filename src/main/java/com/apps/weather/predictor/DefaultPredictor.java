package com.apps.weather.predictor;

import com.apps.model.location.Position;
import com.apps.weather.Weather;

import java.util.List;

public class DefaultPredictor extends Predictor {
    public DefaultPredictor() {
        super(Weather.OTHER);
    }

    @Override
    protected boolean satisfyPrediction(List<Position> positions) {
        return true;
    }
}
