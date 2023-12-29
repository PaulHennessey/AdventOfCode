package com.paulhennessey.aoc23.day22;

public class Cube 
{
    private int X;
    private int Y;
    private int Z;
    
    public Cube(String line)
    {
        String[] coords = line.trim().split(",");
        X = Integer.parseInt(coords[0]);
        Y = Integer.parseInt(coords[1]);
        Z = Integer.parseInt(coords[2]);
    }

    public Cube(int x, int y, int z) 
    {
        this.X = x;
        this.Y = y;
        this.Z = z;
    }

    public void setX(int x)
    {
        this.X = x;
    }

    public void setY(int y)
    {
        this.Y = y;
    }
    
    public void setZ(int z)
    {
        this.Z = z;
    }    

    public int getX()
    {
        return this.X;
    }

    public int getY()
    {
        return this.Y;
    }
    
    public int getZ()
    {
        return this.Z;
    }    

    public void moveDown()
    {
        this.Z = this.Z - 1;
    }

    public boolean matches(int x, int y, int z)
    {
        return this.X == x && this.Y == y && this.Z == z;
    }
}
