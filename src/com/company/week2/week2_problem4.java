package com.company.week2;

import java.util.Arrays;

public class week2_problem4 {

    // arrival time is mostly smaller than departure, so always need new gates for arrival,
    // departure gates can be reused
    public static Integer minimumGate (double[] arrival,double [] departure){
        Arrays.sort(arrival);
        Arrays.sort(departure);
        int count = 1,i = 1, j = 0, platform = 1;
        while (i < arrival.length && j < departure.length ){
            if (arrival[i] <= departure[j]){
                count++;
                i++;
            }
            else{
                count--;
                j++;
            }

            if (count > platform){
                platform = count;
            }
        }

        return platform;
    }

    public static void main(String[] args) {
        double [] arrival = {1.00,1.40,1.50,2.00,2.15,4.00};
        double [] departure = {1.10,3.00,2.20,2.30,3.15,6.00};
        System.out.println("Minimum gate is: "+minimumGate(arrival,departure));
    }
}
