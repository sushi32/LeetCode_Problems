package `3`.` Longest Substring Without Repeating Characters`

import kotlin.math.max

class SolutionSlidingWindowOptim {
    fun lengthOfLongestSubstring(s: String): Int {
        var maxNonRepitingLen = 0

        var start = 0

        // To store the unique characters of current window from start to end along with their index
        val charMap = hashMapOf<Char, Int>()

        for (end in s.indices) {
            // If the new character is present in window
            // we update the start so that it points to next pointer
            if (charMap.containsKey(s[end])) {
                // we take max incase if the duplicate is already out of the window
                // current index of s[end] < start
                // Example test case: "abba"
                start = max(charMap.get(s[end])!!+1, start)
            }

            // update the index of the duplicate with new index
            charMap.put(s[end], end)

            // To keep track of max length
            maxNonRepitingLen = max(maxNonRepitingLen, end-start+1)
        }

        return maxNonRepitingLen
    }
}
