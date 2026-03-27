package com.example.calculator;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity {

    private TextView tvDisplay;
    private String expression = "";

    private static final int MAX_LENGTH = 16;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDisplay = findViewById(R.id.tvDisplay);

        int[] numberIds = {
                R.id.btn0,R.id.btn1,R.id.btn2,R.id.btn3,R.id.btn4,
                R.id.btn5,R.id.btn6,R.id.btn7,R.id.btn8,R.id.btn9
        };

        String[] numbers = {"0","1","2","3","4","5","6","7","8","9"};

        for(int i=0;i<numberIds.length;i++){

            String num = numbers[i];

            findViewById(numberIds[i]).setOnClickListener(v -> append(num));
        }

        findViewById(R.id.btnDot).setOnClickListener(v -> appendDot());

        findViewById(R.id.btnAdd).setOnClickListener(v -> append("+"));
        findViewById(R.id.btnSubtract).setOnClickListener(v -> append("-"));
        findViewById(R.id.btnMultiply).setOnClickListener(v -> append("*"));
        findViewById(R.id.btnDivide).setOnClickListener(v -> append("/"));

        findViewById(R.id.btnClear).setOnClickListener(v -> clear());

        findViewById(R.id.btnEquals).setOnClickListener(v -> calculate());
    }

    private void append(String value){

        if(expression.length() >= MAX_LENGTH){
            return;
        }

        if(tvDisplay.getText().toString().equals("0")){
            expression = "";
        }

        expression += value;

        tvDisplay.setText(expression);
    }

    // DOT FIX (only one decimal per number)
    private void appendDot(){

        if(expression.length() >= MAX_LENGTH){
            return;
        }

        String lastNumber = getLastNumber();

        if(lastNumber.contains(".")){
            return;
        }

        if(expression.isEmpty() || isOperator(expression.charAt(expression.length()-1))){
            expression += "0.";
        } else {
            expression += ".";
        }

        tvDisplay.setText(expression);
    }

    private String getLastNumber(){

        int index = expression.length() - 1;

        while(index >= 0 && !isOperator(expression.charAt(index))){
            index--;
        }

        return expression.substring(index + 1);
    }

    private boolean isOperator(char c){
        return c=='+' || c=='-' || c=='*' || c=='/';
    }

    private void clear(){

        expression = "";

        tvDisplay.setText("0");
    }

    private void calculate(){

        if(expression.isEmpty())
            return;

        try{

            Expression exp = new ExpressionBuilder(expression).build();

            double result = exp.evaluate();

            if(Double.isInfinite(result) || Double.isNaN(result)){

                tvDisplay.setText("Error");
                expression = "";
                return;
            }

            if(result == (long) result)
                expression = String.valueOf((long) result);
            else
                expression = String.valueOf(result);

            if(expression.length() > MAX_LENGTH){
                expression = expression.substring(0, MAX_LENGTH);
            }

            tvDisplay.setText(expression);

        }
        catch(Exception e){

            tvDisplay.setText("Error");
            expression = "";
        }
    }
}