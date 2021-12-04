package com.mer.plamer;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.mer.plamer.controller.UserControl;

public class SettingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_layout);

        Button setting_logout = findViewById(R.id.log_out);
      
        setting_logout.setOnClickListener(v -> {
            Intent intent = new Intent(SettingActivity.this, MainActivity.class);
            startActivity(intent);
        });

        String username = getIntent().getStringExtra("curr_user");

        UserControl userControl = new UserControl();
        userControl.userAction.setUser(userControl.getUserLibraryAction().find(username));

        TextView setting_current_username = findViewById(R.id.setting_current_username);
        String current_username = userControl.getAccountInfo();
        setting_current_username.setText(current_username);

        ImageButton back = findViewById(R.id.setting_back);

        back.setOnClickListener(v -> finish());
    }
}