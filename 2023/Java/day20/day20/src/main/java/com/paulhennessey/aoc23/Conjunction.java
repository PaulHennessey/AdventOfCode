package com.paulhennessey.aoc23;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Conjunction extends Module
{
    Map<String, Pulse> mostRecentPulses = new HashMap<String, Pulse>();
    
    public Conjunction(String name) 
    {
        Name = name;
    }

    @Override
    protected void processPulse(String sender, Pulse pulse, PulseCount pulseCount) 
    {
        mostRecentPulses.put(sender, pulse);

        List<Pulse> allValues = new ArrayList<>(mostRecentPulses.values());

        if(allValues.stream().allMatch(p -> p == Pulse.HIGH))
        {
            sendPulse(Pulse.LOW, pulseCount);
        }
        else
        {
            sendPulse(Pulse.HIGH, pulseCount);
        }

        pulseCount.count++;
    }

    private void sendPulse(Pulse pulse, PulseCount pulseCount)
    {
        for(Module module : ConnectedModules)
        {
            module.processPulse(this.Name, pulse, pulseCount);
        }
    }

    public void initMostRecentPulses()
    {
        for(Module module : ConnectedModules)
        {
            mostRecentPulses.put(module.Name, Pulse.LOW);
        }
    }
}
