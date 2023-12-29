package com.paulhennessey.aoc23.day22;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App 
{
    List<Brick> Bricks = new ArrayList<>();
    List<Brick> tryBricks = new ArrayList();

    public App(List<String> input)  
    {
        for(String line : input)
        {
            Bricks.add(new Brick(line));
        }

        Collections.sort(Bricks);
    }

    public void dropBricks()
    {
        for(Brick brick : Bricks)
        {
            dropBrick(brick);
        }
    }

    private void dropBrick(Brick brick)
    {
        if(brickAtBottom(brick) || brickSettled(brick))
        {
            return;
        }
        else 
        {
            brick.moveDown();
            dropBrick(brick);
        }
    }

    public boolean tryDropBricks()
    {
        for(Brick brick : tryBricks)
        {
            if(brickAtBottom(brick) || tryBrickSettled(brick))
            {
                continue;
            }
            else 
            {
                return true;
            }
        }
        return false;
    }
    
    public int countBricks()
    {
        int disintegrated = 0;
        
        for(int count = 0; count < Bricks.size(); count++)
        {
            copyBricks();
            tryBricks.remove(count);
            if(tryDropBricks())
            {
                disintegrated++;
            }
            tryBricks.removeAll(tryBricks);
        }

        return disintegrated;
    }

    private void copyBricks()
    {
        for(Brick brick : Bricks)
        {
            tryBricks.add(brick);
        }
    }

    private boolean brickAtBottom(Brick brick)
    {
        return brick.Cubes.get(0).getZ() == 1;
    }

    private boolean brickSettled(Brick brick)
    {
        boolean settled = false;

        for(Cube cube : brick.Cubes)
        {
            settled = cubeBelow(cube.getX(), cube.getY(), cube.getZ()-1);
            if(settled)
                break;
        }

        return settled;
    }

    private boolean tryBrickSettled(Brick brick)
    {
        boolean settled = false;

        for(Cube cube : brick.Cubes)
        {
            settled = tryCubeBelow(cube.getX(), cube.getY(), cube.getZ()-1);
        }

        return settled;
    }

    private boolean cubeBelow(int x, int y, int z)
    {
        for(Brick brick : Bricks)
        {
            for(Cube cube : brick.Cubes)
            {
                if(cube.matches(x,y,z))
                {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean tryCubeBelow(int x, int y, int z)
    {
        for(Brick brick : tryBricks)
        {
            for(Cube cube : brick.Cubes)
            {
                if(cube.matches(x,y,z))
                {
                    return true;
                }
            }
        }

        return false;
    }    
}
