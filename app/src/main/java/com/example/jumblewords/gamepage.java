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

public class gamepage extends AppCompatActivity {
    TextView text;
    private Button btn1;
    private Button colBtn;
    private Button aniBtn;
    private Button brandBtn;
    private Button conBtn;
    Animation bounce;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gamepage);
        text=findViewById(R.id.categories);
        btn1= findViewById(R.id.back);
        colBtn= findViewById(R.id.colours);
        aniBtn= findViewById(R.id.animals);
        brandBtn= findViewById(R.id.brands);
        conBtn= findViewById(R.id.countries);
        btn1.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view) {
                openMenu();
            }
        });
        colBtn.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view) {
                openColour();
            }
        });
        aniBtn.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view) {
                openAnimal();
            }
        });
        brandBtn.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view) {
                openBrand();
            }
        });
        conBtn.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view) {
                openCountry();
            }
        });
        bounce= AnimationUtils.loadAnimation(this, R.anim.bounce);
        text.startAnimation(bounce);
        Typeface type= Typeface.createFromAsset(getAssets(), "fonts/FredokaOneRegular.ttf");
        text.setTypeface(type);
        btn1.setTypeface(type);
        colBtn.setTypeface(type);
        aniBtn.setTypeface(type);
        brandBtn.setTypeface(type);
        conBtn.setTypeface(type);
    }
    public void openMenu() {
        Intent intent=new Intent(this, menupage.class);
        startActivity(intent);
        this.finish();
    }
    public void openColour(){
        Intent intent=new Intent(this, Colours.class);
        startActivity(intent);
        this.finish();
    }
    public void openAnimal(){
        Intent intent=new Intent(this, Animals.class);
        startActivity(intent);
        this.finish();
    }
    public void openBrand(){
        Intent intent=new Intent(this, Brands.class);
        startActivity(intent);
        this.finish();
    }
    public void openCountry(){
        Intent intent=new Intent(this, Countries.class);
        startActivity(intent);
        this.finish();
    }
}