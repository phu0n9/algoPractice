#Data Structure and Algorithms

## Week 3:
### Problem 1:
Given a sorted array of n uniformly distributed values, describe the most efficient algorithm to search for a particular element x in the array

#### Solution:
Since it is a uniformly distributed array, 
using interpolation search is better approach than binary search

```
index = left + (num-arr[left]) / (arr[righ]-arr[left])*(right-left)
```
Complexity would be the same O(logn). 

However, it would decrease half (N/2) -> O(log base 2(N))

Binary search would be O(log base 10(N))

O(log base 10 (N)) = O(log base 2 (N)) / 3.5

### Problem 2:
An array contains the maximum temperature measured at noon in Saigon for each day for the last 10 years. You believe that an important metric that will prove global warming is to derive the maximum increase in temperature from its lowest to its highest value across the ten years. So, you need to find which two days - lowDay and highDay (where lowDay < = highDay) that has the largest increase. For example: if the temperatures were [14, 12, 70, 15, 95, 65, 22, 99, 8] the maximum increase = 99-12 = 87.

Provide pseudo-code to calculate this

What is the order of complexity of your code and justify your answer?

#### Solution:
We cannot sort the array as the next day might have lower temperature than the previous one

Normally, we would use 2 for loops and iterate through it.

Better way is using 1 for loop with 2 indexes, one index is to store the index of the smallest number and the second is to iterate the array

Complexity: O(n)
```
i = j = 0
minimum number = a very big number
for loop i < length of array:
    if value of iterating index array(i) - value of smallest number(j) > max:
        store max and store values of array(i) and array(j)
        
    if current number of array(i) < minimum number:
        store minimum number and its index
```

### Problem 3:
The data that is downloaded from the COVID application on a smartphone is stored with a timestamp in a buffer of length 100,000 that is overwritten when the buffer gets full. For example, if the buffer was of size 15, the first 15 entries could be [3, 5, 7, 8, 10, 11, 12, 13, 20, 23, 27, 100, 103, 105, 108]. As the buffer is now full, when the 16th entry arrives it would overwrite location 1 and likewise, the 17th entry would overwrite entry 2 . etc. So, at time T, the buffer might contain data with the following timestamps  [113, 115, 117, 118, 10, 11, 12, 13, 20, 23, 27, 100, 103, 105, 108]. You have decided that to gain insight into the spread of COVID you need to be able to efficiently find data at a specific time and be able to compare the oldest and newest data in the buffer.

Provide efficient pseudocode to read the data with a specific timestamp (e.g. look for the data with timestamp 117)

Provide efficient pseudocode that will access the oldest and newest data in the buffer

What is the order of complexity of your code?

#### Solution:
* Provide efficient pseudocode to read the data with a specific timestamp (e.g. look for the data with timestamp 117)
```
    index = T % N
```
* Provide efficient pseudocode that will access the oldest and newest data in the buffer

Because the array is sorted from each new or old fragments of array, we can use binary search.

Complexity: O(logn)
```
left = 0
right = length of array -1 
LOOP: left < right and array[left] > array[right] --> check both ends have the old or new array or not
    mid = (left + right) / 2
    if array[mid] > array[mid+1]: --> boundary between two old and new array
        print out indexes
    if array[left] < array[mid]: --> the left side array is old array
        left = mid + 1
    else: --> the right side array is old array
        right = mid 
```

### Problem 4:
Describe an algorithm to remove a loop from a linked list

* To check if there is a loop in linkedlist: using toise and haire algorithm where there are two pointers. One of them is faster ahead one value with the slow pointer. If there is a loop, they will intersect.
```
slow = head
fast = head.next
while slow != fast:
    if condition to check the next of fast
    pointer is null or the next of the next 
    of faster pointer is null:
        return false if they are null
    else:
        slow = slow.next
        fast = fast.next.next
        (fast is ahead slow pointer 1 value. for example if slow pointer index is 2, then fast pointer is 4)
```
* Using HashSet to remove the loop:

Complexity: Time: O(n), Space: O(n)

As HashSet requires the value inside it is unique. Therefore it is an easy to understand approach to assign the next node to the hashset if that next node is not in the HashSet, then iterate the head to that next node. If the node is already existed in the HashSet, assign null to its next node.

* Using two pointers to remove the loop:

Complexity: Time: O(n), Space: O(1)

By finding the node that two slow and fast pointer meet, we assign the fast pointer equals to the amount of the nodes in the loop. For example: if there are 5 numbers in the loop, then fast pointer will be assigned at index 5(using for loop with length is the total numbers in the loop) and the slow pointer would start from the head node. By assigning in this way, these two pointers would meet again.

```
Assign two pointers to the node they will meet each other

Count how many nodes inside the loop using do while loop (if we use while loop, assign count = 1 and assign slow=slow.next)

Reset two pointers

Assign fast pointer according to the for loop with length = count (i<count) and assign fast = fast.next --> fast pointer now is inside the linkedlist loop

Using a loop to check if the next node of slow and fast is intersected or not
    If they are not intersected --> assign them to the next node
    If they are intersected --> assign slow or fast next node to null
```

### Problem 5:
Provide the code for an efficient algorithm that converts a given list into a jagged list. a Jagged list is a list where the values go up and down as we traverse the list, e.g. Original list: 4, 3, 7, 8, 6, 2, 1 and a Jagged list: 3, 7, 4, 8, 2, 6, 1 (as 3 < 7 > 4 < 8 >2 <6 >1). Note, that there is more than one possible jagged list for a given input. You just need to construct one possible solution. You need to solve this problem in O(n) time and in O(1) space (no extra array is needed).

#### Solution:
```
Starting from second index for loop then:
    if (array[i] - array[i-1]) * (array[i-1] - array[i-2]) > 0:
        swap array[i] with array[i-1]
```
Means that they are both negative or positive subtraction, or in other meaning, the middle number is either bigger than the right and left numbers or it is smaller than its right and left numbers. 



