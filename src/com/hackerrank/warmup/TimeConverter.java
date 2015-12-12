package com.hackerrank.warmup;

import java.util.Scanner;

/**
 * Created by Andrew on 5/12/2015.
 */
public class TimeConverter {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        String time = in.next();

        String[] bits = time.split(":");
        Integer hour = Integer.valueOf(bits[0]);
        if (time.contains("AM")) {
            hour = hour % 12;
        } else if (time.contains("PM")) {
            hour = 12 + hour % 12;
        }
        if (hour < 10) {
            bits[0] = "0" + hour;
        } else {
            bits[0] = hour.toString();
        }
        System.out.print(bits[0] + ":" + bits[1] + ":" + bits[2].substring(0, 2));
    }
}
