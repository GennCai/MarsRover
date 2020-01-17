package com.example.command;

import com.example.MarsRover;
import com.example.RoverStatus;

public class TurnLeft implements Command {

    public RoverStatus doOperation(RoverStatus status) {
        status.setFacing(status.getFacing().leftOne());
        return status;
    }
}
