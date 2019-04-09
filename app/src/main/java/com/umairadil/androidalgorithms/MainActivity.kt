package com.umairadil.androidalgorithms

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.umairadil.androidalgorithms.algos.BinaryGap
import com.umairadil.androidalgorithms.algos.MinLengthSubStringKDistinct
import com.umairadil.androidalgorithms.algos.MissingElement
import com.umairadil.androidalgorithms.algos.ReverseString

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Problem 1
        MinLengthSubStringKDistinct.testAlgo("efecfefdhgdjsdjsdjshdjhsjdhjshd",6)

        //Problem 2
        ReverseString.testAlgo(intArrayOf(9,8,7,6,5,4,3,2,1,0))

        //Problem 3
        BinaryGap.testAlgo(1041)

        //Problem 4
        MissingElement.testAlgo(intArrayOf(2,3,1,5))
    }
}
