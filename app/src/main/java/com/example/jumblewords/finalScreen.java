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

public class finalScreen extends AppCompatActivity {
    TextView text, text1, text2;
    Button b1;
    Animation bounce;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_screen);
        text = findViewById(R.id.gameOver);
        text1 = findViewById(R.id.pntText);
        text2 = findViewById(R.id.descpText);
        b1 = findViewById(R.id.menuBtn);
        Typeface type = Typeface.createFromAsset(getAssets(), "fonts/FredokaOneRegular.ttf");
        text.setTypeface(type);
        text1.setTypeface(type);
        text2.setTypeface(type);
        b1.setTypeface(type);
        bounce= AnimationUtils.loadAnimation(this, R.anim.bounce);
        text.startAnimation(bounce);
        text1.startAnimation(bounce);
        text2.startAnimation(bounce);

        text1.setText("POINTS SCORED " + getIntent().getIntExtra("Pnts", 0));
        text2.setText(getIntent().getStringExtra("msg"));

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMenu();
            }
        });

    }

    private void openMenu() {
        Intent intent = new Intent(this, menupage.class);
        startActivity(intent);
        this.finish();
    }
}