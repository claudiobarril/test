package com.apps.weather.predictor;

import com.apps.model.location.Position;
import com.apps.weather.Weather;
import com.google.common.collect.Lists;

import java.util.List;

public class RainPredictor extends Predictor {
    public RainPredictor() {
        super(Weather.RAIN);
    }

    private boolean calculateStarOrientation(Position position1, Position position2) {
        return (position1.getX()*position2.getY()
                - position1.getY()*position2.getX()) >= 0;
    }

    private boolean calculateOrientation(Position position1, Position position2, Position position3) {
        double orientation = (position1.getX() - position3.getX())*(position2.getY() - position3.getY())
                - (position1.getY() - position3.getY())*(position2.getX() - position3.getX());
        return orientation >= 0;
    }

    @Override
    protected boolean satisfyPrediction(List<Position> positions) {
        final Position position1 = positions.get(0);
        final Position position2 = positions.get(1);
        final Position position3 = positions.get(2);
        final Boolean orientation = calculateOrientation(position1, position2, position3);
        List<Boolean> orientations = Lists.newArrayList();
        orientations.add(calculateStarOrientation(position1, position2));
        orientations.add(calculateStarOrientation(position2, position3));
        orientations.add(calculateStarOrientation(position3, position1));
        return orientations.stream().allMatch(o -> o.equals(orientation));
    }
}
