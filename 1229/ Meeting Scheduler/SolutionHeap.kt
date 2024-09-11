package `1229`.` Meeting Scheduler`

import java.util.*
import kotlin.math.max
import kotlin.math.min

class SolutionHeap {
    fun minAvailableDuration(
        slots1: Array<IntArray>,
        slots2: Array<IntArray>,
        duration: Int
    ): List<Int> {

        val timeSlotsHeap = PriorityQueue<IntArray>(compareBy {it[0]})

        for (timeSlot in slots1) {
            if (timeSlot[1]-timeSlot[0] >= duration) {
                timeSlotsHeap.add(timeSlot)
            }
        }

        for (timeSlot in slots2) {
            if (timeSlot[1]-timeSlot[0] >= duration) {
                timeSlotsHeap.add(timeSlot)
            }
        }

        while (timeSlotsHeap.size > 1) {
            val slot1 = timeSlotsHeap.poll()
            val slot2 = timeSlotsHeap.peek()

            val start = max(slot1[0], slot2[0])
            val end = min(slot1[1], slot2[1])

            if (end-start >= duration) {
                return listOf(start, start+duration)
            }
        }

        return emptyList()
    }
}