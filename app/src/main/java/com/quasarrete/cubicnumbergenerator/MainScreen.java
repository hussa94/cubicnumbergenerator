package com.quasarrete.cubicnumbergenerator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainScreen extends AppCompatActivity {
    private Button casualButton;
    private Button challengeButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        casualButton = findViewById(R.id.casualButton);
        challengeButton = findViewById(R.id.challengeButton);

        casualButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCasual();
            }
        });

    }

    private void openCasual(){
        Intent intent = new Intent(this, CasualMode.class);
        startActivity(intent);
    }
}
