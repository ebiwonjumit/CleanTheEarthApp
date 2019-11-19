package com.software.cleantheearthapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginPageActivity extends AppCompatActivity {

    public String username;
    public String password;
    EditText userField;
    EditText passwordField;
    Button loginButton;
    boolean correctUser;
    boolean correctPassword;
    TextView wrongLogin;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);

        userField = findViewById(R.id.login_userField);
        wrongLogin = findViewById(R.id.wrong_login);
        passwordField = findViewById(R.id.login_passwrodField);
        loginButton = findViewById(R.id.login_button);
        correctPassword = false;
        correctUser = false;
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                password = passwordField.getText().toString();
                username = userField.getText().toString();
                loginButton.setBackgroundColor(Color.parseColor("#FA3910"));

               if(!correctUser || !correctPassword){
                   wrongLogin.setVisibility(View.VISIBLE);
                }else {
                    //right password
               }

            }

        });


    }


    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }


}
