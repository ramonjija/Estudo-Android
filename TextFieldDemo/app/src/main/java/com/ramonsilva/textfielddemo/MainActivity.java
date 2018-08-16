package com.ramonsilva.textfielddemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    public void loginUser(View view) {
        TextView txtViewUsername = findViewById(R.id.idTxtUsername);
        TextView txtViewPassword = findViewById(R.id.idTxtPassword);

        StringBuilder mystringBuilder = new StringBuilder();
        mystringBuilder
                .append(txtViewUsername.getText().toString())
                .append(" ")
                .append(txtViewPassword.getText().toString());

        String message = mystringBuilder.toString();
        Log.i("Info", message );
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
