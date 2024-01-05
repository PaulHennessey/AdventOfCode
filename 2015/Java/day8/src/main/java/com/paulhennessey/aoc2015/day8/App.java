package com.paulhennessey.aoc2015.day8;

import java.io.IOException;

public class App 
{

    // found this solution here: https://www.reddit.com/r/adventofcode/comments/3vw32y/day_8_solutions/
    // I don't like it, but it seems to give the right answer, and I'm fed up with escape characters...

    public String unescape(String input) 
    {
        StringBuilder out = new StringBuilder(input.length());

        for(int i = 1; i < input.length() - 1; i++) 
        {
            char c = input.charAt(i);
            if(c == '\\') 
            {
                i++;
                char c2 = input.charAt(i);
                if(c2 == '\\' || c2 == '"') 
                {
                    out.append(c2);
                }
                else if(c2 == 'x') 
                {
                    i++;
                    c2 = (char)Integer.parseInt(input.substring(i, i + 2), 16);
                    out.append(c2);
                    i += 1;
                }
            }
            else 
            {
                out.append(c);
            }
        }

        return out.toString();
    }

    public String escape(String input) 
    {
        StringBuilder out = new StringBuilder(input.length() * 2);
        out.append('"');
        for(char c : input.toCharArray()) 
        {
            if(c == '"' || c == '\\') 
            {
                out.append('\\');
            }
            out.append(c);
        }

        out.append('"');

        return out.toString();
    }

    public static void main(String... argv) throws IOException 
    {}
}