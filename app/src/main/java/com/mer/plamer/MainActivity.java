package com.mer.plamer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


import com.mer.plamer.controller.*;


public class MainActivity extends AppCompatActivity {

    public static final int EXAMPLE_MEDIA_ID = R.raw.oyasumi;

    private PlayControl player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // We will be using an sample media for our walk through
        player = new PlayControl(this, EXAMPLE_MEDIA_ID);
        setContentView(R.layout.activity_main);


        // Open player view
        player.view();
    }


}