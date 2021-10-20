#Data Structure and Algorithms

## Week 1:
### Problem 3:
An array A contains N unique integers. Without sorting the list, determine if it contains N consecutive integers. For example:

    A = {5, 3, 4, 1, 2} Output: true as array contains elements from 1 to 5
    A = {47, 43, 45, 44, 46} Output: true as array contains 43 to 47
    A = {6, 7, 5, 9} Output: false

#### Solution:
Because these are continuous numbers
```
    max number - min number + 1 = length of array
```

### Problem 4:
Consider the following operations on an arbitrary positive integer, N

    If the N is even, divide it by two (i.e. N/2) and if N is odd, triple it and add one (i.e. 3*N +1)
    Now form a sequence by performing this operation repeatedly, beginning with any positive integer, and taking the result at each step as the input to the next and continue until the number 1 is reached.

For instance, starting with n = 12, one gets the sequence 12, 6, 3, 10, 5, 16, 8, 4, 2, 1.  When n = 19, the sequence is much longer and is as follows: 19, 58, 29, 88, 44, 22, 11, 34, 17, 52, 26, 13, 40, 20, 10, 5, 16, 8, 4, 2, 1.

Write a program that for all the numbers between 1 and 100 calculates the number of steps it takes to reach 1 and print out the number of steps in a table. That is:
