package com.example;

import org.junit.Assert;
import org.junit.Test;

import static com.example.MarsRover.Position;
import static com.example.MarsRover.Direction;

public class MarsRoverTest {
    @Test
    public void should_init_position_and_direction() {
        Position position = new Position(3, 5);
        Direction south = Direction.SOUTH;
        MarsRover marsRover = new MarsRover(position, south);
        Assert.assertEquals(marsRover.getPosition(), new Position(3,5));
        Assert.assertEquals(marsRover.getDirection(), Direction.SOUTH);
    }
}
