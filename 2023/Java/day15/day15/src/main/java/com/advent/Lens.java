package com.advent;

public class Lens 
{
    private String Label;
    private int FocalLength;

    public Lens(String label, int focalLength) 
    {
        Label = label;
        FocalLength = focalLength;
    }

    public String getLabel()
    {
        return this.Label;
    }

    public int getFocalLength()
    {
        return this.FocalLength;
    }

    public void setFocalLength(int f)
    {
        this.FocalLength = f;
    }
}
