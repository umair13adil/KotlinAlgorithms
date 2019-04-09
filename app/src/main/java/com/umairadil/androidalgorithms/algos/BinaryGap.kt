package com.umairadil.androidalgorithms.algos

import android.util.Log

/**
 * A binary gap within a positive integer N is any maximal sequence of consecutive zeros that is surrounded by ones at both ends in the binary representation of N.
 * For example, number 9 has binary representation 1001 and contains a binary gap of length 2.
 * The number 529 has binary representation 1000010001 and contains two binary gaps: one of length 4 and one of length 3.
 * The number 20 has binary representation 10100 and contains one binary gap of length 1.
 * The number 15 has binary representation 1111 and has no binary gaps.
 * The number 32 has binary representation 100000 and has no binary gaps.
 *
 * Write a function:
 *
 * fun solution(N: Int): Int
 * that, given a positive integer N, returns the length of its longest binary gap.
 * The function should return 0 if N doesn't contain a binary gap.
 *
 * For example, given N = 1041 the function should return 5, because N has binary representation 10000010001 and so its longest binary gap is of length 5. Given N = 32 the function should return 0, because N has binary representation '100000' and thus no binary gaps.
 * Write an efficient algorithm for the following assumptions:
 * N is an integer within the range [1..2,147,483,647].
 *
 * @source https://app.codility.com/programmers/lessons/1-iterations/binary_gap/
 */
object BinaryGap {

    private val TAG = "BinaryGap"

    fun testAlgo(number: Int) {
        Log.i(TAG, "${reverseString(number)}")
    }

    private fun reverseString(n: Int): Int {

        val inBinary = convertDecimalToBinary(n)

        //Log.i(TAG, "In Binary: ${inBinary}")

        val splited = inBinary.split("")

        var largestGapCount = 0
        var lookForGap = false
        var gapIndex = 0
        var previousGapIndex = 0
        var gapEndPresent = false
        val mapOfGaps = mutableMapOf<Int, Int>()

        splited.forEachIndexed { index, it ->

            if(it.isNotEmpty()) {
                if (it == "1" && !lookForGap) {

                    //If current binary is '1' start looking for '0's
                    lookForGap = true
                } else {
                    if (it == "1") {
                        //If current binary is '1' && is not already looking for '0's
                        lookForGap = false
                        gapEndPresent = true
                    } else {
                        lookForGap = true
                        gapEndPresent = false
                    }
                }

                if (lookForGap) {
                    if (it == "0") {
                        if (previousGapIndex <= gapIndex) {
                            largestGapCount++
                            previousGapIndex = gapIndex
                        } else {
                            previousGapIndex = gapIndex
                            gapEndPresent = false
                        }
                    }
                } else {
                    if (gapEndPresent) {
                        mapOfGaps[gapIndex] = largestGapCount

                        //Set current 'gap' index
                        gapIndex++
                    }
                    largestGapCount = 0
                }
            }
        }

        val sorted = mapOfGaps.entries.sortedByDescending{ it.value}

        if(sorted.isNotEmpty()){
            return sorted.first().value
        }else{
            return 0
        }
    }

    private fun convertDecimalToBinary(decimalNumber: Int, binaryString: String = "") : String {
        while (decimalNumber > 0) {
            val temp = "${binaryString}${decimalNumber%2}"
            return convertDecimalToBinary(decimalNumber/2, temp)
        }
        return binaryString.reversed()
    }
}