package com.example.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextName, editTextId, editTextNumber;
    private CheckBox checkBoxOption1, checkBoxOption2, checkBoxOption3, checkBoxOption4;
    private RadioGroup radioGroupSquareOptions;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        editTextName = findViewById(R.id.editTextName);
        editTextId = findViewById(R.id.editTextId);
        editTextNumber = findViewById(R.id.editTextNumber);
        radioGroupSquareOptions = findViewById(R.id.radioGroupSquareOptions);
        checkBoxOption1 = findViewById(R.id.checkBoxOption);
        checkBoxOption2 = findViewById(R.id.checkBoxOption2);
        checkBoxOption3 = findViewById(R.id.checkBoxOption3);
        checkBoxOption4 = findViewById(R.id.checkBoxOption4);
    }

    public void onSubmitClicked(View view) {
        // Retrieve inputs
        String name = editTextName.getText().toString().trim();
        String id = editTextId.getText().toString().trim();
        String number = editTextNumber.getText().toString().trim();

        // Get selected options
        StringBuilder selectedOptions = new StringBuilder();
        if (checkBoxOption1.isChecked()) {
            selectedOptions.append(checkBoxOption1.getText()).append(", ");
        }
        if (checkBoxOption2.isChecked()) {
            selectedOptions.append(checkBoxOption2.getText()).append(", ");
        }
        if (checkBoxOption3.isChecked()) {
            selectedOptions.append(checkBoxOption3.getText()).append(", ");
        }
        if (checkBoxOption4.isChecked()) {
            selectedOptions.append(checkBoxOption4.getText()).append(", ");
        }

        // Get selected square option
        int selectedSquareOptionId = radioGroupSquareOptions.getCheckedRadioButtonId();
        RadioButton selectedSquareOptionRadioButton = findViewById(selectedSquareOptionId);
        String selectedSquareOption = selectedSquareOptionRadioButton.getText().toString();

        // Display inputs and selections
        String message = "Name: " + name + "\nID: " + id + "\nNumber: " + number +
                "\nSelected Options: " + selectedOptions.toString() + "\nSelected Square Option: " + selectedSquareOption;
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
