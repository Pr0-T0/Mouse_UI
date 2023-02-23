package com.example.mouseuitest;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    Button leftButton;
    Button rightButton;
    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.TouchView);
        leftButton = (Button) findViewById(R.id.leftclick);
        rightButton = (Button) findViewById(R.id.rightclick);
        textView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                int x = (int) event.getX();
                int y = (int) event.getY();
                SignalSender.sendMouseData(x, y, false, false);
                return true;
            }
            public boolean performClick() {
                return false;
            }
        });
        leftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //System.out.println("0,0,true,false");
                SignalSender.sendMouseData(0, 0,true,false);
            }
        });
        rightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //System.out.println("0,0,false,true");
                SignalSender.sendMouseData(0, 0,false,true);
            }
        });
    }
}