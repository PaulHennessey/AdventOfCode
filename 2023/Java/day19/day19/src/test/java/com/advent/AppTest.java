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
        Rule rule = new Rule("a<2006:qkq");
        Part part = new Part("x=787,m=2655,a=1222,s=2876");
        
        assertEquals(true, rule.predicate(part));
        assertEquals("qkq", rule.Result);
    }

    @Test
    void testApp2() throws IOException 
    {
        Rule rule = new Rule("m>2090:A");
        Part part = new Part("x=787,m=2655,a=1222,s=2876");
        
        assertEquals(true, rule.predicate(part));
        assertEquals("A", rule.Result);
    }

    @Test
    void testApp3() throws IOException 
    {
        Rule rule = new Rule("rfg");
        Part part = new Part("x=787,m=2655,a=1222,s=2876");
        
        assertEquals(true, rule.predicate(part));
        assertEquals("rfg", rule.Result);
    }

    @Test
    void testApp4() throws IOException 
    {
        input = Files.readAllLines(Paths.get("src/test/java/com/advent/input.txt"));
        app = new App(input);
        app.processParts();

        assertEquals(19114, app.getTotalRatings());
    }

    @Test
    void testApp5() throws IOException 
    {
        input = Files.readAllLines(Paths.get("src/test/java/com/advent/biginput.txt"));
        app = new App(input);
        app.processParts();

        assertEquals(362930, app.getTotalRatings());
    }    
}
