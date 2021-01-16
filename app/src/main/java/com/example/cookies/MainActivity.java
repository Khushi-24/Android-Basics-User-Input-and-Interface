package com.example.cookies;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void eatCookie(View view) {
        ImageView newImage = (ImageView) findViewById(R.id.before);
        newImage.setImageResource(R.drawable.after_cookie);

        TextView newText = (TextView) findViewById(R.id.text);
        newText.setText("I am so full");
    }
}