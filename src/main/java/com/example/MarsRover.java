package com.example;

import lombok.Getter;

@Getter
public class MarsRover {
    public static void main(String[] args) {

    }

    private Direction direction;
    private Position position;

    public MarsRover(Position position, Direction direction) {
        this.position = position;
        this.direction = direction;
    }

    public Position move() {
        switch (direction){
            case NORTH:
                position.y = position.y + 1;
                break;
            case SOUTH:
                position.y = position.y - 1;
                break;
            case EAST:
                position.x = position.x + 1;
                break;
            case WEST:
                position.x = position.x - 1;
                break;
        }
        return position;
    }

    @Getter
    public static class RoverState {
        private Position position;
        private Direction direction;

        public RoverState(int x, int y, Direction direction){
            new RoverState(new Position(x, y), direction);
        }

        public RoverState(Position position, Direction direction){
            this.position = position;
            this.direction = direction;
        }

        @Override
        public boolean equals(Object otherState) {
            if(otherState instanceof RoverState){
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
            if(otherPosition instanceof Position){
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
