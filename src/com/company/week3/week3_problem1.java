package com.company.week3;

public class week3_problem1 {

    public static int findNumber(int[] arr, int num){
        int left = 0;
        int right = arr.length - 1;
        if(arr[left] == num){
            return left;
        }
        else if(arr[right] == num){
            return right;
        }
        while (left < right){
            int min = arr[left];
            int max = arr[right];
            int idx = left + (num-min) / (max-min)*(right-left);
            if(arr[idx] == num){
                return idx;
            }
            else if (arr[idx] < num){
                left = idx + 1;
            }
            else{
                right = idx-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {10,15,20,35,39,43,47,50,52,61,68};
        System.out.println(findNumber(arr,13));
    }
}
