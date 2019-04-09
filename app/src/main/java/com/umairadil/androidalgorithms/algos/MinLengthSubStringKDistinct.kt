package com.umairadil.androidalgorithms.algos

import android.util.Log

/**
 * Minimum length substring with exactly K distinct characters
 * Given a string S and a number K. The task is to find the minimum length substring having exactly K distinct characters.
 *
 * Note: The string S consists of only lowercase English alphabets.
 * @source https://www.geeksforgeeks.org/minimum-length-substring-with-exactly-k-distinct-characters/
 */
object MinLengthSubStringKDistinct {

    private val TAG = "MinLengthSubString"

    fun testAlgo(str: String, k: Int) {
        Log.i(TAG, "${findMinLenStr(str, k)}")
    }

    private fun findMinLenStr(inputString: String, k: Int): String {
        val stringLength = inputString.length

        // Starting index of sliding window.
        var startIndex = 0

        // Ending index of sliding window.
        var endIndex = 0

        // To store count of character.
        val charactersCounts = IntArray(26)

        //Initialize all index values from '0'
        for (i in 0..25) charactersCounts[i] = 0

        // To store count of distinct
        // character in current sliding
        // window.
        var distEle = 0

        // To store length of current
        // sliding window.
        var currlen: Int

        // To store minimum length.
        var minlen = stringLength

        // To store starting index of minimum
        // length subString.
        var startInd = -1

        while (endIndex < stringLength) {

            // Increment count of current character
            // If this count is one then a new
            // distinct character is found in
            // sliding window.
            //Log.i(TAG,"${inputString[endIndex]}  ${inputString[endIndex] - 'a'}")
            charactersCounts[inputString[endIndex] - 'a']++

            if (charactersCounts[inputString[endIndex] - 'a'] == 1)
                distEle++

            // If number of distinct characters is
            // is greater than k, then move starting
            // point of sliding window forward,
            // until count is k.
            if (distEle > k) {
                while (startIndex < endIndex && distEle > k) {
                    if (charactersCounts[inputString[startIndex] - 'a'] == 1)
                        distEle--
                    charactersCounts[inputString[startIndex] - 'a']--
                    startIndex++
                }
            }

            // Remove characters from the beginning of
            // sliding window having count more than 1
            // to minimize length.
            if (distEle == k) {
                while (startIndex < endIndex && charactersCounts[inputString[startIndex] - 'a'] > 1) {
                    charactersCounts[inputString[startIndex] - 'a']--
                    startIndex++
                }

                // Comapre length with minimum length
                // and update if required.
                currlen = endIndex - startIndex + 1
                if (currlen < minlen) {
                    minlen = currlen
                    startInd = startIndex
                }
            }

            endIndex++
        }

        // Return minimum length subString.
        return inputString.substring(startInd, startInd + minlen)
    }
}