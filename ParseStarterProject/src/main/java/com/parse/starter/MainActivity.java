/*
 * Copyright (c) 2015-present, Parse, LLC.
 * All rights reserved.
 *
 * This source code is licensed under the BSD-style license found in the
 * LICENSE file in the root directory of this source tree. An additional grant
 * of patent rights can be found in the PATENTS file in the same directory.
 */
package com.parse.starter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.LogInCallback;
import com.parse.ParseAnalytics;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;
import com.parse.SignUpCallback;

import java.util.List;


public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnKeyListener{

    Boolean signUpModeActive = true;
    TextView loginTV;
    EditText usernameET;
    EditText passwordET;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginTV = findViewById(R.id.logInTV);
        loginTV.setOnClickListener(this);

        usernameET = findViewById(R.id.usernameET);
        passwordET = findViewById(R.id.passwordET);

        //set the onKey listener for password field


        ParseAnalytics.trackAppOpenedInBackground(getIntent());
    }

    public void signUpClicked(View view) {


        if (usernameET.getText().toString().matches("") || passwordET.getText().toString().matches("")) {
            Toast.makeText(this, "Username and Password Required!", Toast.LENGTH_SHORT).show();
        } else {
            if (signUpModeActive) {
                //SignUp
                ParseUser user = new ParseUser();
                user.setUsername(usernameET.getText().toString());
                user.setPassword(passwordET.getText().toString());

                user.signUpInBackground(new SignUpCallback() {
                    @Override
                    public void done(ParseException e) {
                        if (e == null) {
                            Log.i("SignUp", "Success");
                            Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            } else {
                //Login
                ParseUser.logInInBackground(usernameET.getText().toString(), passwordET.getText().toString(), new LogInCallback() {
                    @Override
                    public void done(ParseUser user, ParseException e) {
                        if (user != null && e == null) {
                            Log.i("Login", "Successfully login");
                        } else {
                            Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.logInTV) {

            Button signUpBtn = findViewById(R.id.primaryButton);

            if (signUpModeActive) {
                signUpModeActive = false;
                signUpBtn.setText("Login");
                loginTV.setText("or, Sign Up");
            } else {
                signUpModeActive = true;
                signUpBtn.setText("Sign Up");
                loginTV.setText("or, Login");
            }

        }
    }

    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        return false;
    }
}