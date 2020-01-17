package com.example.command;

import com.example.MarsRover;
import com.example.RoverStatus;

public class TurnRight implements Command {

    public RoverStatus doOperation(RoverStatus status) {
        status.setFacing(status.getFacing().rightOne());
        return status;
    }
}
