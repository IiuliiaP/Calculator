package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class CalculatorActivity extends AppCompatActivity {
    private TextView resultText;
    Double buffer;
    char operator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        buffer = null;
        setContentView(R.layout.activity_main);
        resultText = findViewById(R.id.result);
        Button equal = findViewById(R.id.equals);
        // операции

        equal.setOnClickListener(view -> {
            switch (operator){
                case'+':
                    buffer+=Double.parseDouble(resultText.getText().toString());
                    resultText.setText(String.valueOf(buffer));
                    break;
                case'-':
                    buffer-=Double.parseDouble(resultText.getText().toString());
                    resultText.setText(String.valueOf(buffer));
                    break;
                case'*':
                    buffer*=Double.parseDouble(resultText.getText().toString());
                    resultText.setText(String.valueOf(buffer));
                    break;
                case'/':
                    buffer/=Double.parseDouble(resultText.getText().toString());
                    resultText.setText(String.valueOf(buffer));
                    break;
            }
        });
    }
    //обработка знаковых кнопок из xml
    public void operators(View view){
        buffer = Double.parseDouble(resultText.getText().toString());
        Button b = (Button) view;
        operator = b.getText().charAt(0);
        resultText.setText("");
    }
    //обработка цифровых кнопок из xml
    public void appendText(View view){
        Button b = (Button) view;
        resultText.setText(resultText.getText().toString() + b.getText().toString());
    }
    // сохранение экрана при повороте
    protected void onSaveInstanceState(Bundle outState) {
        outState.putDouble("NUM", buffer);
        super.onSaveInstanceState(outState);
    }
    // получение ранее сохраненного экрана
    protected void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        buffer = savedInstanceState.getDouble("NUM");
        resultText.setText(buffer.toString());
    }
}