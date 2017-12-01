package com.example.cruzb.otterair;

/**
 * Created by cruzb on 11/24/2017.
 */

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateAccountActivity extends Activity{

    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_account);

        usernameEditText = (EditText) findViewById(R.id.edit_text_username);
        passwordEditText = (EditText) findViewById(R.id.edit_text_password);

        submitButton = (Button) findViewById(R.id.button_submit);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Toast.makeText(getApplicationContext(), "New Account Created", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
