package com.hackerrank.warmup;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Created by Andrew on 2/12/2015.
 */
public class PlusMinus {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        for(int arr_i=0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }

        BigDecimal plus = new BigDecimal(0);
        BigDecimal minus = new BigDecimal(0);
        BigDecimal zero = new BigDecimal(0);
        BigDecimal one = new BigDecimal(1);
        BigDecimal total = new BigDecimal(n);
        for (int i : arr) {
            if (i > 0) plus = plus.add(one);
            else if (i < 0) minus = minus.add(one);
            else zero = zero.add(one);
        }
        System.out.println(plus.divide(total, 6, BigDecimal.ROUND_HALF_EVEN));
        System.out.println(minus.divide(total, 6, BigDecimal.ROUND_HALF_EVEN));
        System.out.println(zero.divide(total, 6, BigDecimal.ROUND_HALF_EVEN));
    }
}
