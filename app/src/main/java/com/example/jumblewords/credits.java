package com.example.jumblewords;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class credits extends AppCompatActivity {
    TextView t1, t2, t3, t4, t5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);
        Button back = findViewById(R.id.backBtn);
        t1 = findViewById(R.id.intro);
        t2 = findViewById(R.id.disha);
        t3 = findViewById(R.id.kashish);
        t4 = findViewById(R.id.rishi);
        t5 = findViewById(R.id.details);
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
        t5.setTypeface(type);
    }
    public void goBack()
    {
        Intent intent= new Intent(this, menupage.class);
        startActivity(intent);
        this.finish();
    }
}