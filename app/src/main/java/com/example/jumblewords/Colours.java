package com.example.jumblewords;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Colours extends AppCompatActivity {
    private static String[] colours = {"BLACK", "ORANGE", "GREEN", "RED", "COPPER", "LIME", "PERIWINKLE", "YELLOW", "PURPLE", "PINK", "VIOLET", "TURQUOISE", "WHITE", "CRIMSON", "JADE", "AMBER", "AQUAMARINE", "BEIGE", "BRONZE", "BROWN", "BURGUNDY", "CYAN", "BLUE", "SILVER", "GOLDEN", "EMERALD", "INDIGO", "GREY", "LAVENDER", "LILAC", "MAGENTA", "MAROON", "MAUVE", "PEACH", "TEAL", "SCARLET", "TAN", "PLUM", "IVORY", "AZURE", "NAVY BLUE", "NEON PINK", "NEON GREEN", "NEON YELLOW"};
    private static int point = 0, tries = 3;
    private static String ans = null, currWord = null, msg;
    private TextView text1, text2;
    private EditText edit;
    private Button b1, b2, b3;
    Animation bounce;
    Random r = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colours);
        text1 = findViewById(R.id.titleText);
        text2 = findViewById(R.id.wordText);
        edit = findViewById(R.id.answer);
        b1 = findViewById(R.id.checkBtn);
        b2 = findViewById(R.id.newBtn);
        b3 = findViewById(R.id.quitBtn);
        Typeface type = Typeface.createFromAsset(getAssets(), "fonts/FredokaOneRegular.ttf");
        text1.setTypeface(type);
        text2.setTypeface(type);
        edit.setTypeface(type);
        b1.setTypeface(type);
        b2.setTypeface(type);
        b3.setTypeface(type);
        bounce= AnimationUtils.loadAnimation(this, R.anim.bounce);

        Game();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ans = edit.getText().toString();
                text1.startAnimation(bounce);
                text2.startAnimation(bounce);
                if (ans.equalsIgnoreCase(currWord)) {
                    text1.setText("CORRECT ANSWER!");
                    text2.setText(" ");
                    b1.setEnabled(false);
                    b2.setEnabled(true);
                    point++;
                } else {
                    text1.setText("INCORRECT ANSWER!");
                    text2.setText(currWord);
                    b1.setEnabled(false);
                    b2.setEnabled(true);
                    tries--;
                    if (tries == 0) {
                        finalPage();
                    }
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Game();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                finalPage();
            }
        });

    }

    public void Game() {
        currWord = colours[r.nextInt(colours.length - 1)];
        text1.setText("HERE IS YOUR WORD: ");
        text2.setText(jumbledWord(currWord));
        text1.startAnimation(bounce);
        text2.startAnimation(bounce);
        edit.setText("");
        b1.setEnabled(true);
        b2.setEnabled(false);
    }

    private String jumbledWord(String s) {
        String word = "";
        s += " ";
        List<String> letters = Arrays.asList(s.split(""));
        List<String> part = new ArrayList<String>();
        for (String letter : letters) {
            if (letter.equals(" ")) {
                Collections.shuffle(part);
                for (String alph : part) {
                    word += alph;
                }
                part.clear();
                word += letter;
            } else {
                part.add(letter);
            }
        }
        word = word.trim();
        return word;
    }

    public void finalPage() {
        if (point <= 2) {
            msg = "You can definitely do better! Try again?";
        } else if (point > 2 && point <= 8) {
            msg = "Good effort! Practice makes perfect. Try again to increase your score?";
        } else {
            msg = "Quite the word-master, aren't you? Think you can beat your score? Try again to find out!";
        }
        Intent intent = new Intent(this, finalScreen.class);
        intent.putExtra("Pnts", point);
        intent.putExtra("msg", msg);
        startActivity(intent);
        this.finish();
    }
}