package com.example.customlistview

import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // set a custom adapter to the listView,
        // context is passed to create view programmatically in CustomAdapter

        listView.adapter = CustomAdapter(this)
    }

    private class CustomAdapter(context: Context) : BaseAdapter() {

        private val mContext = context

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

            // create a view with some text and return it...
            // this view is show in the list

            val textView = TextView(mContext)
            textView.text = "Row $position for my listview"
            if(position % 2 == 1) {
                val grey = Color.parseColor("#EEE000")
                textView.setBackgroundColor(grey)
            }
            return textView
        }

        override fun getItem(position: Int): Any {
            return "TEST"
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        // number of items in the list
        override fun getCount(): Int {
            return 50
        }
    }

}