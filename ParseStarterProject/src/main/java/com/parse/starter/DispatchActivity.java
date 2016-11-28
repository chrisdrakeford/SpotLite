package com.parse.starter;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SaveCallback;

/**
 * Created by Chris on 26/11/2016.
 */

public class DispatchActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

//        ParseObject userData = new ParseObject("UserData");
//        userData.put("age",20);
//        userData.put("userName", "chris");
//        userData.put("password", "changeme");
//        userData.put("name", "chris d");
//        //userData.saveInBackground();
//
//        userData.saveInBackground(new SaveCallback() {
//            public void done(ParseException e) {
//                if (e == null) {
//                    Log.d("XXX1", "Send request!");
//                    Intent loginIntent = new Intent(DispatchActivity.this, LoginActivity.class);
//                    DispatchActivity.this.startActivity(loginIntent);
//                } else {
//                    Log.e("ERROR", e.toString());
//                }
//            }
//        });



        if (ParseUser.getCurrentUser() != null) {
            Intent SignUpIntent = new Intent(DispatchActivity.this, LoginActivity.class);
            DispatchActivity.this.startActivity(SignUpIntent);
        }
        else {
            Intent MainPageIntent = new Intent(DispatchActivity.this, UserActivity.class);
            DispatchActivity.this.startActivity(MainPageIntent);
        }
    }
}
