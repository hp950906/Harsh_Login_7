package com.example.harsh_login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SignUpActivity extends AppCompatActivity {

    EditText name,contact,email,password,confirmPassword;
    Button Signup;
    TextView alreadyAccount;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_up);

        name = findViewById(R.id.signup_name);
        contact = findViewById(R.id.signup_contact);
        email = findViewById(R.id.signup_email);
       password = findViewById(R.id.signup_password);
        confirmPassword = findViewById(R.id.signup_confirm_password);
        Signup = findViewById(R.id.signup_button_);
        alreadyAccount = findViewById(R.id.signup_already_have_account);


        alreadyAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (name.getText().toString().trim().equals("")){
                    name.setError("Name Required !");
                }
                else if (contact.getText().toString().trim().equals("")) {
                    contact.setError("Contact no.Required !");
                }
                else if (contact.getText().toString().trim().length()<10) {
                    contact.setError("Contact no. must be 10 digit!");
                }
                else if (email.getText().toString().trim().equals("")) {
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
                else if (confirmPassword.getText().toString().trim().equals("")) {
                    confirmPassword.setError("confirm password Required !");
                }
                else if (confirmPassword.getText().toString().trim().length()<6) {
                    confirmPassword.setError("Minimum 6 char confirm password Required !");
                }
                else if (!password.getText().toString().trim().matches(confirmPassword.getText().toString().trim())) {
                    confirmPassword.setError("Password must be Same !");
                }
                else {

                    Toast.makeText(SignUpActivity.this, "Sign Up Successfully !", Toast.LENGTH_SHORT).show();
                    onBackPressed();
                }




            }
        });
    }
}