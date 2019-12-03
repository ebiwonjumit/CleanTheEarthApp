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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LoginPageActivity extends AppCompatActivity {

    public String username;
    public String password;
    public String userFromJ;
    public String passFromJ;
    EditText userField;
    EditText passwordField;
    Button loginButton;
    boolean correctUser;
    boolean correctPassword;
    TextView wrongLogin;
    private RequestQueue queue;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);


        queue = Volley.newRequestQueue(this);

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
                jsonParse();
//                correctPassword = checkPassword(password,passFromJ);
//                correctUser = checkUser(username,userFromJ);

                if (!correctUser || !correctPassword) {
                    wrongLogin.setVisibility(View.VISIBLE);
                } else {
                    //right password
                }

            }

        });

    }

    private void jsonParse() {
        String url = "https://api.myjson.com/bins/bxdlg";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jArray = response.getJSONArray("users");
                            JSONObject jsonObject = jArray.getJSONObject(0);
                            userFromJ = jsonObject.getString("username");
                            passFromJ = jsonObject.getString("password");


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();

            }
         });
        queue.add(request);


    }

    private Boolean checkUser(String userFromPhone, String userFromJson){
        return userFromPhone.matches(userFromJson);
    }

    private Boolean checkPassword(String passFromPhone, String passFromJson){
        return passFromPhone.matches(passFromJson);
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }


}
