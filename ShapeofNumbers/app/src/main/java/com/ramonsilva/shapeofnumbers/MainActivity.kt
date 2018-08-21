package com.ramonsilva.shapeofnumbers

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.absoluteValue

class MainActivity : AppCompatActivity() {

    class MyNumber {
        var number = 0;
        private var triangularNumber = 0;
        fun isTriangular():Boolean {
            var x = 1;
            while(triangularNumber <= number) {
                triangularNumber += x;
                x++;
                if(number == triangularNumber) {
                    return true;
                }
            }
            return false;
        }
        fun isSquared():Boolean {
            val sqrtRoot = Math.sqrt(number.toDouble()).absoluteValue;
            Log.i("TestSqrt", sqrtRoot.toString());
            if(sqrtRoot == Math.floor(sqrtRoot)) {
                return true;
            }
            return false;
        }
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        idBtnTestNumber.setOnClickListener{
            checkMyNumber();
        }
    }

    private fun checkMyNumber() {
        val inputtedNumber = findViewById<EditText>(R.id.idEditTextNumber).text.toString().toInt();
        val MyNumber = MyNumber();
        MyNumber.number = inputtedNumber;
        if(MyNumber.isTriangular()) {
            if(MyNumber.isSquared()) {
                makeText("The Number is Triangular and Squared");
            } else {
                makeText("The Number is Triangular");
            }
        } else if(MyNumber.isSquared()){
            if(MyNumber.isTriangular()) {
                makeText("The Number is Triangular and Squared");
            } else {
                makeText("The Number is Squared");
            }
        } else {
            makeText("The Number is not Triangular nor Squared");
        }
    }

    private fun makeText(text:String) {
        Toast.makeText(this@MainActivity, text, Toast.LENGTH_LONG).show();
    }
}
