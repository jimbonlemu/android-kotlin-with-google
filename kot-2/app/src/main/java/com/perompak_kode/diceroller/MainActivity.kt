package com.perompak_kode.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton : Button =   findViewById(R.id.button)
            rollButton.setOnClickListener {

                rollDice()
            }
    }
    /**
     * Roll the dice and update the screen with the result.
     */
    private fun rollDice() {
        // Create new Dice object with 6 sides and roll the dice
        val dice = Dice(6)
        val diceRoll = dice.roll()

        // Find the ImageView in the layout
        val diceImage : ImageView = findViewById(R.id.imageView)
        val diceImage2 : ImageView = findViewById(R.id.imageView2)

        // Determine which drawable resource ID to use based on the dice roll
       val drawableResource =  when (diceRoll){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
       }
        val toast = Toast.makeText(this,"You rolled a ${diceRoll} ", Toast.LENGTH_SHORT)
        toast.show()
        // Update the ImageView with the correct drawable resource ID
        diceImage.setImageResource(drawableResource)
        diceImage2.setImageResource(drawableResource)

        // Update the content description
        diceImage.contentDescription = diceRoll.toString()
        diceImage2.contentDescription = diceRoll.toString()

    }
}

class Dice(val numSides:Int){
    fun roll():Int{
        return (1..numSides).random()
    }
}