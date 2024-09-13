package `1310`.` XOR Queries of a Subarray`

class SolutionSpaceOptimal {
    fun xorQueries(arr: IntArray, queries: Array<IntArray>): IntArray {
        // to store the result
        val answers = IntArray(queries.size) {0}

        // prefix xor result calculation
        // updating the arr in-place
        for (idx in 1..<arr.size) {
            arr[idx] = arr[idx-1] xor arr[idx]
        }

        // for each query
        // calculate the result from prefix xor array
        for (idx in queries.indices) {
            var result = arr[queries[idx][1]]
            if (queries[idx][0] > 0) {
                result = result xor arr[queries[idx][0]-1]
            }
            answers[idx] = result
        }

        return answers
    }
}
