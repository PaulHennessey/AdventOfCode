package com.advent;

import java.util.ArrayList;
import java.util.List;

public class Workflow 
{
    public String Name;
    public List<Rule> Rules = new ArrayList<>();
    
    public Workflow(String workflow) 
    {
        // get the name
        String[] subStrings = workflow.trim().split("\\{");
        Name = subStrings[0];

        // trim off the closing brace
        subStrings[1] = subStrings[1].substring(0, subStrings[1].length()-1);

        String[] rules = subStrings[1].trim().split(",");

        for(String rule : rules)
        {
            Rules.add(new Rule(rule));
        }
    }

    public String processPart(Part part)
    {
        for(Rule rule : Rules)        
        {
            if(rule.predicate(part))
                return rule.Result;
        }
        return "";
    }
}
