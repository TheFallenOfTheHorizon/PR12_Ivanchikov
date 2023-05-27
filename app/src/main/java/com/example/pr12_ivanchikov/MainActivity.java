package com.example.pr12_ivanchikov;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
 TextView textarea;
 Boolean isNew = true;
 String oldNum;
 String operator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textarea = findViewById(R.id.textarea);
    }

    public void clickButton(View view) {
        if (isNew){
            textarea.setText("");
        }
        isNew=false;
        String number = textarea.getText().toString();
        switch (view.getId()) {
            case R.id.b0: number +="0"; break;
            case R.id.b1: number +="1"; break;
            case R.id.b2: number +="2"; break;
            case R.id.b3: number +="3"; break;
            case R.id.b4: number +="4"; break;
            case R.id.b5: number +="5"; break;
            case R.id.b6: number +="6"; break;
            case R.id.b7: number +="7"; break;
            case R.id.b8: number +="8"; break;
            case R.id.b9: number +="9"; break;
            case R.id.bSimb: number +="."; break;
            case R.id.minus: number ="-"+number; break;
        }
        textarea.setText(number);
    }

    public void operation(View view) {
        isNew=false;
        oldNum=textarea.getText().toString();
        switch (view.getId()) {
            case R.id.minus: operator="-"; break;
            case R.id.Plus: operator="+"; break;
            case R.id.multiply: operator="*"; break;
            case R.id.sep:operator="/" ; break;
        }
    }

    public void result(View view) {
        String newNumber = textarea.getText().toString();
        Double result = 0.0;
        switch (operator) {
            case "-": result= Double.parseDouble(oldNum)-Double.parseDouble(newNumber); break;
            case "+": result= Double.parseDouble(oldNum)+Double.parseDouble(newNumber); break;
            case "/": result= Double.parseDouble(oldNum)/Double.parseDouble(newNumber); break;
            case "*": result= Double.parseDouble(oldNum)*Double.parseDouble(newNumber); break;
        }
        textarea.setText(result.toString());
    }
}