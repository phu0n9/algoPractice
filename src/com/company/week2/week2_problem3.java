package com.company.week2;

import java.util.Arrays;

public class week2_problem3 {

    // Merge sort O(nlogn) + tranverse through array O(n)
    public static void printUniqueArrays(int[] arr){
        Arrays.sort(arr);
        for(int i=0; i<arr.length; i++){
            while (i < arr.length -1 && arr[i] == arr[i+1]){
                i++;
            }
            System.out.print(arr[i]+" ");
        }
    }

    public static void main(String[] args) {
        int[] arr = {6,100,6,10,1,100,5,8,2,3,4,7,10,20};
        printUniqueArrays(arr);
    }
}
