package `3`.` Longest Substring Without Repeating Characters`

import kotlin.math.max

class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        var maxNonRepitingLen = 0

        var start = 0
        var end = 0

        // To store the unique characters of current window from start to end
        val charSet = hashSetOf<Char>()

        while (start <= end && end < s.length) {
            // check if the new character is present in current window
            // if not add it and increment end pointer
            // else remove the character start is pointing to
            // and increment the start pointer
            if (!charSet.contains(s[end])) {
                charSet.add(s[end])
                end++
            } else {
                charSet.remove(s[start])
                start++
            }

            // To keep track of max length
            maxNonRepitingLen = max(maxNonRepitingLen, end-start)
        }

        return maxNonRepitingLen
    }
}