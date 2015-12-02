package com.hackerrank.warmup;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Created by Andrew on 1/12/2015.
 */
public class DiagonalDiff {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[][] = new int[n][n];
        for(int a_i=0; a_i < n; a_i++){
            for(int a_j=0; a_j < n; a_j++){
                a[a_i][a_j] = in.nextInt();
            }
        }

        int[] diff = new int[n];
        for (int row = 0; row < n; row++) {
            diff[row] = a[row][row] - a[row][n - row - 1];
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            result += diff[i];
        }
        System.out.println(Math.abs(result));
    }
}
