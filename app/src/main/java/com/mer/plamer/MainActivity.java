package com.mer.plamer;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.widget.ImageButton;


import com.mer.plamer.controller.PlaylistControl;
import com.mer.plamer.controller.TrackLibraryControl;
import com.mer.plamer.controller.UserControl;
import com.mer.plamer.usecases.PlayAction;
/**
 * Startup activity and view of Plamer
 */
public class MainActivity extends AppCompatActivity {

    private final ActivityResultLauncher<String> requestPermissionLauncher =
            registerForActivityResult(new ActivityResultContracts.RequestPermission(), isGranted -> {
                if (isGranted) {
                    TrackLibraryControl trackLibraryControl = new TrackLibraryControl();
                    trackLibraryControl.scanLocal();
                }
            });
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
        requestPermissionLauncher.launch("android.permission.READ_EXTERNAL_STORAGE");
        setContentView(R.layout.homepage_layout);
        trackLibraryControl.scanLocal();
        playlistControl.scanLocal();
        userControl.scanLocal();
        PlayAction.prepare();

        ImageButton log_in = findViewById(R.id.home_login);
        log_in.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);

        });

        ImageButton sign_up = findViewById(R.id.home_signup);
        sign_up.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SignupActivity.class);
            startActivity(intent);
        });

    }


}