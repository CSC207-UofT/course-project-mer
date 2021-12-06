package com.mer.plamer;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.mer.plamer.controller.UserControl;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);

        // back to the last page
        ImageButton back = findViewById(R.id.login_back);
        back.setOnClickListener(v -> finish());

        // confirm the input of username and password
        ImageButton login_go = findViewById(R.id.login_go);
        login_go.setOnClickListener(v -> {

            EditText login_username = findViewById(R.id.login_username);
            String l_name = login_username.getText().toString();

            EditText login_password = findViewById(R.id.login_password);

            String l_password = login_password.getText().toString();

            UserControl userControl = new UserControl();

            // if password match the username, then log in
            if (userControl.login_check(l_name, l_password)) {
                Intent intent = new Intent(LoginActivity.this, MainPage.class);
                intent.putExtra("curr_user", userControl.userAction.getUser().getUsername());
                startActivity(intent);
            }
            // if password doesn't match the username, then show "Incorrect username or password"
            // on the screen
            else {

                Toast.makeText(LoginActivity.this,
                        "Incorrect username or password.", Toast.LENGTH_LONG).show();
            }

        });
    }
}