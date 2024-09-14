package `2419`.` Longest Subarray With Maximum Bitwise AND`

import kotlin.math.max

class Solution {
    fun longestSubarray(nums: IntArray): Int {
        // max bitwise-and for any possible sub array
        val maxBitwiseAnd = nums.max()

        // check if first value is equal to max value
        // max contiguous max value length till now
        var maxLength = if (nums[0] == maxBitwiseAnd) 1 else 0
        // current contiguous max value length
        var curLength = maxLength

        // for each index from 1 till end of array
        for (idx in 1..<nums.size) {
            // check if the value pointed to is equal to max value and
            // the previous index values is equal to max value
            // the increment current contiguous length
            if (nums[idx] == maxBitwiseAnd && nums[idx] == nums[idx-1]) {
                curLength += 1
            } else if (nums[idx] == maxBitwiseAnd) {
                // if previous index values is not equal to max value
                // And current index value is max value
                // initialize current contiguous length to 1
                curLength = 1
            } else {
                curLength = 0
            }

            // update max contiguous length
            maxLength = max(maxLength, curLength)
        }

        return maxLength
    }
}