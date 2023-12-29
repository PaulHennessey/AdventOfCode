package com.advent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class App 
{
    Map<String, Workflow> Workflows = new HashMap<String, Workflow>();
    List<Part> Parts = new ArrayList<>();
    List<Part> AcceptedParts = new ArrayList<>();
    List<Part> RejectedParts = new ArrayList<>();

    public App(List<String> input) 
    {         
        List<String> workflows = new ArrayList<>();
        List<String> parts = new ArrayList<>();
                
        for(String line : input)
        {
            if(line.equals(""))
            {}
            else if(line.charAt(0) == '{')
            {
                parts.add(line);
            }
            else
            {
                workflows.add(line);
            }
        }

        for(String line : workflows)
        {
            Workflow wf = new Workflow(line);
            Workflows.put(wf.Name, wf);
        }

        for(String line : parts)
        {
            Part part = new Part(line);
            Parts.add(part);
        }
    }

    public void processParts()
    {
        for(Part part : Parts)
        {
            Workflow wf = Workflows.get("in");
            processPart(wf, part);
        }
    }

    public void processPart(Workflow workflow, Part part)
    {
        String result = workflow.processPart(part);
        if(result.equals("A"))
        {
            AcceptedParts.add(part);
        }
        else if(result.equals("R"))
        {
            RejectedParts.add(part);
        }
        else
        {
            Workflow wf = Workflows.get(result);
            processPart(wf, part);
        }
    }

    public int getTotalRatings()
    {
        int total = 0;
        for(Part part : AcceptedParts)
        {
            total += part.getTotalRatings();
        }

        return total;
    }
}
