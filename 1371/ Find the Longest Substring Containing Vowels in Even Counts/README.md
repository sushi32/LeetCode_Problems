# Question

https://leetcode.com/problems/find-the-longest-substring-containing-vowels-in-even-counts/description/

Given the string s, return the size of the longest substring containing each vowel an even number of times. That is, 'a', 'e', 'i', 'o', and 'u' must appear an even number of times.

Example 1:
```
Input: s = "eleetminicoworoep"
Output: 13
Explanation: The longest substring is "leetminicowor" which contains two each of the vowels: e, i and o and zero of the vowels: a and u.
```

Example 2:
```
Input: s = "leetcodeisgreat"
Output: 5
Explanation: The longest substring is "leetc" which contains two e's.
```

Example 3:
```
Input: s = "bcbcbc"
Output: 6
Explanation: In this case, the given string "bcbcbc" is the longest because all vowels: a, e, i, o and u appear zero times.
```

**Constraints:**

- 1 <= s.length <= 5 x 10^5
- s contains only lowercase English letters.

# Intuition

- **Bruteforce Approach:**
  - We will iterate through all the possible substrings, counting vowels.
  - But, this will result in a TLE.
- Optimized approach:
  - The problem says that we need to find the longest substring which contains even number of each and every vowel.
  - Hence, each and every vowel should be in counts of 0, 2, 4, ....
  - One point to note here is that we only care if the vowel occurrences is odd or even, we don't care about its count.
  - And we don't care about the consonants as well => represented as 0.
  - We can represent whether the counts of these 5 vowels are even or odd, using 5 bits.
  - If the count for each vowel (count mod 2) is even we can represent it as 0, else 1.
  - So we iterate through the string and toggle the respective bit when ever a vowel is found.
  - Since we have 5 bits => range: [0, 32)
  - Now, how we can find whether the count of vowels is even or odd using these 5 bits?
    - If the value of this 5 bit integer is same at 2 points of a string, it means that all vowels between these 2 points has occurred even number of times.

# Approach:

1. We create a vowel hashmap by assigning a bitmask to each vowel (a - 1, e - 2, i - 4, o - 8, u - 16).
2. We start with state (5 bit integer) value of 0.
3. Since the range of this state will be from 0 to 31, we can have an array of size 32 to keep track index where specific state value occurs.
4. We iterate through the string updating the state for each vowel, using vowel hashmap value.
5. At every iteration we update if the array[state value] is -1.
6. We also update the length of longest substring, based on state value.

## Time Complexity:

1. We iterate through the string once, and all other operations are constant time.
2. Total time: `O(n)`

## Space Complexity:

1. We use space for vowel hashmap => O(5)
2. We use space for array => O(32)
3. Since, both are constant.
4. Total Space = O(5) + O(32) ~ `O(1)`
