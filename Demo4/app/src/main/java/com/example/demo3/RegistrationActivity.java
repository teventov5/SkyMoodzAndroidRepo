package com.example.demo3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class RegistrationActivity extends AppCompatActivity {
    EditText tempText,tempPwd;
    Button btnSignIn;
    String usernameText,passwordText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration_window);
        btnSignIn = (Button)findViewById(R.id.btnLogin);
        tempText = (EditText)findViewById(R.id.etUsername);
        tempPwd = (EditText)findViewById(R.id.etPassword);


    }
}