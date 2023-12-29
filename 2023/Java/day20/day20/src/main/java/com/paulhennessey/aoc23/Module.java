package com.paulhennessey.aoc23;

import java.util.ArrayList;
import java.util.List;

public abstract class Module 
{
    public String Name;
    public List<Module> ConnectedModules = new ArrayList<>();    

    protected abstract void processPulse(String sender, Pulse pulse, PulseCount pulseCount);
} 
