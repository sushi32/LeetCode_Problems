package `1371`.` Find the Longest Substring Containing Vowels in Even Counts`

import kotlin.math.max

class Solution {
    fun findTheLongestSubstring(s: String): Int {
        // assigning bitmask to each vowel
        val vowelMap = hashMapOf<Char, Int> (
            'a' to (1 shl 0),
            'e' to (1 shl 1),
            'i' to (1 shl 2),
            'o' to (1 shl 3),
            'u' to (1 shl 4)
        )

        // variable to handle 5 bit vowel count encoding
        var state = 0 //00000
        // binary to int conversion of the range
        val range = IntArray(32) {-1}
        var longestSubStr = 0

        // iterate through string
        for (i in s.indices) {
            // if the character is vowel
            if (vowelMap.contains(s[i])) {
                // toggle the corresponding bit of vowel in the state
                state = state xor vowelMap[s[i]]!!

                // update the index in the range array at which state value is seen for the first time
                // One exception is if the state value is 0, then the substring is considered from start till this index
                // Since empty string has state value of 0
                if (range[state] == -1 && state != 0) {
                    range[state] = i
                }
            }

            // Update the longest sub string length variable
            longestSubStr = max(longestSubStr, i - range[state])
        }

        return longestSubStr
    }
}