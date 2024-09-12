# Question
https://leetcode.com/problems/longest-substring-without-repeating-characters/description/

Given a string s, find the length of the longest substring without repeating characters.

Example 1:
```
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
```

Example 2:
```
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
```

Example 3:
```
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
```


Constraints:
- 0 <= s.length <= 5 * 10^4
- s consists of English letters, digits, symbols and spaces.

# Intuition
- **Brute Force Approach**:
  - Generate all possible substrings => there will be n^2 substrings
  - For each substring check if it has any duplicates.
  - Update the length if it has no duplicates and longer than previous length.
  - Time Complexity:
    - Checking if the string has any duplicates takes => O(n)
    - We should be doing it for n^2 substrings
    - Total time: n^2 * n => `O(n^3)`
  - Space Complexity:
    - For checking if the string has duplicates, we need use some datastructure such as hash set or hash map or an array with counts.
    - m => number of unique characters
    - In worst case we need to save all the uniques.
    - Total space: `O(n)`
- **Optimized Approach:**
  - While implementing the brute-force approach, you can see that,
  - We keep on iterating over same part multiple times. 
  - Let's say we checked for substring from 'i' to 'j', and then when we check for 'i' to 'j+1'
    - We go over 'i' to 'j' again and then check for 'j+1' index.
  - So the next approach is based on optimizing this part.

# Approach 1:

1. We use sliding window technique for this approach.
2. We have 2 pointers - start and end.
3. We increment the end pointer until there are no duplicates in the start to end substring.
4. And when you hit a duplicate you increment start pointer until the duplicate is out of the window.
5. At every Iteration we increment either start or end based on conditions.
6. While checking the max length.

## Time Complexity:
1. We go over each and every character of our string once using start and end pointers.
2. Time taken => `O(2n)` => `O(n)`

## Space Complexity:
1. Same as brute-force approach.

# Approach 2:

1. This approach is optimized sliding window, where we traverse over each character of string only once.
2. Here we use hash map to store the index of each character.
3. So, when we see a duplicate instead of traversing using 'start' until we found it, we directly access its index from map and point start to it.
4. Remaining logic will remain same as approach1.

## Time Complexity:
1. We go over each and every character of our string once.
2. Time taken => `O(n)`

## Space Complexity:
1. Same as brute-force approach.
