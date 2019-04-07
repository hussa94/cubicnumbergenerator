package com.quasarrete.cubicnumbergenerator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Hint extends AppCompatActivity {
    private TextView r1c1, r1c2, r2c1, r2c2, r3c1, r3c2, r4c1, r4c2, r5c1, r5c2, r6c1,
             r6c2, r7c1, r7c2, r8c1, r8c2, r9c1, r9c2,r10c1, r10c2, r11c1, r11c2;
    private Button backToCreditPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hint);
        backToCreditPage = findViewById(R.id.backToCredit);
        initialiseTextViewer();
        setView();


        backToCreditPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returnToCredit();
            }
        });

    }





    private void initialiseTextViewer(){
        r1c1 = findViewById(R.id.r1c1);
        r1c2 = findViewById(R.id.r1c2);
        r2c1 = findViewById(R.id.r2c1);
        r2c2 = findViewById(R.id.r2c2);
        r3c1 = findViewById(R.id.r3c1);
        r3c2 = findViewById(R.id.r3c2);
        r4c1 = findViewById(R.id.r4c1);
        r4c2 = findViewById(R.id.r4c2);
        r5c1 = findViewById(R.id.r5c1);
        r5c2 = findViewById(R.id.r5c2);
        r6c1 = findViewById(R.id.r6c1);
        r6c2 = findViewById(R.id.r6c2);
        r7c1 = findViewById(R.id.r7c1);
        r7c2 = findViewById(R.id.r7c2);
        r8c1 = findViewById(R.id.r8c1);
        r8c2 = findViewById(R.id.r8c2);
        r9c1 = findViewById(R.id.r9c1);
        r9c2 = findViewById(R.id.r9c2);
        r10c1 = findViewById(R.id.r10c1);
        r10c2 = findViewById(R.id.r10c2);
        r11c1 = findViewById(R.id.r11c1);
        r11c2 = findViewById(R.id.r11c2);

    }

    private void setView(){
        r1c1.setText("Number");
        r1c2.setText("Cubed");
        r2c1.setText(Integer.toString(1));
        r2c2.setText(Integer.toString(1*1*1));
        r3c1.setText(Integer.toString(2));
        r3c2.setText(Integer.toString(2*2*2));
        r4c1.setText(Integer.toString(3));
        r4c2.setText(Integer.toString(3*3*3));
        r5c1.setText(Integer.toString(4));
        r5c2.setText(Integer.toString(4*4*4));
        r6c1.setText(Integer.toString(5));
        r6c2.setText(Integer.toString(5*5*5));
        r7c1.setText(Integer.toString(6));
        r7c2.setText(Integer.toString(6*6*6));
        r8c1.setText(Integer.toString(7));
        r8c2.setText(Integer.toString(7*7*7));
        r9c1.setText(Integer.toString(8));
        r9c2.setText(Integer.toString(8*8*8));
        r10c1.setText(Integer.toString(9));
        r10c2.setText(Integer.toString(9*9*9));
        r11c1.setText(Integer.toString(10));
        r11c2.setText(Integer.toString(10*10*10));
    }

    private void returnToCredit(){
        Intent secondIntent = new Intent(this, Credit.class);
        startActivity(secondIntent);
    }
}
