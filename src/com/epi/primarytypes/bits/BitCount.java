package com.epi.primarytypes.bits;

/**
 * Count the number of bits that are set to 1 in a non-negative integer.
 */
public class BitCount {

    /**
     * Time complexity: O(1).
     * O(n) and n is the total number of bits, since input is integer and integer has maximum
     * 32 bits in JAVA, O(n) => O(32) => O(1)
     */
    public short bruteForce(int x) {
        short count = 0;
        while (x != 0) {
            count += (x&1);
            x = x >>> 1;
        }
        return count;
    }

    /**
     * Trick: x & (x - 1) drops the lowest set bit of x.
     * This trick reduced the number of bit operations to the number of 1s in the integer.
     * Average time complexity is improved, but in worst case, it is still 32 bit operations.
     *
     * Time complexity: O(1).
     */
    public short improvedBruteForce(int x) {
        short count = 0;
        while (x != 0) {
            count++;
            x = x & (x - 1);
        }
        return count;
    }
}
