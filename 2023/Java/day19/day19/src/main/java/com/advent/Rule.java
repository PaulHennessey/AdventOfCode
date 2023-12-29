package com.advent;

public class Rule 
{
    public String Result;
    public String partCategoryName;
    public int partCategoryValue;
    private boolean greaterThan;

    public Rule(String rule) 
    {
        String[] parts = rule.trim().split(":");
        if(parts.length == 1)
        {
            Result = rule;
            partCategoryName = "";
            partCategoryValue  = Integer.MIN_VALUE;            
        }
        else
        {
            Result = parts[1];
            String[] predparts;

            if(parts[0].contains("<"))
            {
                predparts = parts[0].trim().split("<");
                greaterThan = false;
            }
            else
            {
                predparts = parts[0].trim().split(">");
                greaterThan = true;
            }

            partCategoryName = predparts[0];
            partCategoryValue = Integer.parseInt(predparts[1]);
        }
    }

    public boolean predicate(Part part)
    {
        if(greaterThan)
        {
            switch (partCategoryName) {
                case "x":
                    return part.X > partCategoryValue;
                case "m":
                    return part.M > partCategoryValue;
                case "a":
                    return part.A > partCategoryValue;
                case "s":
                    return part.S > partCategoryValue;
                default:
                    break;
            }
        }
        else
        {
            switch (partCategoryName) {
                case "x":
                    return part.X < partCategoryValue;
                case "m":
                    return part.M < partCategoryValue;
                case "a":
                    return part.A < partCategoryValue;
                case "s":
                    return part.S < partCategoryValue;
                default:
                    break;
            }
        }
        return true;    // never gets here
    }
}
