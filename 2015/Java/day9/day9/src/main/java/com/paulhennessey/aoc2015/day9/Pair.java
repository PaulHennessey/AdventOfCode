package com.paulhennessey.aoc2015.day9;

public class Pair 
{
    Location Start;
    Location End;
    
    public Pair(Location start, Location end) 
    {
        Start = start;
        End = end;  
    }

    @Override
    public boolean equals(Object o) 
    {
        if (o == this)
            return true;
        if (!(o instanceof Pair))
            return false;
        Pair other = (Pair)o;
        boolean startEqual = (this.Start == null && other.Start == null) || 
                                 (this.Start != null && this.Start.equals(other.Start));
        boolean endEqual = (this.End == null && other.End == null) || 
                                 (this.End != null && this.End.equals(other.End));

        return startEqual && endEqual;
    }    

    @Override
    public final int hashCode() 
    {
        int result = 17;
        if (Start != null) 
        {
            result = 31 * result + Start.hashCode();
        }
        if (End != null) 
        {
            result = 31 * result + End.hashCode();
        }

        return result;
    }            
}
