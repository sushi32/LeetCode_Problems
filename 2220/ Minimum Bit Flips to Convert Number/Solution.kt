package `2220`.` Minimum Bit Flips to Convert Number`

class Solution {
    fun minBitFlips(start: Int, goal: Int): Int {
        // 1 xor 1 = 0; 0 xor 1 = 1
        // Hence, xor of 2 numbers will result in number with 1 in bits that differ

        var xorVal = start xor goal
        var bitFlips = 0

        // Starting with LSB,
        // check if there is 1 at each bit and count accordingly
        while (xorVal > 0) {
            bitFlips += if (xorVal and 1 == 1) 1 else 0
            xorVal = xorVal shr 1
        }

        return bitFlips
    }
}