package com.example.jsonparsing

//model class for our json objects
class HomeFeed(val videos:List<Video>)

class Video(val id:Int, val name :String,val link:String,val imageUrl:String,numberOfViews:Int,val channel : Channel)

class Channel(val name:String,val profileImageUrl :String)