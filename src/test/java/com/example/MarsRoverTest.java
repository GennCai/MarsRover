package com.example;

import com.example.command.Move;
import com.example.command.TurnLeft;
import com.example.command.TurnRight;
import com.example.direction.DirectionValue;
import org.junit.Assert;
import org.junit.Test;

public class MarsRoverTest {
    MarsRover marsRover;
    RoverStatus status;

    @Test
    public void basic_test() {
        status = new RoverStatus(0, 0, DirectionValue.NORTH);
        marsRover = new MarsRover(status);
        marsRover.executeCommand(new Move());
        Assert.assertEquals(status.getY(), 1);

        marsRover.executeCommand(new TurnRight());
        Assert.assertEquals(status.getFacing(), DirectionValue.EAST);

        marsRover.executeCommand(new Move());
        Assert.assertEquals(status.getX(), 1);

        marsRover.executeCommand(new TurnLeft());
        Assert.assertEquals(status.getFacing(), DirectionValue.NORTH);

        marsRover.executeCommand(new Move());
        Assert.assertEquals(status.getY(), 2);

        marsRover.executeCommand(new TurnLeft());
        Assert.assertEquals(status.getFacing(), DirectionValue.WEST);

        marsRover.executeCommand(new Move());
        marsRover.executeCommand(new Move());
        Assert.assertEquals(status.getX(), -1);
    }
}
