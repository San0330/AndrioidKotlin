package com.example.jsonparsing

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.listitem.view.*

class Adapter(var homeFeed: HomeFeed) : RecyclerView.Adapter<CustomViewHolder>(){

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val video = homeFeed.videos[position]
        holder.itemView.textView_title.text = video.name

        val thumbnail = holder.itemView.imageView
        // use picasso library to load image.
        Picasso.get().load(video.imageUrl).into(thumbnail)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val row = layoutInflater.inflate(R.layout.listitem,parent,false)
        return CustomViewHolder(row)
    }

    override fun getItemCount(): Int {
        return homeFeed.videos.size
    }
}

class CustomViewHolder(view: View) : RecyclerView.ViewHolder(view)