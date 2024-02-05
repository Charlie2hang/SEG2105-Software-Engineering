package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btn_0, btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9, btn_point, btn_add, btn_sub, btn_mul, btn_div, btn_c, btn_equal;
    private TextView result;
    private boolean isClickEqual = false;
    private String str1, str2 = "";
    private double num1, num2 = 0.0;
    private String op = "";

    private double answer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = findViewById(R.id.result);
        btn_0 = findViewById(R.id.btn_0);
        btn_1 = findViewById(R.id.btn_1);
        btn_2 = findViewById(R.id.btn_2);
        btn_3 = findViewById(R.id.btn_3);
        btn_4 = findViewById(R.id.btn_4);
        btn_5 = findViewById(R.id.btn_5);
        btn_6 = findViewById(R.id.btn_6);
        btn_7 = findViewById(R.id.btn_7);
        btn_8 = findViewById(R.id.btn_8);
        btn_9 = findViewById(R.id.btn_9);
        btn_point = findViewById(R.id.btn_point);
        btn_add = findViewById(R.id.btn_sum);
        btn_sub = findViewById(R.id.btn_sub);
        btn_mul = findViewById(R.id.btn_mul);
        btn_div = findViewById(R.id.btn_div);
        btn_c = findViewById(R.id.btn_c);
        btn_equal = findViewById(R.id.btn_equal);

        btn_0.setOnClickListener(this);
        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);
        btn_4.setOnClickListener(this);
        btn_5.setOnClickListener(this);
        btn_6.setOnClickListener(this);
        btn_7.setOnClickListener(this);
        btn_8.setOnClickListener(this);
        btn_9.setOnClickListener(this);
        btn_point.setOnClickListener(this);
        btn_add.setOnClickListener(this);
        btn_sub.setOnClickListener(this);
        btn_mul.setOnClickListener(this);
        btn_div.setOnClickListener(this);
        btn_c.setOnClickListener(this);
        btn_equal.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_0) {
            if (isClickEqual) {
                result.setText("");
                isClickEqual = false;
            }
            if (result.getText().toString().equals("0")) {
                result.setText("0");
            } else{
                result.setText(result.getText().toString() + "0");
            }
        } else if (id == R.id.btn_1) {
            if (isClickEqual) {
                result.setText("");
                isClickEqual = false;
            }
            if (result.getText().toString().equals("0")) {
                result.setText("1");
            } else{
                result.setText(result.getText().toString() + "1");
            }
        } else if (id == R.id.btn_2) {
            if (isClickEqual) {
                result.setText("");
                isClickEqual = false;
            }
            if (result.getText().toString().equals("0")) {
                result.setText("2");
            } else{
                result.setText(result.getText().toString() + "2");
            }
        } else if (id == R.id.btn_3) {
            if (isClickEqual) {
                result.setText("");
                isClickEqual = false;
            }
            if (result.getText().toString().equals("0")) {
                result.setText("3");
            } else{
                result.setText(result.getText().toString() + "3");
            }
        } else if (id == R.id.btn_4) {
            if (isClickEqual) {
                result.setText("");
                isClickEqual = false;
            }
            if (result.getText().toString().equals("0")) {
                result.setText("4");
            } else{
                result.setText(result.getText().toString() + "4");
            }
        } else if (id == R.id.btn_5) {
            if (isClickEqual) {
                result.setText("");
                isClickEqual = false;
            }
            if (result.getText().toString().equals("0")) {
                result.setText("5");
            } else{
                result.setText(result.getText().toString() + "5");
            }
        } else if (id == R.id.btn_6) {
            if (isClickEqual) {
                result.setText("");
                isClickEqual = false;
            }
            if (result.getText().toString().equals("0")) {
                result.setText("6");
            } else{
                result.setText(result.getText().toString() + "6");
            }
        } else if (id == R.id.btn_7) {
            if (isClickEqual) {
                result.setText("");
                isClickEqual = false;
            }
            if (result.getText().toString().equals("0")) {
                result.setText("7");
            } else{
                result.setText(result.getText().toString() + "7");
            }
        } else if (id == R.id.btn_8) {
            if (isClickEqual) {
                result.setText("");
                isClickEqual = false;
            }
            if (result.getText().toString().equals("0")) {
                result.setText("8");
            } else{
                result.setText(result.getText().toString() + "8");
            }
        } else if (id == R.id.btn_9) {
            if (isClickEqual) {
                result.setText("");
                isClickEqual = false;
            }
            if (result.getText().toString().equals("0")) {
                result.setText("9");
            } else{
                result.setText(result.getText().toString() + "9");
            }
        } else if (id == R.id.btn_c) {
            if (isClickEqual) {
                result.setText("");
                isClickEqual = false;
            }
            result.setText("");
        } else if (id == R.id.btn_sum) {
            str1 = result.getText().toString();
            if (str1.equals("")) {
                return;
            }
            num1 = Double.parseDouble(str1);
            result.setText("");
            op = "+";
            isClickEqual = false;
        } else if (id == R.id.btn_sub) {
            str1 = result.getText().toString();
            if (str1.equals("")) {
                return;
            }
            num1 = Double.parseDouble(str1);
            result.setText("");
            op = "-";
            isClickEqual = false;
        } else if (id == R.id.btn_point) {
            if (isClickEqual) {
                result.setText("");
                isClickEqual = false;
            }
            if (result.getText().toString().contains(".")) {

            } else {
                result.setText(result.getText().toString() + ".");
            }
        } else if (id == R.id.btn_mul) {
            str1 = result.getText().toString();
            if (str1.equals("")) {
                return;
            }
            num1 = Double.parseDouble(str1);
            result.setText("");
            op = "*";
            isClickEqual = false;
        } else if (id == R.id.btn_div) {
            str1 = result.getText().toString();
            if (str1.equals("")) {
                return;
            }

            num1 = Double.parseDouble(str1);
            result.setText("");
            op = "/";
            isClickEqual = false;
        } else if (id == R.id.btn_equal) {
            str2 = result.getText().toString();
            if (str2.equals("")) {
                return;
            }
            num2 = Double.parseDouble(str2);
            result.setText("");
            switch (op) {
                case "+":
                    answer = num1 + num2;
                    break;
                case "-":
                    answer = num1 - num2;
                    break;
                case "*":
                    answer = num1 * num2;
                    break;
                case "/":
                    answer = num1 / num2;
                    break;
                default:
                    answer = 0.0;
                    break;
            }
            result.setText(answer + "");
            op = "";
            isClickEqual = true;
        }



    }
}