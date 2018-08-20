package com.apps.weather.predictor;

import com.apps.model.location.Position;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static com.apps.util.PositionBuilder.buildPositions;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DroughtPredictorTest {

    private DroughtPredictor predictor = new DroughtPredictor();

    @Test
    public void testSatisfyPrediction() {
        assertTrue(predictor.satisfyPrediction(buildPositions(
                ImmutableMap.of(1000, 0, 100, 180, 10, 180)
        )));
        assertTrue(predictor.satisfyPrediction(buildPositions(
                ImmutableMap.of(1000, 50, 10, 50, 100, 50)
        )));
        assertFalse(predictor.satisfyPrediction(buildPositions(
                ImmutableMap.of(5, 0, 150, 90, 100, 180)
        )));
        assertTrue(predictor.satisfyPrediction(buildPositions(
                ImmutableMap.of(1, 10, 2, -170, 3, 10, 4, -170, 5, 10)
        )));
        assertFalse(predictor.satisfyPrediction(buildPositions(
                ImmutableMap.of(1000, 0, 100, 80, 10, 80, 200, 80, 567, 80)
        )));
    }

}