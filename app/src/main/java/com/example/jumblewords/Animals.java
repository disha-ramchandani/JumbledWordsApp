package com.example.jumblewords;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.ColorStateList;
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
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Animals extends AppCompatActivity {
    private static String[] animals = {"DOG", "CAT", "LION", "TIGER", "ZEBRA", "PANTHER", "HORSE", "GORILLA", "MONKEY", "HEDGEHOG", "MOUSE", "JACKAL", "SQUIRREL", "SLOTH", "RACCOON", "POSSUM", "CAMEL", "LLAMA", "ELEPHANT", "RABBIT", "FERRET", "BUFFALO", "DINGO", "WOMBAT", "KANGAROO", "POLAR BEAR", "KOALA", "SHEEP", "LEOPARD", "HAMSTER", "DONKEY", "GIRAFFE", "PORCUPINE", "HYENA", "PANDA", "CHEETHA", "WALRUS", "ANTELOPE", "DEER", "WOLF", "SKUNK", "IGUANA", "CHIMPANZEE", "HIPPOPOTAMUS", "SOLENODON", "ECHIDNA", "PLATYPUS", "ARMADILLO", "GERENUK"};
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
        setContentView(R.layout.activity_animals);
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
        bounce=AnimationUtils.loadAnimation(this, R.anim.bounce);

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
        currWord = animals[r.nextInt(animals.length - 1)];
        text1.setText("HERE IS YOUR WORD: ");
        text2.setText(jumbledWord(currWord));
        text1.startAnimation(bounce);
        text2.startAnimation(bounce);
        edit.setText("");
        b1.setEnabled(true);
        b2.setEnabled(false);
    }

    private String jumbledWord(String s) {
        String word = ""; //to store new word
        s += " "; //adds a space to the original word- pink( )
        List<String> letters = Arrays.asList(s.split("")); //adding all the letters of the word into a new array list
        List<String> part = new ArrayList<String>(); //a new array list to shuffle words
        for (String letter : letters) { //extracting each element from the array list
            if (letter.equals(" ")) { //checking each element, if it is a space
                Collections.shuffle(part); //shuffling the word if the element is a space
                for (String alph : part) { //extracting each alphabet from the part array list
                    word += alph; //converts the array list to string
                }
                part.clear(); //deletes all the elements of the array list
                word += letter; //adds a space
            } else {
                part.add(letter); //stores letter from letters into array list
            }
        }
        word = word.trim(); //remove extra space from end
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