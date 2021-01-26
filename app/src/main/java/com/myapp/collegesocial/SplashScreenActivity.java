package com.myapp.collegesocial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        GIFImageView gifImageView = findViewById(R.id.gif_title);
        gifImageView.setGifImageResource(R.drawable.source);
        topAnim = AnimationUtils.loadAnimation(SplashScreenActivity.this, R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(SplashScreenActivity.this, R.anim.bottom_animation);

        logo = findViewById(R.id.logo_splash);

        logo.setAnimation(topAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashScreenActivity.this, LoginActivity.class);
                startActivity(i);
                finish();
            }
        }, time);
    }
}