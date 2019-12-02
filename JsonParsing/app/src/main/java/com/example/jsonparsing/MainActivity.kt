package com.example.jsonparsing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import java.io.IOException

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.layoutManager = LinearLayoutManager(this)
//        recyclerView.adapter = Adapter()

        // fetch the json object
        fetchJson()
    }

    fun fetchJson(){

        //using okhttp to fetch json string from url
        var url = "https://api.letsbuildthatapp.com/youtube/home_feed"
        val client = OkHttpClient()
        val request = Request.Builder().url(url).build()

        client.newCall(request).enqueue(object: Callback {

            override fun onFailure(call: Call, e: IOException) {
                println("Request Failed !!!")
            }

            override fun onResponse(call: Call, response: Response) {

                //get the json string and store in body
                val body = response.body?.string()

                //using gson serialize the json string in body.
                val gson = GsonBuilder().create()
                val homeFeed  = gson.fromJson(body,HomeFeed::class.java)

                //show the recyclerview with homefeed data
                runOnUiThread{
                    recyclerView.adapter = Adapter(homeFeed)
                }

            }
        })
    }
}

