package com.paulhennessey.aoc23;

public class Flipflop extends Module
{
    private State state;

    public Flipflop(String name) 
    {
        Name = name;
        state = State.OFF;
    }

    @Override
    protected void processPulse(String sender, Pulse pulse, PulseCount pulseCount) 
    {
        if(pulse == Pulse.LOW)
        {
            if(state == State.OFF)
            {
                state = State.ON;
                sendPulse(Pulse.HIGH, pulseCount);
            }
            else
            {
                state = State.OFF;
                sendPulse(Pulse.LOW, pulseCount);
            }
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
}
