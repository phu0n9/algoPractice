package com.company.week2;

public class week2_problem7 {

    public static void problem7(int[] arr1, int [] arr2,int[] arr){
        int i=0,j=0,k = 0;

        while (i < arr1.length && j < arr2.length){
            if (arr1[i] < arr2[j]){
                arr[k] = arr1[i];
                k++;
                i++;
                //the above can be written as arr[k++] = arr1[i++]
            }
            else{
                arr[k] = arr2[j];
                k++;
                j++;
            }
        }

//        while (i < arr1.length){
//            arr[k++] = arr1[i++];
//        }
//        while(j < arr2.length){
//            arr[k++] = arr2[j++];
//        }


    }

    public static void main(String[] args) {
        int [] arr1 = {3, 8, 10, 15};
        int [] arr2 = {7, 10, 12, 19, 25};
        int [] arr = new int[arr1.length+arr2.length];
        problem7(arr1,arr2,arr);
        for (int j : arr) {
            System.out.print(j + " ");
        }
    }
}
