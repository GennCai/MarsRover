package com.example;

import com.example.command.Command;
import lombok.Getter;


@Getter
public class MarsRover {
    public static void main(String[] args) {

    }

    private final RoverStatus status;

    public MarsRover(RoverStatus status) {
        this.status = status;
    }

    public void executeCommand(Command command) {
        command.doOperation(status);
    }
}
