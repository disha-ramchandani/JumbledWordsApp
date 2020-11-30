package com.example.jumblewords;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;

import java.io.*;

import android.os.Handler;
import android.view.View;
import android.view.accessibility.*;
import android.appwidget.*;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button button;
    TextView text, intro;
    ImageView brain;
    Animation bounce;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text=findViewById(R.id.gameName);
        intro=findViewById(R.id.intro);
        brain=findViewById(R.id.brain);
        button = (Button) findViewById(R.id.button);
        bounce= AnimationUtils.loadAnimation(this, R.anim.bounce);
            text.startAnimation(bounce);
            brain.startAnimation(bounce);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMainMenu();
            }
        });
        Typeface type= Typeface.createFromAsset(getAssets(), "fonts/FredokaOneRegular.ttf");
        intro.setTypeface(type);
        text.setTypeface(type);
        button.setTypeface(type);
    }

    public void openMainMenu() {
        Intent intent = new Intent(this, menupage.class);
        startActivity(intent);
        this.finish();
    }
}
