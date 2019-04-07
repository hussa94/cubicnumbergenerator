package com.quasarrete.cubicnumbergenerator;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.ads.MobileAds;

public class ChallengeMode extends AppCompatActivity {
    private Button backBtn;
    private TextView scoreV;
    private TextView messageV;
    private TextView cubeV;
    private EditText input;
    private Button submit;
    private int originalNumber;
    private int cubeNumber;
    private int incorrectAnswer;
    private int correctAnswer;
    private int answerdNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge_mode);
        MobileAds.initialize(this, "ca-app-pub-4474129521686241~2057628767");
        initializer();

        generateRandom();
        displayNumber();

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backToMain();
            }
        });

    }

    private void backToMain() {
        Intent intent = new Intent(this, MainScreen.class);
        startActivity(intent);
    }

    private void initializer() {
        backBtn = findViewById(R.id.backButtonChallenge);
        scoreV = findViewById(R.id.scoreView);
        messageV = findViewById(R.id.messageView);
        cubeV = findViewById(R.id.cubicView);
        input = findViewById(R.id.inputValue);
        submit = findViewById(R.id.submitButton);

        displayScore();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputText = input.getText().toString();
                if (inputText.equals("")) {
                    showAlert();
                } else {
                    try {
                        answerdNumber = Integer.parseInt(inputText);
                    } catch (NumberFormatException e) {
                        System.out.println(e);
                    }
                    checkResult();
                }
            }
        });
    }

    private void setMessageV(String msg) {
        messageV.setText(msg);
    }

    private void generateRandom() {
        int random = (int) (Math.random() * 99 + 1);
        originalNumber = random;
        cubeNumber = originalNumber * originalNumber * originalNumber;
    }

    private void displayNumber() {
        cubeV.setText(Integer.toString(cubeNumber));
    }

    private void displayScore() {
        int total = incorrectAnswer + correctAnswer;
        if (total == 0) {
            scoreV.setText("Please start answering");
        } else {
            scoreV.setText("Score: " + correctAnswer + "/" + total);
        }
    }

    private void showAlert() {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setMessage("You have not entered a value, Please make a guess");
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                "Okay",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert11 = builder1.create();
        alert11.show();
    }

    private void checkResult(){
        if(answerdNumber==originalNumber){
            correctAnswer++;
        }else{
            incorrectAnswer++;
        }
        displayScore();
        generateRandom();
        displayNumber();
    }
}
