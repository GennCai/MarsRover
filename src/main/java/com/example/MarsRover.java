package com.example;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MarsRover {
    private Direction direction;
    private Position position;

    public MarsRover(Position position, Direction direction) {
        this.position = position;
        this.direction = direction;
    }

    public static void main(String[] args) {

    }

    @Getter
    @Setter
    public static class Position {
        private int x;
        private int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object otherPosition) {
            Position other = (Position) otherPosition;
            return x == other.getX() && y == other.getY();
        }
    }

    public enum Direction {
        NORTH,
        SOUTH,
        EAST,
        WEST
    }
}
