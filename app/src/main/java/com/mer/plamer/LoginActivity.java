package com.mer.plamer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import com.mer.plamer.controller.UserControl;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);

        ImageButton back = (ImageButton) findViewById(R.id.login_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });

        ImageButton login_go = (ImageButton) findViewById(R.id.login_go);
        login_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText login_username = (EditText)findViewById(R.id.login_username);
                String l_name = login_username.getText().toString();

                EditText login_password = (EditText)findViewById(R.id.login_password);
                String l_password = login_password.getText().toString();

                UserControl userControl = new UserControl();

                if (userControl.login_check(l_name, l_password)) {
                    Intent intent = new Intent(LoginActivity.this, MainPage.class);
                    startActivity(intent);
                }

                else {
                    Toast.makeText(LoginActivity.this,
                            "Incorrect username or password.", Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}