# Data Structure and Algorithms

## Week 2:
### Problem 2:
A sorted array (A) of length N is populated 
with N consecutive different integers ranging from 0 to N has one
number missing. For example, if N=7 and the array = [0, 1, 2, 3, 4, 6, 7] then the missing value is 5.
Find an algorithm that finds and prints out the missing integer.
What is the big O of your code? Can you find an O(log N) algorithm?

#### Solution:
O(n) method:

sum of consecutive numbers = (n / 2)(first number + last number)

then calculate the sum of array elements 

```
missing number = sum of consecutive numbers - sum of array elements
```

O(log(n)) method (modified binary search):

As this one is consecutive numbers starting from 0. The array index can be the same. Therefore, to check whether the missing number is on the right or left side of the array, we can determine the middle index of the array and then using the subtraction as followed:
```
mid index = (start index + end index) / 2
set the below conditions in the loop where : end index - start index > 1
if start number - start index != mid number - mid index:
    the missing number will be on the right of the array, then set end index = mid index
else if mid number - mid index != end number - end index:
    the missing number will be on the left of the array, then set start index = mid index
```

### Problem 3:
Describe an efficient algorithm that prints out all the unique elements in an array. What is the complexity of your algorithm?

Clarification: If your array is [6, 8, 10, 11, 6, 10] => print out [6, 8, 10, 11] (there is no requirement about output order, so you can print the values in any order)

```
1. Sort the array using merge sort O(nlogn)
2. Tranverse through array and compare the current number index i with the next number (i+1) --> O(n)
```

### Problem 4:
Given the arrival and departure time of planes reaching a particular airport. You need to find the minimum number of gates required to accommodate the planes at any point in time. For example if arrival[] = {1:00, 1:40, 1:50, 2:00, 2:15, 4:00] and departure[] = {1:10, 3:00, 2:20, 2:30, 3:15, 6:00} then number of gates required = 4. Note that arrival time is in chronological order. Use analytical methods to prove the complexity. The size of this problem is the size of the arrival/departure array.

#### The idea:
The arrival time is mostly smaller than the departure time, therefore, it should be prioritized. Once the arrival gate is used, the departure gate can be re-used. 
```
Sort two arrays --> O(nlogn)

The below conditions will be run in the loop --> O(n)
    if arrival time <= departure time: 
        increment gate++ and arrival time index
    else:
        decrement gate-- and increment departure time index
        
    Remember to store the maximum gate
```
### Problem 5:
Given a sorted array of positive and negative integers, find two integers in the array whose sum is closest to zero. Use analytical methods to prove the complexity.

```
Complexity: O(n)
    sum the first element and last element of the array then move up to find the minimum sum
```

### Problem 6:
One of your data sources to monitor the spread Covid is an application that runs on each user’s smartphone. When you download and analyze the data you find that your machine learning code’s complexity is O(n^3) and it takes 100 msec to run data from 1000 users. Without using a calculator, can you determine approximately how many days it will take your code to run for 1,000,000 users?

```
(1 000 000 users / 1000 users)^3 * 0.1 = 10^8
1 year approximately equal to pi * 10^7 
then 10^8 = 3 * pi* 10^7 nearly 3 years
```

### Problem 7:
What is the complexity of an algorithm that merges two sorted arrays so that the resultant array is also sorted? For example, if A = [3, 6, 10, 15] and B = [7, 10, 12, 19, 25], the result would be [3, 6, 7, 10, 10, 12, 15, 19, 25].
```
Complexity O(n)
Create new array then assign these numbers to that array
```
