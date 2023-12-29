package com.advent;

import java.util.ArrayList;
import java.util.List;

public class Box 
{
    public List<Lens> Lenses = new ArrayList<Lens>();
    public int Number;

    public Box(int number) 
    {
        Number = number;
    }

    public void removeLens(String label)
    {
        Lenses.removeIf(l -> l.getLabel().equals(label));
    }

    public void addLens(Lens lens)
    {
        if(lensAlreadyExists(lens))
        {
            updateLens(lens);
        }
        else
        {
            Lenses.add(lens);
        }
    }

    public boolean isNotEmpty()
    {
        return !Lenses.isEmpty();
    }

    public int calculateFocusingPower()
    {
        int total = 0;

        for(Lens lens : Lenses)
        {
            total += (Number + 1) * (Lenses.indexOf(lens) + 1) * lens.getFocalLength();
        }

        return total;
    }    

    private boolean lensAlreadyExists(Lens lens)
    {
        boolean result = false;

        for(Lens l : this.Lenses)
        {
            if(l.getLabel().equals(lens.getLabel()))
            {
                result = true;
                break;
            }
        }

        return result;
    }

    private void updateLens(Lens lens)
    {
        for(Lens l : this.Lenses)
        {
            if(l.getLabel().equals(lens.getLabel()))
            {
                l.setFocalLength(lens.getFocalLength());
                break;
            }
        }
    }
}
