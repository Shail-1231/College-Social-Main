package com.myapp.collegesocial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreenActivity extends AppCompatActivity {

    ImageView logo;
    TextView title;
    int time = 2700;
    Animation topAnim, bottomAnim;
    private String strPassword;
    private String strEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);


        GIFImageView gifImageView = findViewById(R.id.gif_title);
        gifImageView.setGifImageResource(R.drawable.source);
        topAnim = AnimationUtils.loadAnimation(SplashScreenActivity.this, R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(SplashScreenActivity.this, R.anim.bottom_animation);

        logo = findViewById(R.id.logo_splash);

        logo.setAnimation(topAnim);


        SharedPreferences sharedPreferences = getSharedPreferences("MYAPP", MODE_PRIVATE);
        sharedPreferences.getString("KEY_Name", "");
        strEmail = sharedPreferences.getString("KEY_Email", "");
        strPassword = sharedPreferences.getString("KEY_Password", "");


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {


                Intent i;
                if (strEmail.equals("") && strPassword.equals("")) {
                    i = new Intent(SplashScreenActivity.this, LoginActivity.class);
                } else {
                    i = new Intent(SplashScreenActivity.this, NavigationDrawerActivity.class);
                }
                startActivity(i);
                finish();
            }
        }, time);
    }
}