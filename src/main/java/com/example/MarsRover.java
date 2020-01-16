package com.example;

import com.sun.deploy.util.StringUtils;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;


@Getter
public class MarsRover {
    public static void main(String[] args) {
        MarsRover northRover = new MarsRover(new RoverState(3, 5, Direction.NORTH));
        System.out.println(northRover.getState());
        northRover.move();
        System.out.println(northRover.getState());
    }

    private final RoverState state;
    private final List<String> instruction = new ArrayList<String>();

    public MarsRover(RoverState state) {
        this.state = state;
    }


    public RoverState move() {
        instruction.add("M");
        Position position = state.getPosition();
        switch (state.getDirection()) {
            case NORTH:
                state.updatePositionY(position.getY() + 1);
                break;
            case SOUTH:
                state.updatePositionY(position.getY() - 1);
                break;
            case EAST:
                state.updatePositionX(position.getX() + 1);
                break;
            case WEST:
                state.updatePositionX(position.getX() - 1);
                break;
        }
        return state;
    }

    public RoverState turnRight() {
        instruction.add("R");
        switch (state.getDirection()) {
            case NORTH:
                state.updateDirection(Direction.EAST);
                break;
            case SOUTH:
                state.updateDirection(Direction.WEST);
                break;
            case EAST:
                state.updateDirection(Direction.SOUTH);
                break;
            case WEST:
                state.updateDirection(Direction.NORTH);
                break;
        }
        return state;
    }

    public RoverState turnLeft() {
        instruction.add("L");
        switch (state.getDirection()) {
            case NORTH:
                state.updateDirection(Direction.WEST);
                break;
            case SOUTH:
                state.updateDirection(Direction.EAST);
                break;
            case EAST:
                state.updateDirection(Direction.NORTH);
                break;
            case WEST:
                state.updateDirection(Direction.SOUTH);
                break;
        }
        return state;
    }

    public void clearInstructions() {
        instruction.clear();
    }

    public String showInstructions() {
        return StringUtils.join(instruction, "");
    }

    public void continueMove(int time) {

        for (int i = 0; i < time; i++) {
            move();
        }
    }

    public void turnBack() {
        turnRight();
        turnRight();
    }

    public RoverState moveTo(Position targetPosition) {
        Position currentPosition = state.getPosition();
        int deltaPositionX = targetPosition.getX() - currentPosition.getX();
        int deltaPositionY = targetPosition.getY() - currentPosition.getY();
        switch (state.getDirection()) {
            case NORTH:
                if (deltaPositionY < 0) {
                    turnBack();
                }
                continueMove(Math.abs(deltaPositionY));
                break;
            case SOUTH:
                if (deltaPositionY > 0) {
                    turnBack();
                }
                continueMove(Math.abs(deltaPositionY));
                break;
            case EAST:
                if (deltaPositionX < 0) {
                    turnBack();
                }
                continueMove(Math.abs(deltaPositionX));
                break;
            case WEST:
                if (deltaPositionX > 0) {
                    turnBack();
                }
                continueMove(Math.abs(deltaPositionX));
                break;
        }
        return state;
    }

    @Getter
    public static class RoverState {
        private Position position;
        private Direction direction;

        public RoverState(int x, int y, Direction direction) {
            this(new Position(x, y), direction);
        }

        public RoverState(Position position, Direction direction) {
            this.position = position;
            this.direction = direction;
        }

        public RoverState updateDirection(Direction direction) {
            this.direction = direction;
            return this;
        }

        public RoverState updatePosition(Position position) {
            this.position = position;
            return this;
        }

        public RoverState updatePositionX(int x) {
            this.position.x = x;
            return this;
        }

        public RoverState updatePositionY(int y) {
            this.position.y = y;
            return this;
        }

        @Override
        public boolean equals(Object otherState) {
            if (otherState instanceof RoverState) {
                RoverState other = (RoverState) otherState;
                return position.equals(other.getPosition()) && direction.equals(other.getDirection());
            }
            return false;
        }

        @Override
        public String toString() {
            return "RoverState{" +
                    "position=" + position +
                    ", direction=" + direction +
                    '}';
        }
    }

    @Getter
    public static class Position {
        private int x;
        private int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object otherPosition) {
            if (otherPosition instanceof Position) {
                Position other = (Position) otherPosition;
                return x == other.x && y == other.y;
            }
            return false;
        }

        @Override
        public String toString() {
            return "{x=" + x + ", y=" + y + "}";
        }
    }

    public enum Direction {
        NORTH,
        SOUTH,
        EAST,
        WEST
    }
}
