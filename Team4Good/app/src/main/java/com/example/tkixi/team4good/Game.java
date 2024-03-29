
package com.example.tkixi.team4good;

/**
 * Created by Riley on 10/20/2017.
 */
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collections;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Game extends AppCompatActivity implements GestureDetector.OnGestureListener{

    Button button2, button3, button4, button5, home;
    TextView textView4, textView6, score, myNum1;
    private GestureDetectorCompat GD;

    Player p1 = new Player(1);
    Random rand = new Random();

    String[] questions = {"Approximately how many sharks will be killed this year?",
            "Which of the following is true about shark tagging?",
            "How much plastic goes into the ocean each year?",
            "Which of these sea animals is endangered?",
            "Which of the following is an adverse effect of destructive fishing practices?",
            "What are baby sharks called?",
            "What do you call a group of fish?"};
    String[][] answers = {{"73,000,000", "7,000,000", "730,000", "73,000"},
            {"Collects information on sharks' movement","Cause harm to sharks", "None of the answer choices", "Infects waters"},
            {"5+ Million Tons", "3 Million Tons", "None", "Under 1 Million Tons"},
            {"They all are", "Porpoise", "Sea Otter", "Hawksbill Turtle"},
            {"Collects information on sharks' movement","Causes harm to sharks", "None of the answer choices", "Infects waters"},
            {"Over 5 Million Tons", "3 Million Tons", "None", "Under 1 Million Tons"},
            {"They all are, Porpoise, Sea Otter, Hawksbill Turtle"},
            {"Deterioration of the Coral Reef", "More fish", "Cleaner Oceans", "Sustainable sea life populations"},
            {"Pups","Gups","Fry","None of these"},
            {"School","Cluster","Group","Team"}};
    String answer;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        home = (Button) findViewById(R.id.home);
        textView4 = (TextView) findViewById(R.id.textView4);
        textView6 = (TextView) findViewById(R.id.textView6);
        score = (TextView) findViewById(R.id.score1);
        myNum1 = (TextView) findViewById(R.id.myNum1);
        myNum1.setText(""+p1.plNum);

        createButton();


        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Game.this, MainActivity.class));
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (button2.getText().toString().equals(answer)) {
                    p1.score++;
                    createButton();
                }
                else {
                    p1.lives--;
                    createButton();
                }
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (button3.getText().toString().equals(answer)){
                    p1.score++;
                    createButton();
                }
                else {
                    p1.lives--;
                    createButton();
                }
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (button4.getText().toString().equals(answer)){
                    p1.score++;
                    createButton();
                }
                else {
                    p1.lives--;
                    createButton();
                }
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (button5.getText().toString().equals(answer)){
                    p1.score++;
                    createButton();
                }
                else {
                    p1.lives--;
                    createButton();
                }
            }
        });

    }

    private void createButton(){
        if(p1.lives > 0){
            int theNum = rand.nextInt(questions.length);
            answer = answers[theNum][0];
            int[] choices = {0,1,2,3};
            for (int i=0; i<choices.length; i++) {
                int randomPosition = rand.nextInt(choices.length);
                int temp = choices[i];
                choices[i] = choices[randomPosition];
                choices[randomPosition] = temp;
            }
            button2.setText(answers[theNum][choices[0]]);
            button3.setText(answers[theNum][choices[1]]);
            button4.setText(answers[theNum][choices[2]]);
            button5.setText(answers[theNum][choices[3]]);
            textView4.setText(questions[theNum]);
            textView6.setText("" + p1.lives);
            score.setText(""+p1.score);

        }
        else{ //lives = 0
            textView6.setText("0");
            Toast.makeText(Game.this,"Game Over | Score is: "+ Integer.toString(p1.score),Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.GD.onTouchEvent(event);
        return super.onTouchEvent(event);
    }


//    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        return false;
    }


    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        return false;
    }




}
