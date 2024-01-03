package com.paulhennessey.aoc2015.day7;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class App 
{
    static HashMap<String, Node> vars = new HashMap<>();
    static Path path = Paths.get("src/test/java/com/paulhennessey/aoc2015/day7/input.txt");

    public void buildCircuit() throws IOException
    {        
        List<String> input = Files.readAllLines(path);
        input.stream()
             .forEach(line -> processInstruction(line));
    }

    private void processInstruction(String line)
    {
        String[] parts = line.trim().split(" ");
        Node node = new Node();

        if(line.contains("NOT"))
        {
            processNOT(parts[3], parts[1], node);
        }
        else if(line.contains("AND"))
        {
            processAND(parts[4], parts[2], parts[0], node);
        }        
        else if(line.contains("OR"))
        {
            processOR(parts[4], parts[2], parts[0], node);
        }        
        else if(line.contains("LSHIFT"))
        {
            processLShift(parts[4], parts[0], parts[2], node);
        }        
        else if(line.contains("RSHIFT"))
        {
            processRShift(parts[4], parts[0], parts[2], node);
        }
        else
        {
            processASSIGNMENT(parts[2], parts[0], node);
        }        
    }

    private void processNOT(String key, String value, Node node)
    {
        node.setValue(new Negation(setSubNode(value)));
        vars.put(key, node);
    }

    private void processAND(String key, String left, String right, Node node)
    {     
        node.setValue(new And(setSubNode(left), setSubNode(right)));
        vars.put(key, node);
    }    

    private void processOR(String key, String left, String right, Node node)
    {     
        node.setValue(new Or(setSubNode(left), setSubNode(right)));
        vars.put(key, node);
    }    

    private void processLShift(String key, String left, String right, Node node)
    {     
        node.setValue(new LShift(setSubNode(left), setSubNode(right)));
        vars.put(key, node);
    }    

    private void processRShift(String key, String left, String right, Node node)
    {     
        node.setValue(new RShift(setSubNode(left), setSubNode(right)));
        vars.put(key, node);
    }    

    private void processASSIGNMENT(String key, String value, Node node)
    {
        node.setValue(setSubNode(value));
        vars.put(key, node);
    }

    public int getTestValue(String s)
    {
        return vars.get(s).getValue();
    }

    public void setTestValue(String s)
    {
        vars.get(s).setValue(new Literal(3176));
    }

    private Element setSubNode(String s) 
    {
        if (s.matches("\\d+")) {
            return new Literal(Integer.parseInt(s));
        } else {
            return new SubNode(s, vars);
        }
    }
}