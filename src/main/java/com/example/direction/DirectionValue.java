package com.example.direction;

public enum DirectionValue {
    EAST(0),
    SOUTH(1),
    WEST(2),
    NORTH(3);

    private int index;

    DirectionValue(int index) {
        this.index = index % 4;
    }

    private DirectionValue of(int index) {
        switch (index) {
            case 0:
                return DirectionValue.EAST;
            case 1:
                return DirectionValue.SOUTH;
            case 2:
                return DirectionValue.WEST;
            case 3:
                return DirectionValue.NORTH;
        }
        return DirectionValue.EAST;
    }

    public DirectionValue rightOne() {
        return this.of((this.index + 1) % 4);
    }

    public DirectionValue leftOne() {
        return this.of((this.index + 3) % 4);
    }

}
