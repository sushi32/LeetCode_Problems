package `1684`.` Count the Number of Consistent Strings`

class Solution {
    fun countConsistentStrings(allowed: String, words: Array<String>): Int {
        var consistent = 0
        // ASCII value of lowercase 'a'
        val aAscii = 'a'.toInt()

        // Traverse over the allowed string and
        // mark the characters as true
        val allowedMap = Array<Boolean>(26) {false}
        for (ch in allowed) {
            allowedMap[ch.toInt()-aAscii] = true
        }

        // For each word
        for (word in words) {
            var allExist = true
            // For each character in a word
            for (ch in word) {
                // check if 'allowed' string contains 'ch' from allowedMap
                // if not change allExist to false and break
                if (!allowedMap[ch.toInt()-aAscii]) {
                    allExist = false
                    break
                }
                // allExist will be true if all the characters of word are in allowed
            }

            // increment consistent if allExist is True
            if (allExist) consistent++
        }
        return consistent
    }
}
