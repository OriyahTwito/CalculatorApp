package com.example.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

// View.OnClickListener - Implementation of the function "onClick"
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvExecute, tvResult; // Set TextView
    private EditText etNum1, etNum2; // Set EditText
    private Button btnDivide, btnMultiplication, btnPlus, btnMinus, btnEqual; // Set Button
    private int result; // Set int
    private String operation; // Set String

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // The design of MainActivity

        initUI();
        initListeners();
    }

    private void initUI() {
        // Id of TextView
        tvExecute = findViewById(R.id.tvExecute);
        tvResult = findViewById(R.id.tvResult);
        // Id of EditText
        etNum1 = findViewById(R.id.etNum1);
        etNum2 = findViewById(R.id.etNum2);
        // Id of Button
        btnDivide = findViewById(R.id.btnDivide);
        btnMultiplication = findViewById(R.id.btnMultiplication);
        btnPlus = findViewById(R.id.btnPlus);
        btnMinus = findViewById(R.id.btnMinus);
        btnEqual = findViewById(R.id.btnEqual);
    }

    private void initListeners() {
        // Give access to elements to be clicked
        btnDivide.setOnClickListener(this);
        btnMultiplication.setOnClickListener(this);
        btnPlus.setOnClickListener(this);
        btnMinus.setOnClickListener(this);
        btnEqual.setOnClickListener(this);
    }

    // Performs tasks after click on the elements
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            // Divide operation
            case R.id.btnDivide:
                tvExecute.setText("/");

                operation = "/";
                break;
            // Multiplication operation
            case R.id.btnMultiplication:
                tvExecute.setText("*");

                operation = "*";
                break;
            // Plus operation
            case R.id.btnPlus:
                tvExecute.setText("+");

                operation = "+";
                break;
            // Minus operation
            case R.id.btnMinus:
                tvExecute.setText("-");

                operation = "-";
                break;
            // Equal operation
            case R.id.btnEqual:
                if (!etNum1.getText().toString().isEmpty() &&
                        !etNum2.getText().toString().isEmpty() &&
                        operation != null) {
                    int num1 = Integer.parseInt(etNum1.getText().toString());
                    int num2 = Integer.parseInt(etNum2.getText().toString());

                    switch (operation) {
                        case "/":
                            result = num1 / num2;
                            break;
                        case "*":
                            result = num1 * num2;
                            break;
                        case "+":
                            result = num1 + num2;
                            break;
                        case "-":
                            result = num1 - num2;
                            break;
                    }

                    tvResult.setText(String.valueOf(result));
                } else {
                    Toast.makeText(this, "Error", Toast.LENGTH_LONG).show();
                }
                break;
        }
    }

}