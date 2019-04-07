package com.quasarrete.cubicnumbergenerator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Credit extends AppCompatActivity {

    Button backBtn, hintBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);

        hintBtn = findViewById(R.id.hintButton);
        backBtn = findViewById(R.id.backButtonCredits);

        hintBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToHint();
            }
        });
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backToMain();
            }
        });
    }

    private void goToHint(){
        Intent intent = new Intent(this, Hint.class);
        startActivity(intent);
    }
    private void backToMain() {
        Intent intent = new Intent(this, MainScreen.class);
        startActivity(intent);
    }


}
