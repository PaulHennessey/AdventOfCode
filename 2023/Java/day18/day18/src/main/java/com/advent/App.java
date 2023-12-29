package com.advent;

import java.util.ArrayList;
import java.util.List;

import org.javatuples.Pair;

public class App 
{
    List<List<Integer>> lagoon = new ArrayList<>();
    Pair<Integer, Integer> location = new Pair<Integer, Integer>(0,0);
    
    public App(List<String> input) 
    {
        startHole();

        for(String line : input)
        {
            String[] s = line.trim().split(" ");
            int distance = Integer.parseInt(s[1]);

            switch (s[0]) {
                case "R":
                    digRight(distance);
                    break;
                case "L":
                    digLeft(distance);
                    break;
                case "D":
                    digDown(distance);
                    break;
                case "U":
                    digUp(distance);
                    break;            
                default:
                    break;
            }
        }
    }

    private void startHole()
    {
        lagoon.add(new ArrayList<Integer>());
        lagoon.get(0).add(1);
    }

    private void digRight(int distance)
    {
        for(int number = 0; number < distance; number++)
        {        
            int row = location.getValue0();
            int col = location.getValue1();
            
            int currentRowSize = lagoon.get(row).size();
            if(col == currentRowSize-1)
            {
                addColumn();
            }

            col++;
            lagoon.get(row).set(col, 1);
            location = location.setAt1(col);
        }
    }

    private void digLeft(int distance)
    {
        for(int number = 0; number < distance; number++)
        {        
            int row = location.getValue0();
            int col = location.getValue1();
            if(col == 0)
            {
                addLeftColumn();
            }

            col = location.getValue1();
            col--;
            lagoon.get(row).set(col, 1);
            location = location.setAt1(col);
        }
    }

    private void digDown(int distance)
    {
        for(int i = 0; i < distance; i++)
        {        
            int row = location.getValue0();
            int col = location.getValue1();

            int currentColSize = lagoon.size();
            if(row == currentColSize-1)
            {
                addRow();
            }

            row++;
            lagoon.get(row).set(col, 1);
            
            location = location.setAt0(row);
        }
    }

    private void digUp(int distance)
    {
        for(int i = 0; i < distance; i++)
        {        
            int row = location.getValue0();
            int col = location.getValue1();

            if(row == 0)
            {
                addRowAbove();
            }

            row = location.getValue0();
            row--;
            lagoon.get(row).set(col, 1);
            location = location.setAt0(row);        
        }
    }

    private void addLeftColumn()
    {
        for(List<Integer> row : lagoon)
        {
            row.add(0, 0);
        }

        int col = location.getValue1();
        col++;
        location = location.setAt1(col);
    }

    private void addColumn()
    {
        for(List<Integer> row : lagoon)
        {
            row.add(0);
        }
    }

    private void addRow()
    {
        int rowSize = lagoon.get(0).size();

        List<Integer> newRow = new ArrayList<>(rowSize);
        for(int i = 0; i < rowSize; i++)
        {
            newRow.add(0);
        }

        lagoon.add(newRow);
    }

    private void addRowAbove()
    {
        int rowSize = lagoon.get(0).size();

        List<Integer> newRow = new ArrayList<>(rowSize);
        for(int i = 0; i < rowSize; i++)
        {
            newRow.add(0);
        }

        lagoon.add(0, newRow);

        location = location.setAt0(1);
    }

    public int count()
    {
        int count = 0;

        for(List<Integer> row : lagoon)
        {
            for(Integer i : row)
            {
                count += i;
            }
        }

        return count;
    }

    public void fillIn()
    {
        boolean change = false;
        for(List<Integer> row : lagoon)
        {
            for(int i = 0; i < row.size(); i++)
            {
                if(row.get(i) == 1 && change == false)
                {
                    change = true;
                }
                else if(row.get(i) == 1 && change == true)
                {
                    change = false;
                }
                else if(change == true)
                {
                    row.set(i, 1);
                }
            }


            // int low = Integer.MAX_VALUE;
            // int high = 0;

            // for(int i = 0; i < row.size(); i++)
            // {
            //     if(row.get(i) == 1)
            //     {
            //         low = i;
            //         break;
            //     }                
            // }

            // for(int i = row.size()-1; i >= 0; i--)
            // {
            //     if(row.get(i) == 1)
            //     {
            //         high = i;
            //         break;
            //     }
            // }

            // for(int i = low; i <= high; i++)
            // {
            //     row.set(i, 1);
            // }
        }
    }

    public static void main(String[] args) 
    {
        System.out.println("Hello World!");
    }
}
