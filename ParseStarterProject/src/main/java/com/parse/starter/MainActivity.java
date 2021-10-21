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


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        //Create a user on the parse server
//        ParseUser user = new ParseUser();
//        //Set the username and password
//        user.setUsername("mithu");
//        user.setPassword("password");
//        //SignUp the user
//        user.signUpInBackground(new SignUpCallback() {
//            @Override
//            public void done(ParseException e) {
//                if (e == null) {
//                    //All is well
//                    Log.i("SignUp", "All is going well");
//                } else {
//                    e.printStackTrace();
//                }
//            }
//        });


       // Log in the user on the parse server
//        ParseUser.logInInBackground("mithu", "password", new LogInCallback() {
//            @Override
//            public void done(ParseUser user, ParseException e) {
//                if (e == null && user != null) {
//                    Log.i("LogIn", "User Logged in Successfully");
//                } else {
//                    e.printStackTrace();
//                }
//            }
//        });

        //Log out the user from the parse server
        ParseUser.logOut();

        //If the user is logged in than no need to logged in again
        if (ParseUser.getCurrentUser() != null) {
            Log.i("UserActive", ParseUser.getCurrentUser().getUsername());
        } else {
            Log.i("InActive", "OOps the user not logged in");
        }

        ParseAnalytics.trackAppOpenedInBackground(getIntent());
    }

}