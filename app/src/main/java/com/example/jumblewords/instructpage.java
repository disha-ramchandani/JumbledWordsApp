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

public class instructpage extends AppCompatActivity {
    TextView t1, t2, t3, t4;
    Animation bounce;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructpage);
        Button back = findViewById(R.id.backBtn2);
        t1=findViewById(R.id.instructions);
        t2=findViewById(R.id.ptn1);
        t3=findViewById(R.id.ptn2);
        t4=findViewById(R.id.ptn3);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goBack();
            }
        });
        Typeface type= Typeface.createFromAsset(getAssets(), "fonts/FredokaOneRegular.ttf");
        back.setTypeface(type);
        t1.setTypeface(type);
        t2.setTypeface(type);
        t3.setTypeface(type);
        t4.setTypeface(type);
        bounce= AnimationUtils.loadAnimation(this, R.anim.bounce);
        t1.startAnimation(bounce);
    }

    public void goBack() {
        Intent intent = new Intent(this, menupage.class);
        startActivity(intent);
        this.finish();
    }
}