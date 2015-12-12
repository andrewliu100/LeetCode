package com.hackerrank.Strings;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by Andrew on 7/12/2015.
 */
public class Pangrams {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        s = s.toLowerCase();
        Set<Character> charSet = new HashSet<>();
        for (char c : s.toCharArray()) {
            charSet.add(c);
        }
        char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
        'o', 'p', 'q', 'r','s','t','u','v','w','x','y','z'};
        Set<Character> alphabetSet = new HashSet<>();
        for (char c : alphabet) {
            alphabetSet.add(c);
        }
        alphabetSet.removeAll(charSet);
        System.out.print(alphabetSet.isEmpty() ? "pangram" : "not pangram");
    }
}
