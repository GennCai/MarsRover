package com.example.command;

import com.example.MarsRover;
import com.example.RoverStatus;

public class Move implements Command {

    public RoverStatus doOperation(RoverStatus status) {
        switch (status.getFacing()){
            case EAST:
                status.setX(status.getX()+1);
                break;
            case SOUTH:
                status.setY(status.getY()-1);
                break;
            case WEST:
                status.setX(status.getX()-1);
                break;
            case NORTH:
                status.setY(status.getY()+1);
                break;
        }
        return status;
    }
}
