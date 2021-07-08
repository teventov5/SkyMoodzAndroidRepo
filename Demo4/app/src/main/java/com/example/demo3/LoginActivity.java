package com.example.demo3;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import java.sql.*;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.function.IntPredicate;
import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    EditText tempUname, tempPwd;
    Button btnSignIn, btnRegister, btnForgotPwd;
    String usernameText, pwdText;
    private boolean DBcheck = false,DBsignIn=false;
    public User tempUser;

    public final Pattern textPattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).+$");

    @RequiresApi(api = Build.VERSION_CODES.N)
    public boolean isPasswordValid(String value) {
        return containsNumber(value) &&
                (containsLowerCase(value) ||
                        containsUpperCase(value));

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private boolean containsLowerCase(String value) {
        return contains(value, i -> Character.isLetter(i) && Character.isLowerCase(i));
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private boolean containsUpperCase(String value) {
        return contains(value, i -> Character.isLetter(i) && Character.isUpperCase(i));
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private boolean containsNumber(String value) {
        return contains(value, Character::isDigit);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private boolean contains(String value, IntPredicate predicate) {
        return value.chars().anyMatch(predicate);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void passwordCheck(String tempPWd) {
        String tempPassword = tempPWd;
        if (tempPassword.length() > 8 || tempPassword.length() < 4) {
            throw new ArithmeticException("Password has to be between 4-8 chars ");
        }
        //checking if the password contains at least one digit and one letter
        if (!isPasswordValid(tempPassword))
            throw new ArithmeticException("Password has to include at least one digit and one letter ");
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private boolean validateUser(String tempUsername, String tempPwd) {
        if (tempUsername == null || tempPwd == null)//make sure password is not null
            return false;
        try {
            passwordCheck(tempPwd);//checks password for validity
        } catch (Exception e1) {
            Toast.makeText(this, e1.getMessage(), Toast.LENGTH_SHORT).show();//prints the password error if exists
            return false;
        }
        try {
           // DBcheck = DbAccess.checkUsername(tempUsername);
            //if (DBcheck) {
                tempUser = new User(tempUsername, tempPwd);
                try {
                    DBsignIn = DbAccess.loginUserToDB(tempUser);

                }
                catch (Exception e) {
                    Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();//prints the password error if exists
                }

            if (DBsignIn == true)
                    return true;

        }
        catch  (Exception e1)
        {
            e1.printStackTrace();
        }
        return false;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_window);
        btnSignIn = (Button)findViewById(R.id.btnLogin);
        btnRegister = (Button)findViewById(R.id.btnRegister);
        btnForgotPwd = (Button)findViewById(R.id.btnForgotPassword);
        tempUname = (EditText)findViewById(R.id.etUsername);
        tempPwd = (EditText)findViewById(R.id.etPassword);



        btnSignIn.setOnClickListener(this);
        btnRegister.setOnClickListener(this);
        btnForgotPwd.setOnClickListener(this);


    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnLogin:
                usernameText=tempUname.getText().toString();
                pwdText=tempPwd.getText().toString();
                if(validateUser(usernameText,pwdText))
                {

                    Intent intent = new Intent(this, MainActivity.class);
                    intent.putExtra("username", usernameText);
                    startActivity(intent);
                }

                else Toast.makeText(this, "Problem in the Sign in process", Toast.LENGTH_SHORT).show();

                break;
            case R.id.btnRegister:
                Toast.makeText(this, "Registration clicked", Toast.LENGTH_SHORT).show();
                setContentView(R.layout.registration_window);
                break;

        }

    }
}