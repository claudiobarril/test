package com.apps.weather.predictor;

import com.apps.model.location.Position;
import com.apps.weather.Weather;

import java.util.List;

public class OptimalPredictor extends Predictor {
    public OptimalPredictor() {
        super(Weather.OPTIMAL);
    }

    @Override
    protected boolean satisfyPrediction(List<Position> positions) {
        final Position firstPosition = positions.get(0);
        double incline = firstPosition.getIncline(positions.get(1));
        final List<Position> remainPositions = positions.subList(2, positions.size());
        return remainPositions.stream().allMatch(
                position -> incline == firstPosition.getIncline(position)
        );
    }
}
