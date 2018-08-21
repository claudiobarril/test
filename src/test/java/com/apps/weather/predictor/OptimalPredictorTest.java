package com.apps.weather.predictor;

import com.apps.model.location.Position;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class OptimalPredictorTest {

    private OptimalPredictor predictor = new OptimalPredictor();

    @Test
    public void testSatisfyPredictionVerticalAlign() {
        List<Position> positions = Lists.newArrayList();
        positions.add(new Position(d(1), d(-1)));
        positions.add(new Position(d(1), d(10)));
        positions.add(new Position(d(1), d(-4)));

        assertTrue(predictor.satisfyPrediction(positions));
    }

    @Test
    public void testSatisfyPredictionHorizontalAlign() {
        List<Position> positions = Lists.newArrayList();
        positions.add(new Position(d(20), d(-4)));
        positions.add(new Position(d(-4), d(-4)));
        positions.add(new Position(d(10), d(-4)));

        assertTrue(predictor.satisfyPrediction(positions));
    }

    @Test
    public void testSatisfyPredictionOtherAlign() {
        List<Position> positions = Lists.newArrayList();
        positions.add(new Position(d(2), d(8)));
        positions.add(new Position(d(-6), d(-4)));
        positions.add(new Position(d(-2), d(2)));
        assertTrue(predictor.satisfyPrediction(positions));
        positions.clear();

        positions.add(new Position(d(-1), d(2)));
        positions.add(new Position(d(-4), d(5)));
        positions.add(new Position(d(-3), d(4)));
        assertTrue(predictor.satisfyPrediction(positions));
        positions.clear();

        positions.add(new Position(d(-3), d(-8)));
        positions.add(new Position(d(-2), d(-3)));
        positions.add(new Position(d(-1), d(2)));
        assertTrue(predictor.satisfyPrediction(positions));
        positions.clear();

        positions.add(new Position(d(4), d(-10)));
        positions.add(new Position(d(2), d(-5)));
        positions.add(new Position(d(8), d(-20)));
        assertTrue(predictor.satisfyPrediction(positions));
    }

    @Test
    public void testNotSatisfyPrediction() {
        List<Position> positions = Lists.newArrayList();
        positions.add(new Position(d(-4), d(-4)));
        positions.add(new Position(d(-30), d(4)));
        positions.add(new Position(d(30), d(-4)));
        assertFalse(predictor.satisfyPrediction(positions));
        positions.clear();

        positions.add(new Position(d(1), d(-6)));
        positions.add(new Position(d(1), d(4)));
        positions.add(new Position(d(-1), d(-4)));
        assertFalse(predictor.satisfyPrediction(positions));
    }

    private double d(int value) {
        return value;
    }

}