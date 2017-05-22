package com.example.art.a15minrssfeed

import android.app.ProgressDialog
import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import com.google.gson.Gson
import com.google.gson.JsonElement
import com.google.gson.JsonParser
import java.net.URL
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonToken
import org.json.JSONException
import java.io.BufferedReader
import java.io.IOError
import java.io.IOException
import java.io.InputStreamReader
import java.net.HttpURLConnection


class MainActivity : AppCompatActivity() {
    val arrayForTest: Array<String> = arrayOf("11", "12", "13id", "14", "15", "16", "17", "18", "19", "20", "asd", "asdga", "asdasd")
    val myUrl: String = "https://content.guardianapis.com/search?q=debate&tag=politics/politics&from-date=2014-01-01&api-key=test"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadFragment(MyFragment(arrayForTest))
//        val response = JsonReaderr().response
//        Log.d(javaClass.simpleName, response.toString())

//nuo cia//        val myUrl: String = "https://content.guardianapis.com/search?q=debate&tag=politics/politics&from-date=2014-01-01&api-key=test"
//        val getJsonDownlad = DownloadRssFeed()
//        val result: String = getJsonDownlad.execute(myUrl).get()// get nereikia!!!!!

//        val response = JsonReaderr(result).response
//iki cia//        Log.d(javaClass.simpleName, response.toString())


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


        val REQUEST_METHOD: String = "GET"
        val READ_TIMEOUT: Int = 15000
        val CONNECTION_TIMEOUT: Int = 15000

        val LOG_TAG = javaClass.simpleName
        var proDialog: ProgressDialog? = null
        override fun onPreExecute() {
            Log.d(LOG_TAG, "onPreExecute()ooooooooooooooooooooooooooooo")
            super.onPreExecute()
            proDialog = ProgressDialog(this@MainActivity)
//            val proDialog: ProgressDialog = ProgressDialog(this@MainActivity)
            proDialog!!.setMessage("Loading...")
            proDialog!!.setCancelable(false)
            proDialog!!.show()

        }

        override fun doInBackground(vararg params: String?): String? {//viska keist

            val stringUrl: String = params[0].toString()
            val result: String? = try {
                val myUrl: URL = URL(stringUrl)
                val connection: HttpURLConnection = myUrl.openConnection() as HttpURLConnection //CIA KAZKAS NEGERAI!!!
                connection.inputStream.bufferedReader().readText()
            } catch(e: JSONException) {
                e.printStackTrace()
                "mdfk"
//                null
            } catch(e: IOException) {
                e.printStackTrace()
                "mdfk2"
//                null
            }
            Log.d(LOG_TAG, "doInBackground(vararg)uuuuuuuuuuuuuuuuuuuuuuuuuuuuuu")//delete later all logs
            return result.toString() //erroras -> mdfk2 gaunu
        }

//         override fun onProgressUpdate(vararg values: Int?) {
//             Log.d(LOG_TAG, "onProgressUpdate(vararg)eeeeeeeeeeeeeeeeeeeeeeeeeeeee")
//             super.onProgressUpdate(*values)
//         }

        override fun onPostExecute(result: String?) {
            Log.d(LOG_TAG, "onPostExecute(vararg)aaaaaaaaaaaaaaaaaaaaaaaaaaa")
            super.onPostExecute(result)
            if (proDialog!!.isShowing){
                proDialog!!.dismiss()
            }
        }

    }

}
