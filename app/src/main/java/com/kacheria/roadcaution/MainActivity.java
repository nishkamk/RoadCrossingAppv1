package com.kacheria.roadcaution;

import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    protected boolean colorChoice = true;

    Handler timerHandler = new Handler();
    Runnable timerRunnable = new Runnable() {
        @Override
        public void run() {
            TextView textView = (TextView) findViewById(R.id.stopText);
            textView.setBackgroundColor(colorChoice ? Color.RED : Color.WHITE);
            textView.setTextColor(colorChoice ? Color.WHITE : Color.RED);
            colorChoice = !colorChoice;
            timerHandler.postDelayed(this, 2000);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timerHandler.postDelayed(timerRunnable, 2000);
    }
}
