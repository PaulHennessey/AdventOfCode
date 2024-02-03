package com.paulhennessey.aoc2015.day4;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class App
{
    public App()
    {}

    public long processKey(String key) throws NoSuchAlgorithmException
    {
        MessageDigest md = MessageDigest.getInstance("MD5");
        int index = 0;
        byte[] messageDigest;

        while (true)
        {
            messageDigest = md.digest((key + index++).getBytes());

            if(messageDigest[0] == 0 && messageDigest[1] == 0 && (messageDigest[2] >> 4 & 0xf) == 0)
            {
                if(messageDigest[2] == 0) // Comment out to do part 1.
                    break;
            }
        }

        return index-1;
    }
}
