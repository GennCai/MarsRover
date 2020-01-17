package com.example;

import com.example.direction.DirectionValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RoverStatus {

    private int x;
    private int y;
    private DirectionValue facing;
}
