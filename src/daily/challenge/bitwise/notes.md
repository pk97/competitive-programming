# bitwise important concepts

1. & operator ->  bitwise AND 1 & 4 = 1 & 100 = 000 = 0
2. ^ xor ->  XOR of 1 ^ 4 = 1 ^ 100 = 001 = 1
3. | operator -> 1 | 4 =  1 | 100 = 101 = 5
4. << shift left -> a << b = a shifts left by b bits eg. 19 << 4 = 10011 << 3 = 11 = 3 
5. >> shift right -> a >> b = a shifts right by b bits eg. 19 >> 4 = 10011 >> 3  = 10 = 2

How to count no of set bits?

- Loop through each bit and check but this will take a lot of time.

```
 while (x >0) {
 // check if the least sign. bit is set
   if (x & 1 == 1) 
        count++;
 }
```

- options 2  Brian Kernighans algorithm
- x -1 will invert all the bits to the right of the rightmost 1 including it.
- with x & x-1, it makes rightmost 1 to zero. Thus basically we can repeat this logic and with each loop ones will disappear 
- and hence can be counted. 

```
while (x >0) {
    x = x & (x-1)
    count++;
}
```