package com.myapp.collegesocial;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SignInActivity extends AppCompatActivity {

    EditText email, password;
    Button signIn;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    FirebaseAuth mAuth;
    TextView forgotPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        email = findViewById(R.id.edt_email_signIn);
        password = findViewById(R.id.edt_password_signIn);
        forgotPassword = findViewById(R.id.tv_sign_in_forgot_password);
        signIn = findViewById(R.id.btn_signIn_signIn);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("User");
        mAuth = FirebaseAuth.getInstance();

        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SignInActivity.this, ForgotPasswordActivity.class);
                startActivity(i);
            }
        });

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String em = email.getText().toString();
                String pass = password.getText().toString();
                if (em.trim().length() == 0) {
                    Toast.makeText(SignInActivity.this, "Please enter email address!!!", Toast.LENGTH_LONG).show();
                } else if (pass.trim().length() == 0) {
                    Toast.makeText(SignInActivity.this, "Please enter password!!!", Toast.LENGTH_LONG).show();
                } else {
                    mAuth.signInWithEmailAndPassword(em, pass).addOnCompleteListener(SignInActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {

                                if (mAuth.getCurrentUser().isEmailVerified()) {
                                    String uid = mAuth.getUid();
                                    databaseReference.child(uid).addListenerForSingleValueEvent(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot snapshot) {

                                            UserModel userModel = snapshot.getValue(UserModel.class);
                                            String name = userModel.getName();
                                            String email = userModel.getEmail();
                                            String password = userModel.getPassword();

                                            SharedPreferences sharedPreferences = getSharedPreferences("MYAPP", MODE_PRIVATE);
                                            SharedPreferences.Editor editor = sharedPreferences.edit();
                                            editor.putString("KEY_Name", name);
                                            editor.putString("KEY_Email", email);
                                            editor.putString("KEY_Password", password);
                                            editor.commit();


                                            Intent i = new Intent(SignInActivity.this, NavigationDrawerActivity.class);
                                            startActivity(i);
                                            finish();

                                        }


                                        @Override
                                        public void onCancelled(@NonNull DatabaseError error) {

                                        }
                                    });
                                } else {
                                    Toast.makeText(SignInActivity.this, "Please verify email address!!!", Toast.LENGTH_LONG).show();
                                }
                            } else {
                                Toast.makeText(SignInActivity.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                }
            }
        });
    }
}