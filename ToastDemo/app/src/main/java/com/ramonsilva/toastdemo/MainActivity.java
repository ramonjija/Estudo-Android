package com.ramonsilva.toastdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void toastName(View view) {
        EditText myEditText = findViewById(R.id.idTxtViewName);
        String myText = myEditText.getText().toString();
        Toast.makeText(MainActivity.this, myText, Toast.LENGTH_LONG).show();
        Log.i("Button",myText);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
