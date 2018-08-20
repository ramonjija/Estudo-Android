package com.ramonsilva.currencyappkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        idBtnConvert.setOnClickListener{
            convertCurrency();
        }
    }

    fun convertCurrency() {
        val editTextVal = findViewById<EditText>(R.id.idEditTextCurrency).text.toString();
        if(!editTextVal.isNullOrEmpty()) {
            val radioBtnRealToDolar = findViewById<RadioButton>(R.id.idRdoBtnRealToDolar);
            var coeficient = 2.5;
            var currency = "U$";
            if (radioBtnRealToDolar.isChecked) {
                currency = "R$";
                coeficient = 0.25;
            }
            val numberOfEditText = editTextVal.toDouble();
            val result = numberOfEditText * coeficient;

            val ajustedResult = String.format("%.2f", result);

            Toast.makeText(this@MainActivity, currency + ajustedResult, Toast.LENGTH_LONG).show();
            findViewById<EditText>(R.id.idEditTextCurrency).setText("");
        }
    }
}
