package com.mer.plamer;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.mer.plamer.controller.UserControl;
import com.mer.plamer.usecases.UserLibraryAction;

public class SettingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_layout);

        //  log out
        Button setting_logout = findViewById(R.id.log_out);
      
        setting_logout.setOnClickListener(v -> {
            Intent intent = new Intent(SettingActivity.this, MainActivity.class);
            startActivity(intent);
        });

        // show the current username
        String username = getIntent().getStringExtra("curr_user");
        UserControl userControl = new UserControl();
        userControl.userAction.setUser(UserLibraryAction.find(username));
        TextView setting_current_username = findViewById(R.id.setting_current_username);
        String current_username = userControl.getAccountInfo();
        setting_current_username.setText(current_username);

        // set new password
        ImageButton setting_go = (ImageButton) findViewById(R.id.setting_go);
        setting_go.setOnClickListener(v -> {

            EditText new_password = findViewById(R.id.setting_password);
            String n_password = new_password.getText().toString();

            Intent intent = new Intent(SettingActivity.this, LoginActivity.class);

        });

        // back to the last page
        ImageButton back = findViewById(R.id.setting_back);

        back.setOnClickListener(v -> finish());
    }
}