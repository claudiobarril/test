package com.apps.util;

import com.apps.model.location.Position;
import com.google.common.collect.Lists;

import java.util.List;
import java.util.Map;

public class PositionBuilder {
    public static List<Position> buildPositions(Map<Integer, Integer> positionsMap) {
        List<Position> positions = Lists.newArrayList();
        for (Integer distanceFromStar : positionsMap.keySet()) {
            positions.add(new Position(positionsMap.get(distanceFromStar), distanceFromStar));
        }
        return positions;
    }

}
