package com.paulhennessey.aoc2015.day11;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class App 
{
    public App() 
    {}

    public String generateNewPassword(String oldPassword)
    {
        String newPassword = incrementPassword(oldPassword);

        while(!passwordIsValid(newPassword))
        {
            newPassword = incrementPassword(newPassword);
        }

        return newPassword;
    }

    public String incrementPassword(String password)
    {
        StringBuilder sb = new StringBuilder(password);

        for(int index = password.length()-1; index >= 0; index--)
        {        
            char c = password.charAt(index);
            if(c < 'z')
            {
                sb.setCharAt(index, (char)(c+1));
                break;
            }
            else
            {
                sb.setCharAt(index, 'a');
            }
        }

        return sb.toString();
    }

    public boolean passwordIsValid(String password)
    {
        if(containsiol(password))
        {        
            return false;
        }
        else if(!containsTwoPairs(password))
        {
            return false;
        }
        else if(!containsStraight(password))
        {
            return false;
        }

        return true;
    }

    public boolean containsTwoPairs(String s)
    {        
        return processRegex("(.)\\1.*(.)\\2", s);
    }

    public boolean containsiol(String s)
    {
        return processRegex("(.*[iol].*)", s);
    }

    public boolean containsStraight(String s)
    {
        return processRegex(".*(abc|bcd|cde|def|efg|fgh|ghi|hij|ijk|jkl|klm|lmn|mno|nop|opq|pqr|qrs|rst|stu|tuv|uvw|vwx|wxy|xyz).*", s);
    }

    private boolean processRegex(String regex, String input)
    {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.find();
    }

    public static void main(String[] args) 
    {
        System.out.println("Hello World!");
    }
}