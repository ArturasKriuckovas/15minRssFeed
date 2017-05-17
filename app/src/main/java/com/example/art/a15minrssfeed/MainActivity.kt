package com.example.art.a15minrssfeed

import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import java.net.URL


class MainActivity : AppCompatActivity() {
    val arrayForTest: Array<String> = arrayOf("11", "12", "13id", "14", "15", "16", "17", "18", "19", "20", "asd", "asdga", "asdasd")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadFragment(MyFragment(arrayForTest))

        DownloadRssFeed().execute("https://www.15min.lt/rss?format=json")
    }

    fun loadFragment(targetFragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()

        fragmentTransaction.replace(R.id.fragments_list, targetFragment)
        fragmentTransaction.addToBackStack(null).commit()
    }

    fun listItemClicked(index: Int) {
        val item = arrayForTest[index]
        loadFragment(SingleItemFragmen(item))
    }

    override fun onBackPressed() {
        val fragmentManager = supportFragmentManager
        if(fragmentManager.backStackEntryCount == 1){
            finish()
        }else{
            fragmentManager.popBackStack()
        }

    }


     class DownloadRssFeed: AsyncTask<String, Int, String>() {
         val LOG_TAG = javaClass.simpleName

         override fun onPreExecute() {
             Log.d(LOG_TAG, "onPreExecute()ooooooooooooooooooooooooooooo")
             super.onPreExecute()
         }
         override fun doInBackground(vararg params: String?): String? {
             Log.d(LOG_TAG, "doInBackground(vararg)uuuuuuuuuuuuuuuuuuuuuuuuuuuuuu")
             return "String"
         }

         override fun onProgressUpdate(vararg values: Int?) {
             Log.d(LOG_TAG, "onProgressUpdate(vararg)eeeeeeeeeeeeeeeeeeeeeeeeeeeee")
             super.onProgressUpdate(*values)
         }

         override fun onPostExecute(result: String?) {
             Log.d(LOG_TAG, "onPostExecute(vararg)aaaaaaaaaaaaaaaaaaaaaaaaaaa")
             super.onPostExecute(result)
         }

    }
}
