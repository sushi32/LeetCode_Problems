# Question
https://leetcode.com/problems/minimum-bit-flips-to-convert-number/description/

A bit flip of a number x is choosing a bit in the binary representation of x and flipping it from either 0 to 1 or 1 to 0.

For example, for x = 7, the binary representation is 111 and we may choose any bit (including any leading zeros not shown) and flip it. 
We can flip the first bit from the right to get 110, flip the second bit from the right to get 101, flip the fifth bit from the right (a leading zero) to get 10111, etc.

Given two integers start and goal, return the minimum number of bit flips to convert start to goal.


Example 1:

Input: start = 10, goal = 7
Output: 3
Explanation: The binary representation of 10 and 7 are 1010 and 0111 respectively. We can convert 10 to 7 in 3 steps:
- Flip the first bit from the right: 1010 -> 1011.
- Flip the third bit from the right: 1011 -> 1111.
- Flip the fourth bit from the right: 1111 -> 0111.
  It can be shown we cannot convert 10 to 7 in less than 3 steps. Hence, we return 3.

# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->
In order to count the number of bit flips required to convert start to goal. We need to find the bit positions which differ in both the numbers.

So, we can go bit by bit to check if it varies or same.

If the bits in both the numbers vary, we need to flip it and hence needed to be counted.

# Approach
<!-- Describe your approach to solving the problem. -->

We can use "X-or" bitwise operator. Since xor of 2 numbers result in a number which has set bits (1) in positions that vary in both the numbers.

Once we found the xor result, we can use right shift operator to traverse bit by bit and count the set bits.

# Complexity
- Time complexity:
<!-- Add your time complexity here, e.g. $$O(n)$$ -->
1. Finding xor is linear - in terms of number of bits.
2. Finding bit count is linear - in terms of number of bits.
3. Given that numbers are in range of [0, 10^9].
4. A number 2^x can be represented in 'x+1' bits => 4 - 3 bits, 8 - 4 bits, 16 - 5 bits, ...etc
5. 1000 = 10^3 ~ 1024 = 2^10 => 10^9 ~ 2^30 => At max 31 bits.
6. Hence, it takes O(31) ~ constant time.

- Space complexity:
<!-- Add your space complexity here, e.g. $$O(n)$$ -->
1. No extra space is required ~ O(1).
