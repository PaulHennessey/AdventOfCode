package com.paulhennessey.aoc2015.day14;

public class Reindeer
{
    public boolean Flying;
    public String Name;
    public int Speed;
    public int FlyTime;
    public int RestTime;
    public int DistanceTravelled = 0;
    public int TimeInFlight = 0;
    public int TimeAtRest = 0;
    public int Points = 0;

    public Reindeer(String name, int speed, int flyTime, int restTime)
    {
        Name = name;
        Speed = speed;
        FlyTime = flyTime;
        RestTime = restTime;
        Flying = true;
    }

    public int getPoints()
    {
        return Points;
    }

    public int getDistanceTravelled()
    {
        return DistanceTravelled;
    }

    public void calculateCurrentPosition(int second)
    {
        if(Flying)
        {
            DistanceTravelled += Speed;
            TimeInFlight++;
            if(TimeInFlight == FlyTime)
            {
                Flying = false;
                TimeInFlight = 0;
            }
        }
        else
        {
            TimeAtRest++;
            if(TimeAtRest == RestTime)
            {
                Flying = true;
                TimeAtRest = 0;
            }
        }
    }
}
