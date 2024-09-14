package `2419`.` Longest Subarray With Maximum Bitwise AND`

class SolutionBruteForce {
    fun longestSubarray(nums: IntArray): Int {
        var maxBitwiseAnd = nums.max()
        var maxLength = 1
        val n = nums.size

        for (len in 2..n) {
            for (idx in 0..(n-len)) {
                var bitwiseAnd = nums[idx]
                for (i in idx+1..<(idx+len)) {
                    bitwiseAnd = bitwiseAnd and nums[i]
                }
                if (bitwiseAnd >= maxBitwiseAnd) {
                    maxBitwiseAnd = bitwiseAnd
                    maxLength = len
                }
            }
        }

        return maxLength
    }
}
