package com.example.listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


//        Array can be declared using arrayOf & Array constructor

//        val productList = arrayOf("Product 1","Product 2","Product 3")    /*using arrayOf*/

//        using Array with lambda function.
        val productList = Array(21) {
                i ->
            "Product $i"
        }

        productList[0] = "All Products"

//        Create an adapter using a layout and array to be shown in the list
        val productAdapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,productList)

//        Attach the adapter to the listView
        listView_products.adapter = productAdapter

    }
}
