package com.umairadil.androidalgorithms.algos

import android.util.Log

/**
 * Write a program to reverse an array or string
 * Given an array (or string), the task is to reverse the array/string.
 * @source https://www.geeksforgeeks.org/write-a-program-to-reverse-an-array-or-string/
 */
object ReverseString {

    private val TAG = "ReverseString"

    fun testAlgo(intArray: IntArray) {
        reverseString(intArray).forEach {
            Log.i(TAG, "$it")
        }
    }

    private fun reverseString(intArray: IntArray): IntArray {
        val size = intArray.size

        val newArray = IntArray(size)

        intArray.forEachIndexed { index, i ->
            newArray[size - index - 1] = i
        }

        return newArray
    }
}