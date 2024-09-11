# Intuition

<!-- Describe your first thoughts on how to solve this problem. -->

Given, Array of time slots of 2 persons.

Each time slot consists of starting and ending time.



We need to find out the slot that works for both the people which is of length atleast duration.



So my initial thoughts for sloving this problem is that for every time slot in slots1 Array, check if there is any time slot in slots2 that overlaps. And check if the overlapping time is atleast length of duration. While checking we need to also maintain the variable of minimum overlapping start time that works for both for returning at the end.



But in this approach for every time slot in slots1, we check every time slot in slots2 => Takes `O(nm)` time -> TLE.



Then my next intuition was to sort the slots1 and slots2 inorder to optimize the algorithm.



Which led to my first approach.



Constraints given in problem:

- Time slots of same person will not be overlappping.

- For each slot: start time < end time.



# Approach 1

<!-- Describe your approach to solving the problem. -->

1. Sort the arrays based on start time. So the slots will be in increasing order.

2. Now, we initialize 2 pointers to iterate over the slots1 and slots2.

3. Every iteration we check if there is overlapping between time slot from slot1 and time slot from slot2, then check if the overlapping is atleast of length duration; and return or continue with iterating accordingly.

4. At every iteration after checking, based on end times of slots1 and slots2 either increment pointer of slots1 or pointer of slots2.

5. We iterate until overlapping time slot of atleast length duration is found or one of pointers reaches end of array.



# Time complexity:

<!-- Add your time complexity here, e.g. $$O(n)$$ -->

1. length of slots1 => m; length of slots2 => n

2. Sorting takes => O(nlogn + mlogm)

3. In worst case we iterate over each and every time slot of slots1 and slots2 at max once => O(n+m).

4. Since every iteration we visit 1 new time slot and there are n+m time slots in total.

4. Total time: `O(nlogn + mlogm)`


# Space complexity:

<!-- Add your space complexity here, e.g. $$O(n)$$ -->

1. Sorting is done in-place.

2. We donot use any extra space => O(1)





---


# Approach 2

<!-- Describe your approach to solving the problem. -->

This next approach is based on heap (priority queue).

It is based of the intuition that there is no overlapping between the slots of same person.

So, if we insert all the slots into a min-heap and compare them; then if there is some overlap - it should definitely be between the slots of different persons.



The approach goes as below:

1. Initialize a heap and insert all the slots whose length is atleast duration into the heap.

2. Now, at every iteration pop an item from heap and compare it with the top element of heap. (The same logic from previous approach can be used for comparision).

3. Based on the result of comparision you can return or continue.

4. We continue traversal as long as there are atleast 2 slots in heap (since, we need 2 slots for comparision).


# Time Complexity
<!-- Add your time complexity here, e.g. $$O(n)$$ -->
1. We insert 'm+n' slots in heap.
2. Each insertion takes 'log(n+m)' for heapify.
3. Total 'm+n' insertions take => O((m+n) log(m+n)).
4. Every iteration we pop 1 slot from heap => Takes 'log(m+n)'
5. Worst case we iterate over the heap until its empty => (m+n) slots => O((m+n) log(m+n))
6. Total time: `O((m+n) log(m+n))`

# Space Complexity
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

1. We use extra space to store (m+n) slots in heap => `O(m+n)`
