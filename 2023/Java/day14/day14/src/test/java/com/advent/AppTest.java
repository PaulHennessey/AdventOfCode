package com.advent;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

class AppTest 
{
    @Test
    void testApp() 
    {
        assertEquals(136, App.calculateTotalLoad());
    }
}

