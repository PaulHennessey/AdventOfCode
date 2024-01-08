package com.paulhennessey.aoc2015.day9;

public class Location 
{
    public String Name;
    
    public Location(String name) 
    {
        Name = name;
    }

    @Override
    public boolean equals(Object o) 
    {
        if (o == this)
            return true;
        if (!(o instanceof Location))
            return false;
        Location other = (Location)o;
        boolean nameEquals = (this.Name == null && other.Name == null) || 
                             (this.Name != null && this.Name.equals(other.Name));

        return nameEquals;
    }    

    @Override
    public final int hashCode() 
    {
        int result = 17;
        if (Name != null) 
        {
            result = 31 * result + Name.hashCode();
        }

        return result;
    }    
}
