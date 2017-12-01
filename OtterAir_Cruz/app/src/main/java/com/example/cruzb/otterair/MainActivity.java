/*
 * Title: OtterAir App MainActivity.java
 * Abstract: This program is the main activity for Project2 Otter Airlines Android Application
 * Author: Brandon Cruz
 * ID: 8309
 * Date: 11/16/17
 */


package com.example.cruzb.otterair;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity{

    private Button caButton;
    private Button rsButton;
    private Button crButton;
    private Button msButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        caButton = (Button) findViewById(R.id.createAccountButton);
        caButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent ca = new Intent(getApplicationContext(), CreateAccountActivity.class);
                startActivity(ca);
            }
        });
        rsButton = (Button) findViewById(R.id.reserveSeatButton);
        rsButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Toast.makeText(getApplicationContext(), "Reserve Seat is Under Construction", Toast.LENGTH_LONG).show();
            }
        });
        crButton = (Button) findViewById(R.id.cancelReservationButton);
        crButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Cancel Reservation is Under Construction", Toast.LENGTH_LONG).show();
            }
        });
        msButton = (Button) findViewById(R.id.manageSystemButton);
        msButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Manage System is Under Construction", Toast.LENGTH_LONG).show();
            }
        });
    }
}
