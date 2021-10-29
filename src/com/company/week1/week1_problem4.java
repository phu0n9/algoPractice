package com.company.week1;

import java.util.ArrayList;
import java.util.List;

public class week1_problem4 {

    public static ArrayList<Integer> exercise4OnlyArray(int n){
        ArrayList<Integer> arrayList = new ArrayList<>(List.of(n));
        while (n > 1){
            if (n % 2 == 0){
                n /= 2;
            }
            else{
                n = n*3+1;
            }
            arrayList.add(n);
        }
        return arrayList;
    }

    public static void exercise4WithRecursive(int n){
        System.out.print(n + " ");
        if (n == 1){
            return;
        }
        if ((n % 2 == 0)) {
            exercise4WithRecursive(n / 2);
        } else {
            exercise4WithRecursive(n * 3 + 1);
        }
    }

    public static Integer exercise4(int n){
        int count = 0;
        while (n > 1){
            if (n % 2 == 0){
                n /= 2;
            }
            else{
                n = n*3+1;
            }
            count++;
        }
        return count;
    }


    public static void main(String[] args) {
        exercise4WithRecursive(3);
//        System.out.println(exercise4(10));
    }
}
