package com.ahlamdev.espressotestingsamplesjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edtN1 = findViewById(R.id.edt_num1);
        EditText edtN2 = findViewById(R.id.edt_num2);
        Button btnEquals = findViewById(R.id.btn_equals);
        TextView txtResult = findViewById(R.id.txt_result);


        btnEquals.setOnClickListener(v -> {

            try{
                txtResult.setText(MathsUtils.add(edtN1.getText(), edtN2.getText()));

            } catch (NumberFormatException e){

                txtResult.setText("Error!");
                Toast.makeText(this, "Numeric value is required in both fields!", Toast.LENGTH_LONG).show();
                Log.e("Error", "Numeric value is required in both fields!");
            }

        });
    }
}