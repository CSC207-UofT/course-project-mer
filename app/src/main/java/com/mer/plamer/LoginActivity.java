package com.mer.plamer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);

        EditText login_username = (EditText)findViewById(R.id.login_username);
        String l_name = login_username.getText().toString();

        EditText login_password = (EditText)findViewById(R.id.login_password);
        String l_password = login_password.getText().toString();

        ImageButton back = (ImageButton) findViewById(R.id.login_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });
    }
}