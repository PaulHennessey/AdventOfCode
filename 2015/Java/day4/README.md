This is about generating an MD5 hash.

My original attempt, copying from Baeldung, was extremely slow.

This version is much faster - the difference seems to be not converting the byte[] to a string, but testing the byte[] directly.

###### Big O
As far as I can find out online, this is linear time - O(n)
