package com.example.chalange;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, View.OnClickListener {
    private Spinner countrySpinner;
    private EditText editName, editEmail, editPassword, editRePassword;
    private RadioGroup radioGroup;
    private RadioButton radioFemale, radioMale, radioOther;
    private ImageView image;
    private Button imageButton, registerButton;
    private CheckBox checkBox;


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if (radioFemale.isChecked()) {
            Toast.makeText(MainActivity.this, radioFemale.getText(), Toast.LENGTH_SHORT).show();
        } else if (radioMale.isChecked()) {
            Toast.makeText(MainActivity.this, radioMale.getText(), Toast.LENGTH_SHORT).show();
        } else if (radioOther.isChecked()) {
            Toast.makeText(MainActivity.this, radioOther.getText(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.imageButton) {
            Toast.makeText(this, "Picking Image", Toast.LENGTH_SHORT).show();
        } else if (v.getId() == R.id.registerButton) {
            if (editName.length() == 0) {
                Toast.makeText(this, "Please enter valid name", Toast.LENGTH_SHORT).show();
            } else if (editEmail.length() == 0) {
                Toast.makeText(this, "Please enter valid email", Toast.LENGTH_SHORT).show();
            } else if (editPassword.length() == 0 | editRePassword.length() == 0) {
                Toast.makeText(this, "Enter valid password", Toast.LENGTH_SHORT).show();
            } else if (!editPassword.getText().toString().equals(editRePassword.getText().toString())) {
                Toast.makeText(this, "Both passwords should match", Toast.LENGTH_SHORT).show();
            } else if (!checkBox.isChecked()) {
                Toast.makeText(this, "Please agree with our terms", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Registering", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = findViewById(R.id.radioGroup);
        radioFemale = findViewById(R.id.radioFemale);
        radioMale = findViewById(R.id.radioMale);
        radioOther = findViewById(R.id.radioOther);

        countrySpinner = findViewById(R.id.countrySpinner);

        image = findViewById(R.id.image);
        imageButton = findViewById(R.id.imageButton);

        registerButton = findViewById(R.id.registerButton);
        editName = findViewById(R.id.editName);
        editEmail = findViewById(R.id.editEmail);
        editPassword = findViewById(R.id.editPassword);
        editRePassword = findViewById(R.id.editRePassword);
        checkBox = findViewById(R.id.checkBox);

//        countrySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(MainActivity.this, countrySpinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });

        imageButton.setOnClickListener(this);

        registerButton.setOnClickListener(this);

        radioGroup.setOnCheckedChangeListener(this);
    }


}