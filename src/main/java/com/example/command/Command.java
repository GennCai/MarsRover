package com.example.command;

import com.example.MarsRover;
import com.example.RoverStatus;

public interface Command {
    RoverStatus doOperation(RoverStatus status);
}
