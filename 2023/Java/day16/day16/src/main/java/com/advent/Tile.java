package com.advent;

public class Tile 
{
    public Type Type;
    public boolean energised = false;

    public Tile(Character c) 
    {
        Type = switch (c) 
                {
                    case '.' -> com.advent.Type.EMPTYSPACE;
                    case '/' -> com.advent.Type.RIGHTLEANINGMIRROR;
                    case '\\'-> com.advent.Type.LEFTLEANINGMIRROR;
                    case '|' -> com.advent.Type.VERTICALSPLITTER;
                    case '-' -> com.advent.Type.HORIZONTALSPLITTER;
                    default  -> com.advent.Type.EMPTYSPACE;
                };
    }

    public void energise()
    {
        energised = true;
    }
}
