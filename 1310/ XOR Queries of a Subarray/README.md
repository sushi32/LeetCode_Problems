# Question
https://leetcode.com/problems/xor-queries-of-a-subarray/description/

You are given an array arr of positive integers. You are also given the array queries where queries[i] = [lefti, righti].

For each query i compute the XOR of elements from lefti to righti (that is, arr[lefti] XOR arr[lefti + 1] XOR ... XOR arr[righti] ).

Return an array answer where answer[i] is the answer to the ith query.

Example 1:
```
Input: arr = [1,3,4,8], queries = [[0,1],[1,2],[0,3],[3,3]]
Output: [2,7,14,8] 
Explanation: 
The binary representation of the elements in the array are:
1 = 0001 
3 = 0011 
4 = 0100 
8 = 1000 
The XOR values for queries are:
[0,1] = 1 xor 3 = 2 
[1,2] = 3 xor 4 = 7 
[0,3] = 1 xor 3 xor 4 xor 8 = 14 
[3,3] = 8
```

Example 2:
```
Input: arr = [4,8,2,10], queries = [[2,3],[1,3],[0,0],[0,3]]
Output: [8,0,4,4]
```

**Constraints:**
- 1 <= arr.length, queries.length <= 3 * 10^4
- n -> arr.length
- m -> queries.length
- 1 <= arr[i] <= 10^9
- queries[i].length == 2
- 0 <= left_i <= right_i < arr.length

# Intuition

- Basic approach was: 
  - Take each query from queries and perform xor for the range left to right.
  - In worst case for each query we might need to traverse entire array to find xor result.
  - So each query takes => O(n)
  - And we need to repeat it for m queries.
  - `Total time: O(mn)`
  - No extra space is required.
- Now in this basic approach we are doing calculations repeatedly for different queries.
- This can be optimized using the **prefix array** technique.

# Approach 1:

1. In this approach we calculate and store prefix XOR array result.
2. prefix_XOR[i] = arr[0] xor arr[1] xor .... arr[i-1]
3. prefix_XOR[0] = 0
4. So we have i+1 elements in prefix array.
5. XOR<sub>[left, right]</sub> = prefix_XOR[right+1] xor prefix_XOR[left]

## Time Complexity:

1. This approach takes linear time to calculate prefix array => O(n)
2. And constant time to calculate XOR of each query, since it is just looking up prefix array and taking xor result.
3. We have 'm' queries => m * O(1) => O(m)
4. Total time: `O(m+n)`

## Space Complexity:

1. We need extra space to store the prefix array.
2. Total space: `O(n)`

# Approach 2:

- This approach is similar to previous approach, with small optimization of not using extra space.
- So in this we try to store the prefix xor result in the 'arr' itself, by doing it in-place.
- XOR<sub>[left, right]</sub> = prefix_XOR[right] xor prefix_XOR[left-1]
- Only if the left index > 0.
- Other than this entire logic remains same.
- Time complexity = `O(m+n)`
- No extra space needed.

