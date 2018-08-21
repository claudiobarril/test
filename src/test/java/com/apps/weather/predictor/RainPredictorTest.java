package com.apps.weather.predictor;

import com.apps.model.location.Position;
import com.apps.weather.predictor.RainPredictor;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RainPredictorTest {

    private RainPredictor predictor = new RainPredictor();

    @Test
    public void testSatisfyPrediction() {
        List<Position> positions = Lists.newArrayList();
        positions.add(new Position(d(1), d(0)));
        positions.add(new Position(d(0), d(1)));
        positions.add(new Position(d(-1), d(-1)));
        assertTrue(predictor.satisfyPrediction(positions));
        positions.clear();

        positions.add(new Position(d(3), d(-1)));
        positions.add(new Position(d(-3), d(1)));
        positions.add(new Position(d(-5), d(-5)));
        assertTrue(predictor.satisfyPrediction(positions));
        positions.clear();

        positions.add(new Position(d(-3), d(1)));
        positions.add(new Position(d(-2), d(0)));
        positions.add(new Position(d(1), d(0)));
        assertTrue(predictor.satisfyPrediction(positions));
    }

    @Test
    public void testNotSatisfyPrediction() {
        List<Position> positions = Lists.newArrayList();
        positions.add(new Position(d(1), d(0)));
        positions.add(new Position(d(0), d(1)));
        positions.add(new Position(0.5, 0.5));
        assertFalse(predictor.satisfyPrediction(positions));
        positions.clear();

        positions.add(new Position(d(3), d(-1)));
        positions.add(new Position(d(-2), d(1)));
        positions.add(new Position(d(5), d(5)));
        assertFalse(predictor.satisfyPrediction(positions));
        positions.clear();

        positions.add(new Position(d(5), d(-10)));
        positions.add(new Position(d(-2), d(-2)));
        positions.add(new Position(2.5, d(3)));
        assertFalse(predictor.satisfyPrediction(positions));
    }

    private double d(int value) {
        return value;
    }
}