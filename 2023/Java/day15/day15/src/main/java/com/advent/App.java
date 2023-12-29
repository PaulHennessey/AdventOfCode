package com.advent;

public class App 
{
    private Box[] Boxes = new Box[256];

    public App() 
    {
        for(int i = 0; i < 256; i++)
        {
            Boxes[i] = new Box(i);
        }
    }

    public int getFocusingPower(String input)
    {
        String[] steps = input.trim().split(",");

        for(String step : steps)
        {
            if(step.contains("="))
            {
                processEquals(step);
            }
            else
            {
                processDash(step);
            }
        }

        return calculateTotal();
    }

    public int getHash(String input)
    {
        int hash = 0;

        for(int i = 0; i < input.length(); i++)
        {
            char c = input.charAt(i);
            hash += (int)c;
            hash *= 17;
            hash %= 256;
        }

        return hash;
    }

    private void processDash(String step)
    {
        String label = step.substring(0, step.length()-1);
        int hash = getHash(label);
        Boxes[hash].removeLens(label);
    }

    private void processEquals(String step)
    {
        String[] parts = step.trim().split("=");
        String label = parts[0];
        int focalLength = Integer.parseInt(parts[1]);
        Lens lens = new Lens(label, focalLength);
        int hash = getHash(label);
        Boxes[hash].addLens(lens);        
    }

    private int calculateTotal()
    {
        int total = 0;

        for(Box box : Boxes)
        {            
            total += box.calculateFocusingPower();
        }

        return total;
    }

}
