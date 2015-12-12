package com.hackerrank.dp;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Created by Andrew on 5/12/2015.
 */
public class FibonacciMod {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int n = in.nextInt();

        BigDecimal[] fibonacciMod = new BigDecimal[n];
        fibonacciMod[0] = new BigDecimal(a);
        fibonacciMod[1] = new BigDecimal(b);
        for (int i = 2; i < n; i++) {
            fibonacciMod[i] = fibonacciMod[i-1].multiply(fibonacciMod[i-1]).add(fibonacciMod[i-2]);
        }
        for (BigDecimal bd : fibonacciMod)
            System.out.print(bd + " ");
    }
}
