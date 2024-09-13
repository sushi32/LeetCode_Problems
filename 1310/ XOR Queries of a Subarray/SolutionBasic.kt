package `1310`.` XOR Queries of a Subarray`

class SolutionBasic {
    fun xorQueries(arr: IntArray, queries: Array<IntArray>): IntArray {
        val answers = IntArray(queries.size) {0}

        for (idx in queries.indices) {
            val query = queries[idx]
            var result = arr[query[0]]

            for (i in query[0]+1..query[1]) {
                result = result xor arr[i]
            }
            answers[idx] = result
        }

        return answers
    }
}
