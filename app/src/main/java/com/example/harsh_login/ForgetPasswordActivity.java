package com.example.harsh_login;

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

public class ForgetPasswordActivity extends AppCompatActivity {

    EditText email,newpassword,confirmnewPassword;
    Button submit;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_forget_password);

        email = findViewById(R.id.forgetpass_email);
        newpassword = findViewById(R.id.forgetpass_newpassword);
        confirmnewPassword = findViewById(R.id.forgetpass_confirm_newpassword);
       submit = findViewById(R.id.forgetpass_submit);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (email.getText().toString().trim().equals("")) {
                    email.setError("Email Id Required !");
                }
                else if (!email.getText().toString().trim().matches(emailPattern)) {
                    email.setError("Valid Email Id Required !");
                }
                else if (newpassword.getText().toString().trim().equals("")) {
                    newpassword.setError("Password Required !");
                }
                else if (newpassword.getText().toString().trim().length()<6) {
                    newpassword.setError("Minimum 6 char Required !");
                }
                else if (confirmnewPassword.getText().toString().trim().equals("")) {
                    confirmnewPassword.setError("confirm password Required !");
                }
                else if (confirmnewPassword.getText().toString().trim().length()<6) {
                    confirmnewPassword.setError("Minimum 6 char confirm password Required !");
                }
                else if (!newpassword.getText().toString().trim().matches(confirmnewPassword.getText().toString().trim())) {
                    confirmnewPassword.setError("Password must be Same !");
                }
                else {

                    Toast.makeText(ForgetPasswordActivity.this, "Password change Successfully !", Toast.LENGTH_SHORT).show();
                    onBackPressed();
                }




            }
        });




    }
}