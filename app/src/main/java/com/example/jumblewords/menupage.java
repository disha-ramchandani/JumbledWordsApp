package com.example.jumblewords;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class menupage extends AppCompatActivity {
    TextView text;
    private Button btn1, btn2, btn3;
    Animation bounce;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menupage);
        text=findViewById(R.id.mainMenu);
        btn1= findViewById(R.id.credBtn);
        btn2= findViewById(R.id.intructBtn);
        btn3 = findViewById(R.id.playBtn);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCred();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openInstruct();
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPlay();
            }
        });
        Typeface type= Typeface.createFromAsset(getAssets(), "fonts/FredokaOneRegular.ttf");
        text.setTypeface(type);
        btn1.setTypeface(type);
        btn2.setTypeface(type);
        btn3.setTypeface(type);
        bounce= AnimationUtils.loadAnimation(this, R.anim.bounce);
        text.startAnimation(bounce);
    }
    public void openCred()
    {
        Intent intent=new Intent(this, credits.class);
        startActivity(intent);
        this.finish();
    }
    public void openInstruct()
    {
        Intent intent=new Intent(this, instructpage.class);
        startActivity(intent);
        this.finish();
    }
    public void openPlay()
    {
        Intent intent=new Intent(this, gamepage.class);
        startActivity(intent);
        this.finish();
    }

}