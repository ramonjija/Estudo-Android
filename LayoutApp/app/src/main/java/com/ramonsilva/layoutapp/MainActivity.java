package com.ramonsilva.layoutapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    public void fade(View view) {
        ImageView bart = findViewById(R.id.imgViewBart);
        bart.animate().translationXBy(-1000f).setDuration(2000);
//        ImageView homer = findViewById(R.id.imgViewHomer);
//        bart.animate().alpha(0f).setDuration(2000);
//        homer.animate().alpha(1f).setDuration(2000);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
