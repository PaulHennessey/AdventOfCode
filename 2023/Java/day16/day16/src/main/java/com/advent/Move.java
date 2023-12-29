package com.advent;

public class Move 
{
    public int Row;
    public int Col;
    public Direction Direction;

    public Move(int row, int col, Direction direction) 
    {
        Row = row;
        Col = col;
        Direction = direction;
    }
}
