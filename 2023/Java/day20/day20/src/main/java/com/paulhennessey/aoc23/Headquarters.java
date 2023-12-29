package com.paulhennessey.aoc23;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Headquarters 
{
    Button button = new Button("button");
    PulseCount pulseCount = new PulseCount();    
    Map<String, Module> modules = new HashMap<String, Module>();
    
    public Headquarters(List<String> input) 
    {
        buildModules(input);
        initialiseModules(input);
    }

    public void pushButton()
    {
        button.processPulse("", Pulse.LOW, pulseCount);
    }

    public int countPulses()
    {
        return pulseCount.count;
    }

    private void initialiseModules(List<String> input)
    {
        for(String line : input)
        {
            if(line.startsWith("&"))
            {
                initialiseConjunction(line);
            }
            else if(line.startsWith("%"))
            {
                initialiseFlipflop(line);
            }
            else
            {
                initialiseBroadcast(line);
            }
        }

        initialiseButton();
    }

    private void initialiseButton()
    {
        button = new Button("button");
        button.ConnectedModules.add(modules.get("broadcaster"));
    }

    private void initialiseBroadcast(String line)
    {
        String moduleName = line.split("->")[0].trim();
        String rhs = line.trim().split("->")[1].trim();
        String destinationModules[] = rhs.trim().split(", ");

        Broadcast module = (Broadcast)modules.get(moduleName);
        for(String destinationModuleName : destinationModules)
        {
            module.ConnectedModules.add(modules.get(destinationModuleName));
        }
    }

    private void initialiseFlipflop(String line)
    {
        String moduleName = line.split("->")[0].trim().substring(1);
        String rhs = line.trim().split("->")[1].trim();
        String destinationModules[] = rhs.trim().split(", ");

        Flipflop module = (Flipflop)modules.get(moduleName);
        for(String destinationModuleName : destinationModules)
        {
            module.ConnectedModules.add(modules.get(destinationModuleName));
        }
    }

    private void initialiseConjunction(String line)
    {
        String moduleName = line.split("->")[0].trim().substring(1);
        String rhs = line.trim().split("->")[1].trim();
        String inputModules[] = rhs.trim().split(", ");

        Conjunction module = (Conjunction)modules.get(moduleName);
        for(String inputModuleName : inputModules)
        {
            module.ConnectedModules.add(modules.get(inputModuleName));
        }

        module.initMostRecentPulses();
    }

    private void buildModules(List<String> input)
    {
        for(String line : input)
        {
            String moduleName = line.trim().split("->")[0].trim();

            if(moduleName.equals("broadcaster"))
            {
                modules.put(moduleName, new Broadcast(moduleName));
            }
            else if (moduleName.startsWith("%"))
            {
                moduleName = moduleName.substring(1);
                modules.put(moduleName, new Flipflop(moduleName));
            }
            else if (moduleName.startsWith("&"))
            {
                moduleName = moduleName.substring(1);
                modules.put(moduleName, new Conjunction(moduleName));
            }
        }
    }    
}
