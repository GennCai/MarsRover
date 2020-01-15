package com.example;

import lombok.Getter;

@Getter
public class MarsRover {
    public static void main(String[] args) {
        MarsRover northRover = new MarsRover( new RoverState(3, 5, Direction.NORTH));
        System.out.println(northRover.getState());
        northRover.move();
        System.out.println(northRover.getState());
    }

    private final RoverState state;

    public MarsRover(RoverState state) {
        this.state = state;
    }

    public RoverState move() {
        Position position = state.getPosition();
        switch (state.getDirection()){
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

    @Getter
    public static class RoverState {
        private Position position;
        private Direction direction;

        public RoverState(int x, int y, Direction direction){
             this(new Position(x, y), direction);
        }

        public RoverState(Position position, Direction direction){
            this.position = position;
            this.direction = direction;
        }

        public RoverState updateDirection(Direction direction){
            this.direction = direction;
            return this;
        }

        public RoverState updatePosition(Position position){
            this.position = position;
            return this;
        }

        public RoverState updatePositionX(int x){
            this.position.x = x;
            return this;
        }

        public RoverState updatePositionY(int y){
            this.position.y = y;
            return this;
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
