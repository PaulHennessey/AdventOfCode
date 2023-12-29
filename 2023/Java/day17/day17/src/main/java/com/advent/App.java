package com.advent;

import java.util.ArrayList;
import java.util.List;

public class App 
{
    public App(List<String> input) 
    {
        Graph graph = new Graph();
        List<List<Integer>> grid = new ArrayList<>();

        for(String line : input)
        {
            List<Integer> row = new ArrayList<>();            

            for(Character c : line.toCharArray())
            {
                row.add(Character.getNumericValue(c));
            }

            grid.add(row);
        }

        for(int row = 0; row < input.size(); row++)
        {
            for(int col = 0; col < input.get(row).length(); col++)
            {
                graph.addNode(createNode(row, col));
            }
        }        
    }
 
    private Node createNode(int row, int col)
    {
        String name  = Integer.toString(row) + Integer.toString(col);
        Node node = new Node(name);

        return node;
    }

    public static void main(String[] args) 
    {
        System.out.println("Hello World!");
    }
}

