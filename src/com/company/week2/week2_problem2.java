package com.company.week2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class week2_problem2 {

    public static Integer binarySearch(List<Integer> arr){
        int start = 0;
        int end = arr.size() - 1;
        while ((end - start) > 1){
            int mid = (start + end) / 2;
            if (arr.get(start) - start != arr.get(mid) - mid){
                end = mid;
            }
            else if (arr.get(end) - end != arr.get(mid) - mid){
                start = mid;
            }
        }
        return arr.get(start)+1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Insert array input size: ");
        int n = scanner.nextInt();
        System.out.print("Insert your array: ");
        List<Integer> arr = new ArrayList<>(n);
        for (int i = 0; i<n;i++) {
            arr.add(scanner.nextInt());
        }
        System.out.println("Missing number is: "+binarySearch(arr));
    }
}
