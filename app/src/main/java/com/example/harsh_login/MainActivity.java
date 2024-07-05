package com.example.harsh_login;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")

    Button login;
    EditText email, password;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        View button = findViewById(R.id.button_);
         email = findViewById(R.id.main_emial);
         password = findViewById(R.id.main_password);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (email.getText().toString().trim().equals("")) {
                    email.setError("Email Id Required !");
                }
                else if (!email.getText().toString().trim().matches(emailPattern)) {
                    email.setError("Valid Email Id Required !");
                    
                }
                else if (password.getText().toString().trim().equals("")) {
                    password.setError("Password Required !");
                }
                else if (password.getText().toString().trim().length()<6) {
                    password.setError("Minimum 6 char Required !");

                }
                else {
                    Toast.makeText(getApplicationContext(), "Sign up sucessfully", Toast.LENGTH_SHORT).show();
                    Snackbar.make(view, "You Are Logged In", Snackbar.LENGTH_LONG).show();
                    Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                    ;
                    startActivity(intent);
                }

            }
        });

        }
    }
