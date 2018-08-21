package com.apps.weather.predictor;

import com.apps.model.location.Incline;
import com.apps.model.location.Position;
import com.apps.weather.Weather;

import java.util.List;

public class OptimalPredictor extends Predictor {
    public OptimalPredictor() {
        super(Weather.OPTIMAL);
    }

    @Override
    protected boolean satisfyPrediction(List<Position> positions) {
        final Position position1 = positions.get(0);
        final Position position2 = positions.get(1);
        final Position position3 = positions.get(2);
        final Incline inclinePositions12 = position1.getIncline(position2);
        return inclinePositions12.equals(position1.getIncline(position3))
                && inclinePositions12.equals(position2.getIncline(position3));
    }
}
