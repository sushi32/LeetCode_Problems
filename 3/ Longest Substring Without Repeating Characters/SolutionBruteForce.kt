package `3`.` Longest Substring Without Repeating Characters`

import kotlin.math.max

class SolutionBruteForce {
    fun lengthOfLongestSubstring(s: String): Int {
        var maxNonRepitingLen = 0

        // For substrings starting at index i
        for (i in s.indices) {
            // For substrings ending at index j
            for (j in i..<s.length) {
                // hash set to find out if the character is unique or duplicate
                val charSet = hashSetOf<Char>()
                var isDuplicate = false

                // for each character in the substring starts at i and ends at j
                for (ch in s.substring(i, j+1)) {
                    // if hash set already contains the character
                    // Means that it is duplicate
                    // So break the loop
                    if (charSet.contains(ch)) {
                        isDuplicate = true
                        break
                    }
                    charSet.add(ch)
                }

                // if the substring ending at j has duplicates
                // it means that substrings ending at j+1, j+2, .... also will have duplicates
                // Since they are just addition to current substring
                // else update the length
                if (isDuplicate) {
                    break
                } else {
                    maxNonRepitingLen = max(maxNonRepitingLen, j-i+1)
                }
            }
        }
        return maxNonRepitingLen
    }
}
