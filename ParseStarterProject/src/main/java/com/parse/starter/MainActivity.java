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

import com.parse.GetCallback;
import com.parse.ParseAnalytics;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.SaveCallback;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Store the data on the parse server
//        ParseObject tweet = new ParseObject("Tweet");
//        tweet.put("username", "mithu");
//        tweet.put("tweet", "My first tweet");
//        tweet.saveInBackground(new SaveCallback() {
//            @Override
//            public void done(ParseException e) {
//                if (e == null){
//                    //Success
//                    Log.i("Username", "Save the tweet");
//                } else {
//                    //Fail to parse
//                    e.printStackTrace();
//                }
//            }
//        });

//        //Select the parse object and intialize it in query
        ParseQuery<ParseObject> query = ParseQuery.getQuery("Tweet");

        query.getInBackground("njyHI3auMB", new GetCallback<ParseObject>() {
            @Override
            public void done(ParseObject object, ParseException e) {
                if (e == null && object != null) {

//                    //Update the data here
//                    object.put("score", 80);
//                    object.saveInBackground();

                    Log.i("username", object.getString("username"));
                    Log.i("tweet", object.getString("tweet"));
                    //Log.i("score", Integer.toString(object.getInt("score")));
                }
            }
        });

        ParseAnalytics.trackAppOpenedInBackground(getIntent());
    }

}