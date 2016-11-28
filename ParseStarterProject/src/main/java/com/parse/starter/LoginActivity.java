package com.parse.starter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.parse.Parse;
import com.parse.ParseObject;

import java.util.jar.Attributes;

import static com.parse.starter.R.id.Age;

public class LoginActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText UserName = (EditText) findViewById(R.id.UserName);
        final EditText Password = (EditText) findViewById(R.id.Password);
        final Button Login = (Button) findViewById(R.id.Login);
        final TextView RegisterHere = (TextView) findViewById(R.id.tvRegister);



        /*Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent userIntent = new Intent(LoginActivity.this, UserActivity.class);

            }
        });*/

        RegisterHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerIntent = new Intent(LoginActivity.this, RegisterActivity.class);
                LoginActivity.this.startActivity(registerIntent);
            }
        });


        }
    }
