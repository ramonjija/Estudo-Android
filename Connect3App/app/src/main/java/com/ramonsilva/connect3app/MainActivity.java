package com.ramonsilva.connect3app;

import android.app.assist.AssistStructure;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int player = 0; //player 0 = yellow; 1 = red;
    private  int[] gameState = {
            2,2,2,
            2,2,2,
            2,2,2
    };
    private int[][] winningPositions = {
            {0,1,2},
            {3,4,5},
            {6,7,8},
            {0,3,6},
            {1,4,7},
            {2,5,8},
            {0,4,8},
            {2,4,6}
    };

    public void dropIn(View view) {

        ImageView counter = (ImageView)view;
        int tappedCounter = Integer.parseInt(counter.getTag().toString());
        if(gameState[tappedCounter] == 2)
        {
            gameState[tappedCounter] = player;
            counter.setTranslationY(-1000f);
            if (player == 0) {
                counter.setBackgroundResource(R.drawable.yellow);
                player = 1;
            } else {
                counter.setBackgroundResource(R.drawable.red);
                player = 0;
            }
            counter.animate().translationYBy(1000f).rotation(360).setDuration(300);
            for(int[] winningPosition : winningPositions) {
                if(gameState[winningPosition[0]] == gameState[winningPosition[1]] &&
                        gameState[winningPosition[1]] == gameState[winningPosition[2]] &&
                        gameState[winningPosition[0]] != 2) {
                    Log.i("winner", String.valueOf(gameState[winningPosition[0]]));
                    LinearLayout winnerLayout = findViewById(R.id.idLayoytWinner);
                    TextView winnerTxt = findViewById(R.id.idTxtMsgWinner);
                    String message = "Winner Player " + String.valueOf(gameState[winningPosition[0]]);
                    winnerTxt.setText(message);
                    winnerLayout.setVisibility(View.VISIBLE);
                }
            }
        }
    }

    public void restart(View view) {

        LinearLayout winnerLayout = findViewById(R.id.idLayoytWinner);
        winnerLayout.setVisibility(View.INVISIBLE);
        player = 0;
        for(int i = 0; i < gameState.length; i++) {
            gameState[i] = 2;
        }
        android.support.v7.widget.GridLayout gridLayout = findViewById(R.id.idGridLayout);
        for(int i =0; i < gridLayout.getChildCount(); i++) {
            ImageView child = (ImageView)gridLayout.getChildAt(i);
            child.setImageResource(0);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
