package com.umairadil.androidalgorithms.algos

import android.util.Log

/**
 * Time-Complexity-PermMissingElem
 * A zero-indexed array A consisting of N different integers is given. The array contains integers in the range [1..(N + 1)], which means that exactly one element is missing.
 * Your goal is to find that missing element.
 *
 * Write a function:
 *
 * int solution(vector &A);
 * that, given a zero-indexed array A, returns the value of the missing element.
 *
 * For example, given array A such that:
 * A[0] = 2
 * A[1] = 3
 * A[2] = 1
 * A[3] = 5
 * the function should return 4, as it is the missing element.
 *
 * Assume that:
 * N is an integer within the range [0..100,000]; the elements of A are all distinct; each element of array A is an integer within the range [1..(N + 1)]. Complexity:
 * expected worst-case time complexity is O(N); expected worst-case space complexity is O(1), beyond input storage (not counting the storage required for input arguments).
 *
 * @source https://github.com/Mohammed-Abdelhady/Codility-Time-Complexity-PermMissingElem
 */
object MissingElement {

    private val TAG = "MissingElement"

    fun testAlgo(intArray: IntArray) {
        Log.i(TAG, "${findMissing(intArray)}")
    }

    private fun findMissing(array: IntArray): Int {

        val aSize = array.size
        var total = aSize * (aSize + 1)/ 2

        array.forEachIndexed { index, i ->
            if (index < array.size - 1)
                total -= i
        }

        return total
    }
}