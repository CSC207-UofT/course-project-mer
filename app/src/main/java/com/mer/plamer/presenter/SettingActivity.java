package com.mer.plamer.presenter;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.mer.plamer.R;
import com.mer.plamer.controller.UserControl;

/**
 * Activity to provide the settings page and user modification features
 */
public class SettingActivity extends AppCompatActivity {

    /**
     * Construct view and define actions for each interactive elements
     * @param savedInstanceState savedInstanceState the previously saved state of this activity
     */
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
        UserControl userControl = new UserControl();
        TextView setting_current_username = findViewById(R.id.setting_current_username);
        String current_username = userControl.getAccountInfo();
        setting_current_username.setText(current_username);

        // set new password
        ImageButton setting_go = findViewById(R.id.setting_go);
        setting_go.setOnClickListener(v -> {

            EditText new_password = findViewById(R.id.setting_password);
            String n_password = new_password.getText().toString();

            if (userControl.modifyUserPassword(n_password)) {
                userControl.modifyUserPassword(n_password);
                Intent intent = new Intent(SettingActivity.this, LoginActivity.class);
                startActivity(intent);
                new_password.setText("");
            }

            else if (n_password.equals("")) {
                Toast.makeText(SettingActivity.this, "Can not have empty password.",
                        Toast.LENGTH_LONG).show();
            }

            else {
                Toast.makeText(SettingActivity.this, "This is the old password.",
                        Toast.LENGTH_LONG).show();
            }

        });

        // back to the last page
        ImageButton back = findViewById(R.id.setting_back);


        back.setOnClickListener(v -> finish());
    }
}