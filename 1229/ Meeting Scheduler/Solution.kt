package `1229`.` Meeting Scheduler`

import java.util.*
import kotlin.math.max
import kotlin.math.min

class Solution {
    fun minAvailableDuration(
        slots1: Array<IntArray>,
        slots2: Array<IntArray>,
        duration: Int
    ): List<Int> {

        // Sorting the Arrays based on start time of each slot
        slots1.sortWith(compareBy { it[0] })
        slots2.sortWith(compareBy { it[0] })

        var i = 0
        var j = 0

        while (i < slots1.size && j < slots2.size) {
            val start = max(slots1[i][0], slots2[j][0])
            val end = min(slots1[i][1], slots2[j][1])

            if (end-start >= duration) {
                return listOf(start, start+duration)
            }

            if (slots1[i][1] > slots2[j][1]) {
                j++
            } else {
                i++
            }
        }
        return emptyList()
    }
}
