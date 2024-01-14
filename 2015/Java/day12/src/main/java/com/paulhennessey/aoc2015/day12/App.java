package com.paulhennessey.aoc2015.day12;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Map.Entry;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class App 
{
    static Path path = Paths.get("src/test/java/com/paulhennessey/aoc2015/day12/input.json");
    ObjectMapper mapper = new ObjectMapper();

    public App() 
    {}

    private boolean nodeContainsPropertyRed(Iterator<Entry<String, JsonNode>> fields)
    {
        while(fields.hasNext())
        {
            if(fields.next().getValue().asText().equals("red"))
            {
                return true;
            }
        }

        return false;
    }

    public int processNode(JsonNode node)
    {
        int sum = 0;
        if (node.isObject()) 
        {
            Iterator<Entry<String, JsonNode>> fields = node.fields();
            if(!nodeContainsPropertyRed(fields))
            {            
                fields = node.fields(); // reset iterator
                while(fields.hasNext())
                {
                    sum += processNode(fields.next().getValue());
                }
            }
        }
        else if (node.isArray()) 
        {
            for (JsonNode arrayItem : node) 
            {
                sum += processNode(arrayItem);
            }
        }
        else if (node.isNumber()) 
        {
            sum += node.asInt();
        }

        return sum;        
    }

    public int sumAllNumbers() throws IOException
    {
        String jsonString = Files.readString(path);        
        JsonNode node = mapper.readTree(jsonString);

        return processNode(node);
    }
}
