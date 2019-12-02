package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.listitem.view.*

class Adapter : RecyclerView.Adapter<CustomViewHolder>(){

    private var imageTitles = arrayListOf(
        "First Image","Second Image","Third Image",
        "Fourth Image","Fifth Image","Sixth Image",
        "Seventh Image","Eighth Image","Ninth Image"
    )

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.itemView.textView_title?.text = imageTitles[position]
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val row = layoutInflater.inflate(R.layout.listitem,parent,false)
        return CustomViewHolder(row)
    }

    override fun getItemCount(): Int {
        return imageTitles.size
    }
}

class CustomViewHolder(view: View) : RecyclerView.ViewHolder(view)