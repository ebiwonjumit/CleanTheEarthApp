package com.software.cleantheearthapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginPageActivity extends AppCompatActivity {

    public String username;
    public String password;
    EditText userField;
    EditText passwordField;
    Button loginButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);

        userField = findViewById(R.id.login_userField);
        username = userField.getText().toString();
        passwordField = findViewById(R.id.login_passwrodField);
        password = passwordField.getText().toString();
        loginButton = findViewById(R.id.login_button);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO implement button clicking functionality

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
