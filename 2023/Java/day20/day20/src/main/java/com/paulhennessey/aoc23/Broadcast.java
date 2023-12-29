package com.paulhennessey.aoc23;

public class Broadcast extends Module
{
    public Broadcast(String name) 
    {
        Name = name;
    }

    @Override
    protected void processPulse(String sender, Pulse pulse, PulseCount pulseCount)
    {
        for(Module module : ConnectedModules)
        {
            module.processPulse(this.Name, pulse, pulseCount);
        }

        pulseCount.count++;
    }
}
