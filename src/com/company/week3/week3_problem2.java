package com.company.week3;

import java.util.Arrays;

public class week3_problem2 {
    public static int [] findMaxIncreaseDays(int[] arr){
        int [] days = new int[2];
        int max = 0;
        int i = 0;
        int j = 0;
        int min = Integer.MAX_VALUE;
        while (i < arr.length){
           if(arr[i] - arr[j] > max){
                days[0] = arr[i];
                days[1] = arr[j];
                max = arr[i] - arr[j];
           }
           //find the smallest number and set the second index to it
           if(arr[i] < min){
               min = arr[i];
               j = i;
           }
           i++;
        }
        return days;
    }

    public static void main(String[] args) {
        int[] arr = {14, 12, 70, 15, 101, 65, 22, 99, 8};
        System.out.println(Arrays.toString(findMaxIncreaseDays(arr)));
    }
}
