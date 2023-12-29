package com.advent;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


class AppTest 
{
    App app;
    List<String> input;

    @Test
    void testApp1() throws IOException 
    {
        input = Files.readAllLines(Paths.get("src/test/java/com/advent/biginput.txt"));
        app = new App(input);
        app.startSimulation(0, 0, Direction.RIGHT);
        assertEquals(6622, app.countEnergisedTiles());
    }

    @Test
    void testApp2() throws IOException 
    {
        input = Files.readAllLines(Paths.get("src/test/java/com/advent/input.txt"));
        app = new App(input);
        app.startSimulation(0, 0, Direction.RIGHT);
        assertEquals(46, app.countEnergisedTiles());
    }    

    @Test
    void testApp3() throws IOException 
    {
        input = Files.readAllLines(Paths.get("src/test/java/com/advent/inputloop.txt"));
        app = new App(input);
        app.startSimulation(0, 0, Direction.RIGHT);
        assertEquals(9, app.countEnergisedTiles());
    }        

    @Test
    void testApp4() throws IOException 
    {
        input = Files.readAllLines(Paths.get("src/test/java/com/advent/inputsmall.txt"));
        app = new App(input);
        app.startSimulation(0, 0, Direction.RIGHT);
        assertEquals(7, app.countEnergisedTiles());
    }    
    
    @Test
    void testApp5() throws IOException 
    {
        input = Files.readAllLines(Paths.get("src/test/java/com/advent/input.txt"));
        app = new App(input);
        app.maximiseEnergisedTiles();
        assertEquals(51, app.MaximumEnergisedTiles);
    }        

    @Test
    void testApp6() throws IOException 
    {
        input = Files.readAllLines(Paths.get("src/test/java/com/advent/biginput.txt"));
        app = new App(input);
        app.maximiseEnergisedTiles();
        assertEquals(7130, app.MaximumEnergisedTiles);
    }            
}
