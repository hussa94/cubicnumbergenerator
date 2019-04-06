package com.quasarrete.cubicnumbergenerator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.resultViewer);
        textView.setText("Number Generated");
        button1 = findViewById(R.id.generateButton);
        button2 = findViewById(R.id.submitAnswer);
        editText = findViewById(R.id.numberField);
        confirmationView = findViewById(R.id.confirmationViewer);
        backBtn = findViewById(R.id.backButton);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTextView();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number = Integer.parseInt(editText.getText().toString());
                showResult(number);
            }
        });
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backToMain();
            }
        });
    }

    private void showResult(int test) {
        if (checkAnswer(test)) {
            confirmationView.setText("Correct!");
            setTextView();
        } else {
            confirmationView.setText("Incorrect!");
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

    private void backToMain(){
        Intent intent = new Intent(this, MainScreen.class);
        startActivity(intent);
    }
}
