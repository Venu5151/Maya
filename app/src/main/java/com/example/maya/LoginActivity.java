package com.example.maya;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity {

    private static final String TAG = LoginActivity.class.getSimpleName();
    Button getVerification;
    EditText phoneNumber;
    private FirebaseUser user;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        phoneNumber = findViewById(R.id.username);
        getVerification = findViewById(R.id.login);

        getVerification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: clicked the getVerification Burtton");
                String phone = phoneNumber.getText().toString();


                if(phone.isEmpty() || phone.length()<10){
                    phoneNumber.setError("Valid Number is Required");
                    phoneNumber.requestFocus();
                    return;
                }
                phone= "+91"+phone;

                Intent intent = new Intent(LoginActivity.this, verificationActivity.class);
                intent.putExtra("phoneNumber",phone);
                startActivity(intent);



            }
        });



    }

    }

