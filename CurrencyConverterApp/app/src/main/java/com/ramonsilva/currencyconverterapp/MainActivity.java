package com.ramonsilva.currencyconverterapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void convertCurrency(View view) {
        EditText currencyEditTextView = findViewById(R.id.idEditTextCurrency);
        if(!currencyEditTextView.getText().toString().isEmpty()) {
            double currency = Double.parseDouble(currencyEditTextView.getText().toString());
            double coeficiente = 0.0;
            String simbol = "R$";

            RadioButton rdoBtnDolar = findViewById(R.id.idRdoBtnDolar);
            RadioButton rdoBtnReal = findViewById(R.id.idRdoBtnReal);

            if (rdoBtnDolar.isChecked()) {
                simbol = "U$";
                coeficiente = 3.9;
            } else {
                coeficiente = (1 / (3.9));
            }
            double result = (currency * coeficiente);
            String strResult = Double.toString(result);
            Log.i("result", strResult);
            Toast.makeText(MainActivity.this, simbol+" "+strResult, Toast.LENGTH_LONG).show();
            currencyEditTextView.setText("");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
