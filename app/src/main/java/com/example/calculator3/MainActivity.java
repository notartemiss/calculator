package com.example.calculator3;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView txtInput, txtOutput;
    Button btnClearAll, btnDel, btnDivide, btnMultiply, btnSubtraction, btnAdd, btnCalculate;
    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    String userInput = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initViews();
        setUpListeners();

    }

    private void initViews() {

        txtInput = findViewById(R.id.txtNumbersForCalculation);
        txtOutput = findViewById(R.id.txtAnswer);

        btn0 = findViewById(R.id.btnZero);
        btn1 = findViewById(R.id.btnOne);
        btn2 = findViewById(R.id.btnTwo);
        btn3 = findViewById(R.id.btnThree);
        btn4 = findViewById(R.id.btnFour);
        btn5 = findViewById(R.id.btnFive);
        btn6 = findViewById(R.id.btnSix);
        btn7 = findViewById(R.id.btnSeven);
        btn8 = findViewById(R.id.btnEight);
        btn9 = findViewById(R.id.btnNine);


        btnClearAll = findViewById(R.id.btnClearAll);
        btnDel = findViewById(R.id.btnDel);
        btnAdd = findViewById(R.id.btnAdd);
        btnSubtraction = findViewById(R.id.btnSubtraction);
        btnDivide = findViewById(R.id.btnDivide);
        btnMultiply = findViewById(R.id.btnMultiply);
        btnCalculate = findViewById(R.id.btnCalculate);

    }

    private void setUpListeners() {

        btnClearAll.setOnClickListener(new OnClickAction());
        btnDel.setOnClickListener(new OnClickAction());
        btnCalculate.setOnClickListener(new OnClickAction());

        btn0.setOnClickListener(new OnClickAction());
        btn1.setOnClickListener(new OnClickAction());
        btn2.setOnClickListener(new OnClickAction());
        btn3.setOnClickListener(new OnClickAction());
        btn4.setOnClickListener(new OnClickAction());
        btn5.setOnClickListener(new OnClickAction());
        btn6.setOnClickListener(new OnClickAction());
        btn7.setOnClickListener(new OnClickAction());
        btn8.setOnClickListener(new OnClickAction());
        btn9.setOnClickListener(new OnClickAction());


        btnAdd.setOnClickListener(new OnClickAction());
        btnSubtraction.setOnClickListener(new OnClickAction());
        btnDivide.setOnClickListener(new OnClickAction());
        btnMultiply.setOnClickListener(new OnClickAction());


    }

    class OnClickAction implements View.OnClickListener {
        @Override
        public void onClick(View view) {

            // checking which button is clicked and performing the actions

            switch (view.getId()) {

                case R.id.btnClearAll:
                    if (userInput.equals("")) return;
                    userInput = "";
                    txtOutput.setText("");

                    break;

                case R.id.btnDel:
                    if (userInput.equals("")) return;
                    userInput = userInput.substring(0, userInput.length() - 1);
                    break;

                case R.id.btnCalculate:
                    if (userInput.equals("")) return;
                    //do Calculation
                    if (!checkInput()) {
                        return;
                    }
                    Calculations();
                    break;

                case R.id.btnDivide:
                    if (userInput.equals("")) return;
                    if (!txtOutput.getText().toString().equals("")) {
                        userInput = txtOutput.getText().toString();
                        txtOutput.setText("");
                    }
                    userInput = userInput + "/";
                    break;

                case R.id.btnMultiply:
                    if (userInput.equals("")) return;
                    if (!txtOutput.getText().toString().equals("")) {
                        userInput = txtOutput.getText().toString();
                        txtOutput.setText("");
                    }
                    userInput = userInput + "*";
                    break;

                case R.id.btnSubtraction:
                    if (userInput.equals("")) return;
                    if (!txtOutput.getText().toString().equals("")) {
                        userInput = txtOutput.getText().toString();
                        txtOutput.setText("");
                    }
                    userInput = userInput + "-";
                    break;

                case R.id.btnAdd:
                    if (userInput.equals("")) return;
                    if (!txtOutput.getText().toString().equals("")) {
                        userInput = txtOutput.getText().toString();
                        txtOutput.setText("");
                    }

                    userInput = userInput + "+";
                    break;

                case R.id.btnZero:
                    if (!userInput.equals("")) {
                        userInput = userInput + "0";
                    }
                    break;

                case R.id.btnOne:
                    userInput = userInput + "1";
                    break;

                case R.id.btnTwo:
                    userInput = userInput + "2";
                    break;

                case R.id.btnThree:
                    userInput = userInput + "3";
                    break;

                case R.id.btnFour:
                    userInput = userInput + "4";
                    break;

                case R.id.btnFive:
                    userInput = userInput + "5";
                    break;

                case R.id.btnSix:
                    userInput = userInput + "6";
                    break;

                case R.id.btnSeven:
                    userInput = userInput + "7";
                    break;

                case R.id.btnEight:
                    userInput = userInput + "8";
                    break;

                case R.id.btnNine:
                    userInput = userInput + "9";
                    break;

                default:
                    Toast.makeText(MainActivity.this, "Something went wrong!", Toast.LENGTH_SHORT).show();
            }

            txtInput.setText(userInput);
        }


        private void Calculations() {

            int num1 = 0;
            int num2 = 0;
            char sign = 0;

            for (int i = 0; i < userInput.length(); i++) {

                if (userInput.charAt(i) == '*' || userInput.charAt(i) == '/' || userInput.charAt(i)
                        == '+' || userInput.charAt(i) == '-' || userInput.charAt(i) == '%') {


                    if (i == userInput.length() - 1) {
                        txtOutput.setText("Invalid");
                        return;
                    }

                    num1 = Integer.parseInt(userInput.substring(0, i));
                    num2 = Integer.parseInt(userInput.substring(i + 1));
                    sign = userInput.charAt(i);
                    switch (sign) {
                        case '+':
                            txtOutput.setText(String.valueOf(num1 + num2));
                            break;

                        case '-':
                            txtOutput.setText(String.valueOf(num1 - num2));
                            break;

                        case '*':
                            txtOutput.setText(String.valueOf(num1 * num2));
                            break;

                        case '/':
                            if (num1 == 0 || num2 == 0) {
                                txtOutput.setText(String.valueOf(0));
                                return;
                            }
                            txtOutput.setText(String.valueOf(num1 / num2));
                            break;


                    }
                }
            }
        }

        private boolean checkInput() {
            int count = 0;
            for (int i = 0; i < userInput.length(); i++) {
                if (userInput.charAt(i) == '*' || userInput.charAt(i) == '/' || userInput.charAt(i) == '+' || userInput.charAt(i) == '-' || userInput.charAt(i) == '%') {
                    count++;
                }
            }
            if (count > 1) {
                Toast.makeText(MainActivity.this, "Please enter valid input", Toast.LENGTH_SHORT).show();
                txtOutput.setText("Invalid!!");
                return false;
            }
            return true;
        }

    }
}