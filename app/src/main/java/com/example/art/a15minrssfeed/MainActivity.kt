package com.example.art.a15minrssfeed

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment


class MainActivity : AppCompatActivity() {

    val arrayForTest: Array<String> = arrayOf("11", "12", "13id", "14", "15", "16", "17", "18", "19", "20", "asd", "asdga", "asdasd")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadFragment(MyFragment(arrayForTest))
    }

    fun loadFragment(targetFragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()

        fragmentTransaction.add(R.id.fragments_list, targetFragment)
        fragmentTransaction.commit()
    }

}