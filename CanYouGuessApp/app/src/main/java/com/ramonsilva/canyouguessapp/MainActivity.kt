package com.ramonsilva.canyouguessapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.math.nextTowards

class MainActivity : AppCompatActivity() {
    var finished  = false;
    var rand = RandNumber();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        idBtnGuess.setOnClickListener{
            guessNumber();
        }
    }

    private fun guessNumber() {
        if(!findViewById<EditText>(R.id.idEditTextGuess).text.isNullOrEmpty()) {
            if (finished) {
                rand = RandNumber();
                finished = false;
                guessNumber();
            } else {
                val editText = findViewById<EditText>(R.id.idEditTextGuess).text.toString();
                val intEditText = editText.toInt();
                var message = "The number is minor than...";
                if (intEditText > rand) {
                    Toast.makeText(this@MainActivity, message, Toast.LENGTH_SHORT).show();
                } else if (intEditText < rand) {
                    message = "The number is major than...";
                    Toast.makeText(this@MainActivity, message, Toast.LENGTH_SHORT).show();
                } else {
                    message = "You're Right on the spot!";
                    Toast.makeText(this@MainActivity, message, Toast.LENGTH_LONG).show();
                    finished = true;
                }
            }
        }
    }

    private fun RandNumber(): Int {
        val randNumber = Random();
        var randNumberFound = randNumber.nextInt(20) - 1;
        return randNumberFound
    }
}
