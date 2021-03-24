package com.example.myapplication22;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class RegisterActivity extends AppCompatActivity {

    EditText username, password, email, address, phone;
    RadioGroup gender;
    Button register, cancel;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_layout);

        databaseHelper = new DatabaseHelper(this);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        email = findViewById(R.id.email);
        address = findViewById(R.id.address);
        phone = findViewById(R.id.phone);
        gender = findViewById(R.id.gender);
        register = findViewById(R.id.register);
        cancel = findViewById(R.id.cancel);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getRegisterValues();
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void getRegisterValues() {
        String usernameValue = username.getText().toString();
        String passwordValue = password.getText().toString();
        String emailValue = email.getText().toString();
        String addressValue = address.getText().toString();
        String phoneValue = phone.getText().toString();
        RadioButton checkedBtn = findViewById(gender.getCheckedRadioButtonId());
        String genderValue = checkedBtn.getText().toString();

        ContentValues contentValues = new ContentValues();
        contentValues.put("username", usernameValue);
        contentValues.put("password", passwordValue);
        contentValues.put("email", emailValue);
        contentValues.put("address", addressValue);
        contentValues.put("phone", phoneValue);
        contentValues.put("gender", genderValue);
        databaseHelper.insertUser(contentValues);
    }
}
