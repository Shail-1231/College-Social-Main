package com.myapp.collegesocial;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LoginActivity extends AppCompatActivity {

    EditText email, password, name;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    FirebaseAuth mAuth;
    Dialog dialog;
    Button signUp, signIn;
    boolean error = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.edt_email_login);
        password = findViewById(R.id.edt_password_login);
        name = findViewById(R.id.edt_name_login);
        mAuth = FirebaseAuth.getInstance();
        signUp = findViewById(R.id.btn_login_signUp);
        signIn = findViewById(R.id.btn_login_signIn);
        dialog = new Dialog(this);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("User");

        signUp.setOnClickListener(v -> {
            String nm = name.getText().toString();
            String em = email.getText().toString();
            String pass = password.getText().toString();

            if (nm.trim().length() < 2) {
                Toast.makeText(LoginActivity.this, "Enter name again", Toast.LENGTH_LONG).show();
                error = true;
            } else {
                error = false;
            }

            if (em.trim().length() < 10) {
                Toast.makeText(LoginActivity.this, "Enter email again", Toast.LENGTH_LONG).show();
                error = true;
            } else {
                error = false;
            }

            if (pass.length() < 5) {
                Toast.makeText(LoginActivity.this, "Enter password more than 5 characters", Toast.LENGTH_LONG).show();
                error = true;
            } else {
                error = false;
            }

            if (error) {
                Toast.makeText(LoginActivity.this, "Enter credentials again", Toast.LENGTH_LONG).show();
            } else {
                mAuth.createUserWithEmailAndPassword(em, pass).addOnCompleteListener(LoginActivity.this, task -> {
                    if (!task.isSuccessful()) {
                        Toast.makeText(LoginActivity.this, "The user already exists!!!", Toast.LENGTH_LONG).show();


//                                Intent i = new Intent(LoginActivity.this, NavigationDrawerActivity.class);
//                                startActivity(i);
                    } else {
                        mAuth.getCurrentUser().sendEmailVerification().addOnCompleteListener(task1 -> {

                            if (task1.isSuccessful()) {
                                String id = mAuth.getUid();
                                UserModel userModel = new UserModel();
                                userModel.setEmail(em);
                                userModel.setName(nm);
                                userModel.setPassword(pass);
                                userModel.setId(id);
                                databaseReference.child(id).setValue(userModel);
                                SharedPreferences sharedPreferences = getSharedPreferences("MYAPP", MODE_PRIVATE);
                                SharedPreferences.Editor editor = sharedPreferences.edit();
                                editor.putString("KEY_FN", em);
                                editor.putString("KEY_LN", pass);
                                editor.apply();
                                Toast.makeText(LoginActivity.this, "Please check your email for verification!!!", Toast.LENGTH_LONG).show();
                                name.setText("");
                                email.setText("");
                                password.setText("");
                            } else {
                                Toast.makeText(LoginActivity.this, task1.getException().getMessage(), Toast.LENGTH_LONG).show();
                            }

                        });
                    }
                });
            }
        });

        signIn.setOnClickListener(v -> {
            Intent i = new Intent(LoginActivity.this, SignInActivity.class);
            startActivity(i);
        });

    }
}