package com.example.demo3;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText tempText,tempPwd;
    Button btnSignIn;
    String usernameText,passwordText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSignIn = (Button)findViewById(R.id.btnLogin);
        tempText = (EditText)findViewById(R.id.etUsername);
        tempPwd = (EditText)findViewById(R.id.etPassword);
        String usernameImported= String.valueOf(getIntent().getExtras().getString("username"));
        String welcome="Welcome "+ usernameImported +".\n your username have been created";

        Toast.makeText(this, welcome, Toast.LENGTH_SHORT).show();

    }
}