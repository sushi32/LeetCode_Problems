package `1684`.` Count the Number of Consistent Strings`

class SolutionBruteForce {
    fun countConsistentStrings(allowed: String, words: Array<String>): Int {
        var consistent = 0
        // For each word
        for (word in words) {
            var allExist = true
            // For each character in a word
            for (ch in word) {
                // check if 'allowed' string contains 'ch'
                // if not change allExist to false and break
                if (!allowed.contains(ch)) {
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