package com.example.customlistview3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.listitem.view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // set a custom adapter to the listView,
        listView.adapter = CustomAdapter()
    }

    private class CustomAdapter : BaseAdapter() {

        private val animals = arrayListOf(
                "Dog", "Cat", "Tiger", "Elephant", "Mouse", "Squirrel",
                "Dog", "Cat", "Tiger", "Elephant", "Mouse", "Squirrel",
                "Dog", "Cat", "Tiger", "Elephant", "Mouse", "Squirrel",
                "Dog", "Cat", "Tiger", "Elephant", "Mouse", "Squirrel"
        )

        // create/inflate view for each listItem
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

            /*
             convertView store our "view" so that it can be reused to create other row
             either inflate/create xml view,or reuse convertView
             parent:ViewGroup gives the class on which this list is shown i.e. "MainActivity"
            */

            val row: View
            if (convertView == null) {

                //use layout inflater to get view from xml
                val layoutInflater = LayoutInflater.from(parent!!.context)
                row = layoutInflater.inflate(R.layout.listitem, parent, false)

                val rowName = row.textView_name  // ~ row.findViewById<TextView>(R.id.textView_name)
                val rowPosition = row.textView_position
                val viewHolder = ViewHolder(rowName,rowPosition)

                // store viewHolder in row, data's can be stored in view using tag
                row.tag = viewHolder

            } else {
                // use convertView to avoid inflating view again
                row = convertView
            }

            // get viewHolder stored in row && set the properties
            val viewHolder = row.tag as ViewHolder
            viewHolder.textView_name.text = getItem(position)
            viewHolder.textView_postion.text = "Row number : $position"

            return row
        }

        // return content(name from animals array) to show in list item
        override fun getItem(position: Int): String {

            // to return both strings (name,position) we need to create a model class
            // with properties of name and position and return the object

            return "Name : ${animals[position]}"
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        // number of items in the list
        override fun getCount(): Int {
            return animals.size
        }


    /*
     *  ViewHolder is a class to hold reference of inner views in inflated layout
     *  it minimizes the no. of calls to get views( getViewById call ) specially when scrolling
     *  it calls function to get views when layout is first created only
    */

        private class ViewHolder(val textView_name:TextView,val textView_postion:TextView)
    }

}