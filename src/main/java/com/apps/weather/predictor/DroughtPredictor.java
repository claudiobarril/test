package com.apps.weather.predictor;

import com.apps.model.location.Position;
import com.apps.weather.Weather;

import java.util.List;

public class DroughtPredictor extends Predictor {

    public DroughtPredictor() {
        super(Weather.DROUGHT);
    }

    @Override
    protected boolean satisfyPrediction(List<Position> positions) {
        return positions.stream().allMatch(
                position -> positions.get(0).isAlignWithSun(position)
        );
    }
}
