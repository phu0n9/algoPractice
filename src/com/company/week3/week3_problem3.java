package com.company.week3;

import java.util.Arrays;

public class week3_problem3 {

    public static void findOldNew(int[] arr){
        int left = 0;
        int right = arr.length -1;
        while (left < right && arr[left] > arr[right]){ //check two ends of array for old and new values
            int mid = (left+right) /2;
            if(arr[mid] > arr[mid+1]){ //between old and new array
                System.out.printf("Oldest index = %d and Newest index = %d\n", mid + 1, mid);
                return;
            }
            if(arr[left] < arr[mid]){
                left = mid + 1; //left side is old array
            }
            else{
                right = mid; //left side is new array
            }
        }
        System.out.printf("Oldest index = %d and Newest index = %d\n", left, right);
    }

    public static void main(String[] args) {
        int[] test1 = {1, 2, 3, 4, 5, 6, 7};
        // oldest = 0 and newest = 6
        findOldNew(test1);

        int[] test2 = {113, 115, 117, 118, 10, 11, 12, 13, 20, 23, 27, 100, 103, 105, 108};
        // oldest = 4 and newest = 3
        findOldNew(test2);
    }
}
