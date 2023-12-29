package com.advent;

public class Race 
{
    private long Time;
    private long Record;

    public Race(long time, long record) 
    {
        Time = time;
        Record = record;
    }

    public long getTime()
    {
        return this.Time;
    }

    public long getRecord()
    {
        return this.Record;
    }
}
