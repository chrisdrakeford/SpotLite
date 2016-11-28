package com.parse.starter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SaveCallback;
import com.parse.SignUpCallback;

public class RegisterActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        final EditText Age = (EditText) findViewById(R.id.Age);
        final EditText Name = (EditText) findViewById(R.id.Name);
        final EditText UserName = (EditText) findViewById(R.id.UserName);
        final EditText Password = (EditText) findViewById(R.id.Password);
        final EditText Password2 = (EditText) findViewById(R.id.password2);
        final Button Register = (Button) findViewById(R.id.Register);

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean Validation_error = false;
                StringBuilder ValidationErrorMessage = new StringBuilder("Error/n");

                if (isEmpty(UserName)) {
                    Validation_error = true;
                    ValidationErrorMessage.append("User Name not Entered");
                }

                if (isEmpty(Age)) {
                    Validation_error = true;
                    ValidationErrorMessage.append("Age not Entered ");
                }

                if (isEmpty(Name)) {
                    Validation_error = true;
                    ValidationErrorMessage.append("Name Not entered ");

                }
                if (isEmpty(Password) || isEmpty(Password2)) {
                    Validation_error = true;
                    ValidationErrorMessage.append("Password/s not entered ");
                }
                if (isMatching(Password, Password2)) {
                    Validation_error = true;
                    ValidationErrorMessage.append("Passwords do not match ");
                }


                if (Validation_error) {
                    Toast.makeText(RegisterActivity.this, ValidationErrorMessage.toString(), Toast.LENGTH_LONG)
                            .show();
                    return;
                }

                ParseObject userData = new ParseObject("UserData");
                userData.put("age", Integer.parseInt(Age.getText().toString()));
                userData.put("userName", UserName.getText().toString());
                userData.put("password", Password.getText().toString());
                userData.put("name", Name.getText().toString());
                //userData.saveInBackground();

                userData.saveInBackground(new SaveCallback() {
                    public void done(ParseException e) {
                        if (e == null) {
                            Intent loginIntent = new Intent(RegisterActivity.this, LoginActivity.class);
                            RegisterActivity.this.startActivity(loginIntent);
                        } else {
                            Log.e("ERROR", e.toString());
                        }
                    }
                });

            }
        });
    }

    private boolean isEmpty(EditText etText) {
        if (etText.getText().toString().trim().length() > 0) {
            return false;
        } else {
            return true;
        }
    }

    private boolean isMatching(EditText etText1, EditText etText2) {
        if (etText1.getText().toString().equals(etText2.getText().toString())) {
            return true;
        } else {
            return false;
        }

    }
}
