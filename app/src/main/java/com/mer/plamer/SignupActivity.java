package com.mer.plamer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import com.mer.plamer.controller.UserControl;

public class SignupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_layout);

        ImageButton back = (ImageButton) findViewById(R.id.signup_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });

        ImageButton signup_go = (ImageButton) findViewById(R.id.signup_go);
        signup_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText signup_username = (EditText) findViewById(R.id.signup_username);
                String s_name = signup_username.getText().toString();

                EditText signup_password = (EditText) findViewById(R.id.signup_password);
                String s_password = signup_password.getText().toString();

                UserControl userControl = new UserControl();
                if (userControl.registration(s_name, s_password)) {
                    Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                    startActivity(intent);;
                }
                else {
                    Toast.makeText(SignupActivity.this, "This username has been taken.",
                            Toast.LENGTH_LONG).show();
                }
                }
        });
    }

}