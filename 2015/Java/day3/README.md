Had real trouble creating a good hashCode() method in my own Location class - I couldn't find one that worked for test4 and test8.
The solution was to convert the location to a string and use that as the hashmap key, rather than the Location itself.

###### Big O
This is linear time, as we need to step through each element - O(n)

###### Algorithms
This just seems to be about Hashes and HashMaps.