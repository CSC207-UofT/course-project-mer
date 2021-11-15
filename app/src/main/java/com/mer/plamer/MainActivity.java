package com.mer.plamer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


import com.mer.plamer.controller.UserControl;
import com.mer.plamer.usecases.PlayAction;
import com.mer.plamer.usecases.TrackLibraryAction;

/**
 * Startup activity and view of Plamer
 */
public class MainActivity extends AppCompatActivity {

    /**
     * Constructs view and defines actions of the main view.
     * @param savedInstanceState the previously saved state of this activity
     */
    /**
     * Constructs view and defines actions of the main view.
     * @param savedInstanceState the previously saved state of this activity
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.homepage_layout);


        ImageButton log_in = (ImageButton) findViewById(R.id.home_login);
        log_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);

            }

        });

        ImageButton sign_up = (ImageButton) findViewById(R.id.home_signup);
        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SignupActivity.class);
                startActivity(intent);
            }
        });

    }


}