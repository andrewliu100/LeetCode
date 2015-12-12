package com.hackerrank.implementation;

import java.util.Scanner;

/**
 * Created by Andrew on 7/12/2015.
 */
public class AngryProfessor {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int testCase = Integer.valueOf(in.nextLine());
        boolean[] result = new boolean[testCase];
        for (int i = 0; i < testCase; i++) {
            String[] condition = in.nextLine().split(" ");
            int numOfStudent = Integer.valueOf(condition[0]);
            int threshold = Integer.valueOf(condition[1]);
            int count = 0;
            String[] arriveTimes = in.nextLine().split(" ");
            for (int j = 0; j < numOfStudent; j++) {
                if (Integer.valueOf(arriveTimes[j]) > 0) {
                    count++;
                }
            }
            if ((numOfStudent - count) < threshold) {
                result[i] = true;
            }
        }
        for (boolean cancel : result) {
            System.out.println(cancel ? "YES" : "NO");
        }
    }
}
