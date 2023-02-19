package com.perompak_kode.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton : Button =   findViewById(R.id.button)
            rollButton.setOnClickListener {
                val toast = Toast.makeText(this,"Dice Rolled", Toast.LENGTH_SHORT)
                toast.show()
                val resultTextView :TextView = findViewById(R.id.textView)
                val resultTextView2 :TextView = findViewById(R.id.textView2
                )

                resultTextView.text = "6"
                resultTextView2.text = "6"
                rollDice()
            }
    }

    private fun rollDice() {
        val dice = Dice(6)
        val diceRoll = dice.roll()

        val resultTextView: TextView = findViewById(R.id.textView)
        val resultTextView2: TextView = findViewById(R.id.textView2)

        resultTextView.text = diceRoll.toString()
        resultTextView2.text = diceRoll.toString()
    }
}

class Dice(val numSides:Int){
    fun roll():Int{
        return (1..numSides).random()
    }
}