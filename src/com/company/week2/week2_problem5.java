package com.company.week2;

public class week2_problem5 {

    public static String problem5(int[] arr){
        int start = 0;
        int end = arr.length -1;
        int minSum = 999999;
        int minStart = 0;
        int minEnd = arr.length -1;
        if (arr.length < 2){
            return "Invalid input";
        }

        while (start < end){
            int sum = arr[start] + arr[end];
            if (Math.abs(sum) < Math.abs(minSum)){
                minSum = sum;
                minStart = start;
                minEnd = end;
            }
            if (sum < 0){
                start++;
            }
            else{
                end--;
            }

        }

        return "Two numbers whose sum is nearest 0 is "+arr[minStart]+" "+arr[minEnd]+" and their sum is "+minSum;
    }

    public static void main(String[] args) {
        int [] arr = {-5,-2,0,1,3,7};
        System.out.println(problem5(arr));
    }
}
