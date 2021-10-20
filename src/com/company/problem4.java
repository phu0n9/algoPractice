package com.company;

import java.util.ArrayList;
import java.util.List;

public class problem4 {

    public static ArrayList<Integer> exercise4(int n){
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

    public static void main(String[] args) {
        System.out.println(exercise4(3));
        System.out.println(exercise4(10));
    }
}
