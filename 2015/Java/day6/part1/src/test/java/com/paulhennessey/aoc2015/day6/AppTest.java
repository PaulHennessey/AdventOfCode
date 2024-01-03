package com.paulhennessey.aoc2015.day6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

class AppTest 
{
    @Test
    void testApp1() throws IOException 
    {
        App app = new App();
        app.processInstructions();
        assertEquals(569999, app.countLitLights());
    }
}
