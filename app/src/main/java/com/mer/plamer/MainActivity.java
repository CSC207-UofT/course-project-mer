package com.mer.plamer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.widget.ImageButton;


import com.mer.plamer.controller.PlaylistControl;
import com.mer.plamer.controller.TrackLibraryControl;
import com.mer.plamer.controller.UserControl;
import com.mer.plamer.usecases.PlayAction;
import com.mer.plamer.usecases.PlaylistLibraryAction;
import com.mer.plamer.usecases.TrackLibraryAction;
import com.mer.plamer.usecases.UserLibraryAction;

/**
 * Startup activity and view of Plamer
 */
public class MainActivity extends AppCompatActivity {

    /**
     * Constructs view and defines actions of the main view.
     * @param savedInstanceState the previously saved state of this activity
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        UserControl userControl = new UserControl();
        TrackLibraryControl trackLibraryControl = new TrackLibraryControl();
        PlaylistControl playlistControl = new PlaylistControl();
        setContentView(R.layout.homepage_layout);
        trackLibraryControl.scanLocal();
        playlistControl.scanLocal();
        userControl.scanLocal();
        PlayAction.prepare();

        ImageButton log_in = (ImageButton) findViewById(R.id.home_login);
        log_in.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);

        });

        ImageButton sign_up = (ImageButton) findViewById(R.id.home_signup);
        sign_up.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SignupActivity.class);
            startActivity(intent);
        });

    }


}