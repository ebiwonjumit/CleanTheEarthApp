package com.software.cleantheearthapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

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

        String url = "http://softengineapi.us-east-2.elasticbeanstalk.com/api/users";

        final RequestQueue queue =  Volley.newRequestQueue(this);

        final JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        wrongLogin.setText(response.toString());
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle error

                        wrongLogin.setText("error");

                    }
                });

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
                queue.add(jsonObjectRequest);


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
