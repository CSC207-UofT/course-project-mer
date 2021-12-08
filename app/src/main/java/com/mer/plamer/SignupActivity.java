package com.mer.plamer;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.mer.plamer.controller.UserControl;

/**
 * Activity to provide the sign up view and features to allow account sign up
 */
public class SignupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_layout);

        ImageButton back = findViewById(R.id.signup_back);
        back.setOnClickListener(v -> finish());

        ImageButton signup_go = findViewById(R.id.signup_go);
        signup_go.setOnClickListener(v -> {

            EditText signup_username = findViewById(R.id.signup_username);
            String s_name = signup_username.getText().toString();

            EditText signup_password = findViewById(R.id.signup_password);
            String s_password = signup_password.getText().toString();

            UserControl userControl = new UserControl();
          
            if (userControl.registration(s_name, s_password)) {
                Toast.makeText(SignupActivity.this, "Successfully registered.",
                        Toast.LENGTH_LONG).show();
                Intent intent = new Intent(SignupActivity.this,
                        LoginActivity.class);startActivity(intent);
                signup_username.setText("");
                signup_password.setText("");
            }
            else if (!(!s_name.equals("") & !s_password.equals(""))) {
                Toast.makeText(SignupActivity.this, "Username and Password cannot " +
                                "be empty",
                        Toast.LENGTH_LONG).show();
            }
            else {
                Toast.makeText(SignupActivity.this, "This username has been taken.",
                        Toast.LENGTH_LONG).show();
            }
            });
    }

}