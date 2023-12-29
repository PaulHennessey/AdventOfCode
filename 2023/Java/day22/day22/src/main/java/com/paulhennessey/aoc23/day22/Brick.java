package com.paulhennessey.aoc23.day22;

import java.util.ArrayList;
import java.util.List;

public class Brick implements Comparable<Brick>
{
    List<Cube> Cubes = new ArrayList<>();

    Brick(String line) 
    {
        String[] cubes = line.trim().split("~");

        String[] start = cubes[0].trim().split(",");
        String[] end = cubes[1].trim().split(",");

        if(!start[0].equals(end[0]))
        {
            for(int x = Integer.parseInt(start[0]); x <= Integer.parseInt(end[0]); x++)
            {
                Cubes.add(new Cube(x, Integer.parseInt(start[1]), Integer.parseInt(start[2])));
            }
        }
        else if(!start[1].equals(end[1]))
        {
            for(int y = Integer.parseInt(start[1]); y <= Integer.parseInt(end[1]); y++)
            {
                Cubes.add(new Cube(Integer.parseInt(start[0]), y, Integer.parseInt(start[2])));
            }
        }        
        else if(!start[2].equals(end[2]))
        {
            for(int z = Integer.parseInt(start[2]); z <= Integer.parseInt(end[2]); z++)
            {
                Cubes.add(new Cube(Integer.parseInt(start[0]), Integer.parseInt(start[1]), z));
            }
        }            
    }

    public void moveDown()
    {
        for(Cube cube : Cubes)
        {
            cube.moveDown();
        }
    }

    @Override
    public int compareTo(Brick brick) 
    {
        int thisz = this.Cubes.get(this.Cubes.size() - 1).getZ();
        int otherz = brick.Cubes.get(brick.Cubes.size() - 1).getZ();

        if(thisz == otherz)
        {
            return 0;
        }
        else if(thisz > otherz)
        {
            return 1;
        }
        else
        {
            return -1;
        }
    }        
}
