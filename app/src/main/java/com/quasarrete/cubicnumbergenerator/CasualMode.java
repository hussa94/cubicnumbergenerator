package com.quasarrete.cubicnumbergenerator;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.ads.MobileAds;

public class CasualMode extends AppCompatActivity {
    TextView textView;
    TextView confirmationView;
    Button button1;
    Button button2;
    Button backBtn;
    EditText editText;
    int originalNumber;
    int number;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.casual_mode);
        textView = findViewById(R.id.resultViewer);
        textView.setText("Number Generated");
        button1 = findViewById(R.id.generateButton);
        button2 = findViewById(R.id.submitAnswer);
        editText = findViewById(R.id.numberField);
        confirmationView = findViewById(R.id.confirmationViewer);
        backBtn = findViewById(R.id.backButton);

        generateRandom();
        setTextView();
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTextView();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputText = editText.getText().toString();
                if (inputText.equals("")) {
                    showAlert();
                } else {
                    number = parseInt(inputText);
                    showResult(number);
                }

            }
        });
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backToMain();
            }
        });

        MobileAds.initialize(this, "ca-app-pub-4474129521686241~2057628767");
    }

    private Integer parseInt(String text) {
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private void showResult(int checkResult) {
        if (checkAnswer(checkResult)) {
            confirmationView.setText("Correct! Please guess the next cube root");
            setTextView();
        } else {
            confirmationView.setText("Incorrect! Please try again");
        }
    }

    public void setTextView() {

        String textToView = Integer.toString(makeCubic(generateRandom()));
        textView.setText(textToView);
    }


    private int generateRandom() {
        int random = (int) (Math.random() * 99 + 1);
        originalNumber = random;
        return random;
    }

    private int makeCubic(int number) {
        return number * number * number;
    }

    private boolean checkAnswer(int number) {

        if (originalNumber == number) {
            return true;
        } else {
            return false;
        }

    }

    private void backToMain() {
        Intent intent = new Intent(this, MainScreen.class);
        startActivity(intent);
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

        /**
         builder1.setNegativeButton(
                "Ok",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        **/
        AlertDialog alert11 = builder1.create();
        alert11.show();
    }
}
