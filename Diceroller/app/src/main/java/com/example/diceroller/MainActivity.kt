package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        roll_button.text = "Roll"
        roll_button.setOnClickListener {
            rollDice()
        }

    }

    private fun rollDice() {
        var random = Random().nextInt(6)+1
        result_textView.text = "Dice rolled : $random"

        val drawableResource = when(random){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        dice_imageView.setImageResource(drawableResource)
    }
}
