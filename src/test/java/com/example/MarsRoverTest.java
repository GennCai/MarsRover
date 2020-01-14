package com.example;

import org.junit.Assert;
import org.junit.Test;

import static com.example.MarsRover.Position;
import static com.example.MarsRover.Direction;

public class MarsRoverTest {
    @Test
    public void should_init_position_and_direction() {
        Position position = new Position(3, 5);
        MarsRover marsRover = new MarsRover(position, Direction.SOUTH);

        Assert.assertEquals(marsRover.getPosition(), new Position(3,5));
        Assert.assertEquals(marsRover.getDirection(), Direction.SOUTH);
    }

    @Test
    public void move_method_test() {
        MarsRover northRover = new MarsRover( new Position(3, 5), Direction.NORTH);
        MarsRover southRover = new MarsRover( new Position(3, 5), Direction.SOUTH);
        MarsRover eastRover = new MarsRover( new Position(3, 5), Direction.EAST);
        MarsRover westRover = new MarsRover( new Position(3, 5), Direction.WEST);
        Position nPosition = northRover.move();
        Position sPosition = southRover.move();
        Position ePosition = eastRover.move();
        Position wPosition = westRover.move();

        Assert.assertEquals(nPosition, new Position(3, 6));
        Assert.assertEquals(sPosition, new Position(3, 4));
        Assert.assertEquals(ePosition, new Position(4, 5));
        Assert.assertEquals(wPosition, new Position(2, 5));
    }
}
