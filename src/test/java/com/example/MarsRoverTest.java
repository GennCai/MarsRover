package com.example;

import org.junit.Assert;
import org.junit.Test;

import static com.example.MarsRover.Position;
import static com.example.MarsRover.Direction;
import static com.example.MarsRover.RoverState;

public class MarsRoverTest {
    @Test
    public void should_init_position_and_direction() {

        RoverState roverState = new RoverState(3, 5, Direction.SOUTH);
        MarsRover marsRover = new MarsRover(roverState);

        Assert.assertEquals(new RoverState(3, 5, Direction.SOUTH), marsRover.getState());
    }

    @Test
    public void move_method_test() {
        MarsRover northRover = new MarsRover( new RoverState(3, 5, Direction.NORTH));
        MarsRover southRover = new MarsRover( new RoverState(3, 5, Direction.SOUTH));
        MarsRover eastRover = new MarsRover( new RoverState(3, 5, Direction.EAST));
        MarsRover westRover = new MarsRover( new RoverState(3, 5, Direction.WEST));
        RoverState nRoverState = northRover.move();
        RoverState sRoverState = southRover.move();
        RoverState eRoverState = eastRover.move();
        RoverState wRoverState = westRover.move();

        Assert.assertEquals(nRoverState, new RoverState(3, 6, Direction.NORTH));
        Assert.assertEquals(sRoverState, new RoverState(3, 4, Direction.SOUTH));
        Assert.assertEquals(eRoverState, new RoverState(4, 5, Direction.EAST));
        Assert.assertEquals(wRoverState, new RoverState(2, 5, Direction.WEST));
    }
}
