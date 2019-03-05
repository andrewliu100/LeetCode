package com.epi.primarytypes.bits;

public class BitOpDemo {

    public void bitwiseOR(int a, int b) {
        System.out.println(a + " | " + b);
        System.out.println("a bit rep: " + Integer.toBinaryString(a));
        System.out.println("b bit rep: " + Integer.toBinaryString(b));
        System.out.println("a|b bit rep: " + Integer.toBinaryString(a|b));
        System.out.println("a|b = " + (a|b));
    }

    public void bitwiseAND(int a, int b) {
        System.out.println(a + " & " + b);
        System.out.println("a bit rep: " + Integer.toBinaryString(a));
        System.out.println("b bit rep: " + Integer.toBinaryString(b));
        System.out.println("a&b bit rep: " + Integer.toBinaryString(a&b));
        System.out.println("a&b = " + (a&b));
    }

    public void bitwiseXOR(int a, int b) {
        System.out.println(a + " ^ " + b);
        System.out.println("a bit rep: " + Integer.toBinaryString(a));
        System.out.println("b bit rep: " + Integer.toBinaryString(b));
        System.out.println("a^b bit rep: " + Integer.toBinaryString(a^b));
        System.out.println("a^b = " + (a^b));
    }

    public void bitwiseComplement(int a) {
        System.out.println("~" + a);
        System.out.println("a bit rep: " + Integer.toBinaryString(a));
        System.out.println("~a bit rep: " + Integer.toBinaryString(~a));
        System.out.println("~a = " + (~a));
    }

    public void signedLeftShift(int a, int n) {
        System.out.println(a + "<<" + n);
        System.out.println("a bit rep: " + Integer.toBinaryString(a));
        System.out.println("a<<n bit rep: " + Integer.toBinaryString(a<<n));
        System.out.println("a<<n = " + (a<<n));
    }

    public void signedRightShift(int a, int n) {
        System.out.println(a + ">>" + n);
        System.out.println("a bit rep: " + Integer.toBinaryString(a));
        System.out.println("a>>n bit rep: " + Integer.toBinaryString(a>>n));
        System.out.println("a>>n = " + (a>>n));
    }

    public void unsignedRightShift(int a, int n) {
        System.out.println(a + ">>>" + n);
        System.out.println("a bit rep: " + Integer.toBinaryString(a));
        System.out.println("a>>>n bit rep: " + Integer.toBinaryString(a>>>n));
        System.out.println("a>>>n = " + (a>>>n));
    }

    public static void main(String[] args) {
        BitOpDemo demo = new BitOpDemo();
        // bitwise OR
        System.out.println("====bitwise OR=====");
        demo.bitwiseOR(12,25);
        // bitwise AND
        System.out.println("====bitwise AND=====");
        demo.bitwiseAND(12,25);
        // bitwise XOR
        System.out.println("====bitwise XOR=====");
        demo.bitwiseXOR(12, 25);
        // bitwise complement
        System.out.println("====bitwise complement=====");
        demo.bitwiseComplement(12);
        // signed left shift
        System.out.println("====signed left shift=====");
        demo.signedLeftShift(12, 2);
        demo.signedLeftShift(-12, 2);
        // signed right shift
        System.out.println("====signed right shift=====");
        demo.signedRightShift(12, 2);
        demo.signedRightShift(-12, 2);
        // unsigned right shift
        System.out.println("====unsigned right shift=====");
        demo.unsignedRightShift(12, 2);
        demo.unsignedRightShift(-12, 2);
    }
}
