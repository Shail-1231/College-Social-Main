package com.myapp.collegesocial;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LoginActivity extends AppCompatActivity {

    EditText email, password, name;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    FirebaseAuth mAuth;
    Button signUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.edt_email_login);
        password = findViewById(R.id.edt_password_login);
        name = findViewById(R.id.edt_name_login);
        mAuth = FirebaseAuth.getInstance();
        signUp = findViewById(R.id.btn_login_signUp);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("User");

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nm = name.getText().toString();
                String em = email.getText().toString();
                String pass = password.getText().toString();
                if (pass.length() < 5) {
                    Toast.makeText(LoginActivity.this, "Enter password more than 5 characters", Toast.LENGTH_LONG).show();

                } else {
                    mAuth.createUserWithEmailAndPassword(em, pass).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                String id = mAuth.getUid();
                                UserModel userModel = new UserModel();
                                userModel.setEmail(em);
                                userModel.setName(nm);
                                userModel.setPassword(pass);
                                userModel.setId(id);
                                databaseReference.child(id).setValue(userModel);
                            }
                        }
                    });
                }
            }
        });


    }
}