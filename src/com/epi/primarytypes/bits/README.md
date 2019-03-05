# JAVA bit explanation
Java integers are of 32 bits, and always signed.<br/>
This means, the most significant bit (MSB) works as the sign bit.<br/>
The integer represented by an int is nothing but the weighted sum of the bits. <br/>
The weights are assigned as follows: 

| Bit#  | Weight |
| ----- | ------ |
|31     | -2^31  |
|30     |  2^30  |
|29     |  2^29  |
|...    |  ...   |
|2      |  2^2   |
|1      |  2^1   |
|0      |  2^0   |

Note that the weight of the MSB is negative (the largest possible negative actually), 
so when this bit is on, the whole number (the weighted sum) becomes negative.

Let's simulate it with 4-bit numbers:
| Binary |     Weighted sum       | Integer value |
| ------ | ---------------------- | ------------- | 
| 0000   | 0 + 0 + 0 + 0          |  0            |
| 0001   | 0 + 0 + 0 + 2^0        |  1            |
| 0010   | 0 + 0 + 2^1 + 0        |  2            |
| 0011   | 0 + 0 + 2^1 + 2^0      |  3            |
| 0100   | 0 + 2^2 + 0 + 0        |  4            |
| 0101   | 0 + 2^2 + 0 + 2^0      |  5            |
| 0110   | 0 + 2^2 + 2^1 + 0      |  6            |
| 0111   | 0 + 2^2 + 2^1 + 2^0    |  7 -> the most positive value  |
| 1000   | -2^3 + 0 + 0 + 0       |  -8 -> the most negative value | 
| 1001   | -2^3 + 0 + 0 + 2^0     |  -7            |
| 1010   | -2^3 + 0 + 2^1 + 0     |  -6            |
| 1011   | -2^3 + 0 + 2^1 + 2^0   |  -5            |
| 1100   | -2^3 + 2^2 + 0 + 0     |  -4            |
| 1101   | -2^3 + 2^2 + 0 + 2^0   |  -3            |
| 1110   | -2^3 + 2^2 + 2^1 + 0   |  -2            |
| 1111   | -2^3 + 2^2 + 2^1 + 2^0 |  -1            |

# JAVA primary types and bit representation
| Primary Type | bits | range |
| ------------ | ---- | ----- |
|byte          |  8   | -128 ~ 127 (-2^7 ~ 2^7-1) |
|short         |  16  | -32768 ~ 32767 (-2^15 ~ 2^15-1) |
|int           |  32  | -2147483648 ~ 2147483647 (-2^31 ~ 2^31-1) |
|long          |  64  | -2^63 ~ 2^63-1 |

# Bitwise operations
| Operator  | Description |    Example    | Explanation     | Note |
| --------- | ----------- | ------------- | -----------     | ---- |
|  \|       | bitwise OR  | 12 \| 25 = 29 |  00001100<br/>\| 00011001<br/>-----------<br/>00011101 = 29 |      |                                  
|  &        | bitwise AND | 12 & 25 = 8   |  00001100<br/>& 00011001<br/> -----------<br/>00001000 = 8  |      |
|  ^        | bitwise XOR | 12 ^ 25 = 21  |  00001100<br/>^ 00011001<br/> -----------<br/>00010101 = 21 |      |
|  ~        | bitwise complement |  ~12    | ~00001100<br/> -----------<br/>11110011 = -13 |      |
|  <<       | signed left shift | 12 << 2 = 48 | 00001100 << 2<br/> -----------<br/>00110000 = 48 | Equivalent to multiply by 2s.<br/>Shift left and fill 0s into rightmost positions. |
|  \>>      | signed right shift | 12 >> 2 = 3 | 00001100 >> 2<br/> -----------<br/>00000011 = 3  | Equivalent to divide by 2s.<br/>Shift right and fill 0s into leftmost positions for positives. |                                                
|           |                    | -12 >> 2 = -3 | 11110100 >> 2<br/> -----------<br/>11111101 = -3 | Shift right and fill 1s into leftmost positions for negatives.
|  \>>>     | unsigned right shift |  12 >>> 2 = 3 | 00001100 >>> 2<br/> -----------<br/>00000011 = 3 | Equivalent to divide by 2s for positives.<br/>Shift right and fill 0s into leftmost positions. |                                                 
|           |                      | -12 >>> 2 | 11110100 >>> 2<br/> -----------<br/>00..111101 = 1073741821 |       |  