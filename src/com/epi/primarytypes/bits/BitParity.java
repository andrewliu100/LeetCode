package com.epi.primarytypes.bits;

/**
 * The parity of a binary word is 1 if the number of 1s in the word is odd;
 * otherwise, it is 0.
 */
public class BitParity {

    public short bruteForce(int x) {
        short parity = 0;
        while (x != 0) {
            parity ^= x & 1;
            x = x >>> 1;
        }
        return parity;
    }


}
