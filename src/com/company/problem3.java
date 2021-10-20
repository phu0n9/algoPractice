package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class problem3 {
    public static ArrayList<Integer> initializeArray(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Insert array input size: ");
        int n = scanner.nextInt();
        ArrayList<Integer> arrayList = new ArrayList<>(n);
        System.out.println("Insert array number: ");
        for (int i = 0; i<n;i++) {
            arrayList.add(scanner.nextInt());
        }
        System.out.println(arrayList);
        return arrayList;
    }

    public static boolean exercise3(ArrayList<Integer> arrayList){
        int max = Collections.max(arrayList);
        int min = Collections.min(arrayList);
        int length = arrayList.size();
        return max - min + 1 == length;
    }

    public static void main(String[] args) {
        System.out.println(exercise3(initializeArray()));
    }
}
