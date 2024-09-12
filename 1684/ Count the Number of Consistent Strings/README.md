# Question
https://leetcode.com/problems/count-the-number-of-consistent-strings/description/

You are given a string allowed consisting of distinct characters and an array of strings words.
A string is consistent if all characters in the string appear in the string allowed.

Return the number of consistent strings in the array words.


Example 1:\
Input: allowed = "ab", words = ["ad","bd","aaab","baa","badab"]\
Output: 2\
Explanation: Strings "aaab" and "baa" are consistent since they only contain characters 'a' and 'b'.

Example 2:\
Input: allowed = "abc", words = ["a","b","c","ab","ac","bc","abc"]\
Output: 7\
Explanation: All strings are consistent.

Example 3:\
Input: allowed = "cad", words = ["cc","acd","b","ba","bac","bad","ac","d"]\
Output: 4\
Explanation: Strings "cc", "acd", "ac", and "d" are consistent.

Constraints:

- 1 <= words.length <= 10^4
- 1 <= allowed.length <= 26
- 1 <= words[i].length <= 10
- The characters in allowed are distinct.
- words[i] and allowed contain only lowercase English letters.

# Intuition

- **Brute Forcer Approach:**
  - For each character in the word from words go over the 'allowed' string and check if it exists.
  - If the character doesn't exist break the loop and continue for next word.
  - If you reach end of word, it means that all the characters exist and hence, increment the "consistent" count.
  - Time Complexity:
    - We will loop through all the words
    - for each character of word, we will loop through 'allowed' string.
    - n => length of words => 10^4
    - m => allowed length => 26
    - l => maximum length of each word => 10
    - Worst case: O(n\*m\*l)
- Intuition for next approach (optimization) comes from the below facts:
  - All characters of string "allowed" are distinct => Hence length can be maximum of 26.
  - Hence instead of checking if the character of word exists or not in the 'allowed' by traversing it => Which takes O(m)
  - We can store the allowed in hash map or hash set or array of size 26 (since only lowercase letters) => Takes constant time to retrieve.

# Approach

1. Iterate over the "allowed" string and store in some data structure for constant time retrieval.
2. Then you follow similar approach from brute-force.
3. But while checking if the character exists in allowed or not, use the created data structure.

# Time Complexity

1. Iterating over 'allowed' string => O(m)
2. Loop through all the words => (n)
3. For each word, take each character in word and check if character exist => O(l) * O(1)
4. Time for looping => O(n*l)
5. Total time => O(m+n*l)

# Space Complexity

1. Space is taken to store allowed string in a data structure => O(m).
