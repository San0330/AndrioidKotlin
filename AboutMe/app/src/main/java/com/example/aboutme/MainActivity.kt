package com.example.aboutme

import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nickname_button.setOnClickListener {
            addNickname(it)
        }
    }

    private fun addNickname(view: View){

        val nickname = editText.text
        editText.visibility =View.GONE
        view.visibility = View.GONE
        nickname_text.text = nickname
        nickname_text.visibility = View.VISIBLE

    }

}
