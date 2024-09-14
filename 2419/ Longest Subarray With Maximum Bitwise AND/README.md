# Question
https://leetcode.com/problems/longest-subarray-with-maximum-bitwise-and/description/

You are given an integer array nums of size n.

Consider a non-empty subarray from nums that has the maximum possible bitwise AND.

In other words, let k be the maximum value of the bitwise AND of any subarray of nums. Then, only subarrays with a bitwise AND equal to k should be considered.
Return the length of the longest such subarray.

The bitwise AND of an array is the bitwise AND of all the numbers in it.

A subarray is a contiguous sequence of elements within an array.

Example 1:
```
Input: nums = [1,2,3,3,2,2]
Output: 2
Explanation:
The maximum possible bitwise AND of a subarray is 3.
The longest subarray with that value is [3,3], so we return 2.
```

Example 2:
```
Input: nums = [1,2,3,4]
Output: 1
Explanation:
The maximum possible bitwise AND of a subarray is 4.
The longest subarray with that value is [4], so we return 1.
```

**Constraints:**

- 1 <= nums.length <= 105
- 1 <= nums[i] <= 106

# Intuition:

=> The question is asking to find the length of sub-array which results in maximum bitwise 'AND'. And if there are 
multiple such sub-array's with maximum bitwise and return the length of longest one.

- **BruteForce Approach:**
  - We find out all the possible sub-arrays and take the bitwise and of each sub array by keeping track of 
  maximum bitwise-and, length of the sub array.
  - This is going to take: `O(n^3)` time. => TLE
  - No extra space is required.
- The intuition for optimized approach for the problem is based on the hint that: 
  - Bitwise-And of 2 numbers (one large, one small) will always result in a number lower-than or equal to the smaller number.
    - [a, b, c, d, ...] => a & b & c & d & ... <= min(a, b, c, d, ...)
  - So maximum possible bitwise-and of 2 numbers can only be achieved when both the numbers are equal.
    - [a, a, a, ...] => a & a & a & ... = min(a, a, a, ...) = a
  - So the problem boils down to finding the longest subarray where all the values are equal and the value is maximum of the array.
- Basically, we have to **"Find longest consecutive length of the maximum element of nums."**

# Approach:

1. The maximum bitwise-and for any possible sub array is equal to maximum value of the array.
2. And now we are going to find out maximum contiguous occurrences of this maximum value.

## Time Complexity:

1. Finding max of nums => O(n)
2. Then we traverse over the nums array once to find the maximum length => O(n)
3. Total time: O(n) + O(n) = `O(n)`

## Space Complexity:

1. No extra space is required.
