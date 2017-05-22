package com.example.art.a15minrssfeed

import android.app.ProgressDialog
import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import java.net.URL
import org.json.JSONException
import java.io.IOException
import java.net.HttpURLConnection


class MainActivity : AppCompatActivity() {
    val arrayForTest: Array<String> = arrayOf("11", "12", "13id", "14", "15", "16", "17", "18", "19", "20", "asd", "asdga", "asdasd")
    val myUrl: String = "https://content.guardianapis.com/search?q=debate&tag=politics/politics&from-date=2014-01-01&api-key=test"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadFragment(MyFragment(arrayForTest))

        DownloadRssFeed().execute(myUrl)

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
        if (fragmentManager.backStackEntryCount == 1) {
            finish()
        } else {
            fragmentManager.popBackStack()
        }

    }


    inner class DownloadRssFeed : AsyncTask<String, Int, String>() {


        val LOG_TAG = javaClass.simpleName
        var proDialog: ProgressDialog? = null
        override fun onPreExecute() {
            Log.d(LOG_TAG, "onPreExecute()ooooooooooooooooooooooooooooo")
            super.onPreExecute()
            proDialog = ProgressDialog(this@MainActivity)
            proDialog!!.setMessage("Loading...")
            proDialog!!.setCancelable(false)
            proDialog!!.show()

        }

        override fun doInBackground(vararg params: String?): String? {

            val stringUrl: String = params[0].toString()
            val result: String? = try {
                val myUrl: URL = URL(stringUrl)
                val connection: HttpURLConnection = myUrl.openConnection() as HttpURLConnection
                connection.inputStream.bufferedReader().readText()
            } catch(e: JSONException) {
                e.printStackTrace()
                null
            } catch(e: IOException) {
                e.printStackTrace()
                null
            }
            Log.d(LOG_TAG, "doInBackground(vararg)uuuuuuuuuuuuuuuuuuuuuuuuuuuuuu")//delete later all logs
            return result.toString()
        }

         override fun onProgressUpdate(vararg values: Int?) {
             Log.d(LOG_TAG, "onProgressUpdate(vararg)eeeeeeeeeeeeeeeeeeeeeeeeeeeee")
             super.onProgressUpdate(*values)
         }

        override fun onPostExecute(result: String?) {
            Log.d(LOG_TAG, "onPostExecute(vararg)aaaaaaaaaaaaaaaaaaaaaaaaaaa")
            super.onPostExecute(result)
            if (proDialog!!.isShowing){
                proDialog!!.dismiss()
            }
        }

    }

}
