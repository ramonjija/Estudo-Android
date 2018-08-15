package com.ramonsilva.demoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void showInfo(View view) {
        EditText myEditText = findViewById(R.id.idTxtViewMyTxt);
        String myText = myEditText.getText().toString();
        if(myText.length() > 0)
            Toast.makeText(MainActivity.this, myText, Toast.LENGTH_LONG).show();

        Log.i("ButtonClick","My button was clicked!");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
