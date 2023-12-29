package com.advent;

public class Part 
{
    public int X;
    public int M;
    public int A;
    public int S;

    public Part(String line) 
    {
         // trim off the braces
        line = line.substring(0, line.length()-1);
        line = line.substring(1);

        String[] categories = line.trim().split(",");

        X = Integer.parseInt(categories[0].substring(2));
        M = Integer.parseInt(categories[1].substring(2));
        A = Integer.parseInt(categories[2].substring(2));
        S = Integer.parseInt(categories[3].substring(2));
    }
    
    public int getTotalRatings()
    {
        return X + M + A + S;
    }
}
