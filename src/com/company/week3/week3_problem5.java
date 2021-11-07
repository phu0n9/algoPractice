package com.company.week3;

public class week3_problem5 {

    public static void createJaggedList(int [] arr){
        for (int i = 2; i < arr.length; i++) {
            if((arr[i] - arr[i-1]) * (arr[i-1]-arr[i-2]) > 0){
                int temp = arr[i];
                arr[i] = arr[i-1];
                arr[i-1] = temp;
            }
        }

        for (int i=0;i< arr.length;i++) {
            if(i == arr.length-1){
                System.out.print(arr[i]);
            }
            else{
                System.out.print(arr[i]+",");
            }
        }
    }

    public static void main(String[] args) {
        int[] test1 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        createJaggedList(test1);

        int[] test2 = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        createJaggedList(test2);

        int[] test3 = {1, 5, 2, 9, 10, 13, 17, 21, 11};
        createJaggedList(test3);
    }
}
