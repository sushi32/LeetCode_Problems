package `1310`.` XOR Queries of a Subarray`

class Solution {
    fun xorQueries(arr: IntArray, queries: Array<IntArray>): IntArray {
        // to store the result
        val answers = IntArray(queries.size) {0}

        // to store the calculated prefix result
        val prefixXor = IntArray(arr.size+1) {0}

        // prefix xor result calculation
        for (idx in 1..arr.size) {
            prefixXor[idx] = arr[idx-1] xor prefixXor[idx-1]
        }

        // for each query
        // calculate the result from prefix xor array
        for (idx in queries.indices) {
            answers[idx] = prefixXor[queries[idx][1]+1] xor prefixXor[queries[idx][0]]
        }

        return answers
    }
}