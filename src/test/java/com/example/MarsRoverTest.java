package com.example;

import org.junit.Assert;
import org.junit.Test;

import static com.example.MarsRover.Position;
import static com.example.MarsRover.Direction;
import static com.example.MarsRover.RoverState;

public class MarsRoverTest {
    
    @Test
    public void should_init_position_and_direction() {
        MarsRover marsRover = new MarsRover( new RoverState(3, 5, Direction.SOUTH));
        Assert.assertEquals(new RoverState(3, 5, Direction.SOUTH), marsRover.getState());
    }

    @Test
    public void move_method_test() {
        MarsRover northRover = new MarsRover(new RoverState(3, 5, Direction.NORTH));
        MarsRover southRover = new MarsRover(new RoverState(3, 5, Direction.SOUTH));
        MarsRover eastRover = new MarsRover(new RoverState(3, 5, Direction.EAST));
        MarsRover westRover = new MarsRover(new RoverState(3, 5, Direction.WEST));
        RoverState nRoverState = northRover.move();
        RoverState sRoverState = southRover.move();
        RoverState eRoverState = eastRover.move();
        RoverState wRoverState = westRover.move();

        Assert.assertEquals(new RoverState(3, 6, Direction.NORTH), nRoverState);
        Assert.assertEquals(new RoverState(3, 4, Direction.SOUTH), sRoverState);
        Assert.assertEquals(new RoverState(4, 5, Direction.EAST), eRoverState);
        Assert.assertEquals(new RoverState(2, 5, Direction.WEST), wRoverState);
    }

    @Test
    public void turn_right_method_test() {
        MarsRover northRover = new MarsRover(new RoverState(3, 5, Direction.NORTH));
        MarsRover southRover = new MarsRover(new RoverState(3, 5, Direction.SOUTH));
        MarsRover eastRover = new MarsRover(new RoverState(3, 5, Direction.EAST));
        MarsRover westRover = new MarsRover(new RoverState(3, 5, Direction.WEST));
        RoverState nRoverState = northRover.turnRight();
        RoverState sRoverState = southRover.turnRight();
        RoverState eRoverState = eastRover.turnRight();
        RoverState wRoverState = westRover.turnRight();

        Assert.assertEquals(Direction.NORTH, wRoverState.getDirection());
        Assert.assertEquals(Direction.SOUTH, eRoverState.getDirection());
        Assert.assertEquals(Direction.EAST, nRoverState.getDirection());
        Assert.assertEquals(Direction.WEST, sRoverState.getDirection());
    }

    @Test
    public void turn_left_method_test() {
        MarsRover northRover = new MarsRover(new RoverState(3, 5, Direction.NORTH));
        MarsRover southRover = new MarsRover(new RoverState(3, 5, Direction.SOUTH));
        MarsRover eastRover = new MarsRover(new RoverState(3, 5, Direction.EAST));
        MarsRover westRover = new MarsRover(new RoverState(3, 5, Direction.WEST));
        RoverState nRoverState = northRover.turnLeft();
        RoverState sRoverState = southRover.turnLeft();
        RoverState eRoverState = eastRover.turnLeft();
        RoverState wRoverState = westRover.turnLeft();

        Assert.assertEquals(Direction.SOUTH, wRoverState.getDirection());
        Assert.assertEquals(Direction.NORTH, eRoverState.getDirection());
        Assert.assertEquals(Direction.WEST, nRoverState.getDirection());
        Assert.assertEquals(Direction.EAST, sRoverState.getDirection());
    }

}
