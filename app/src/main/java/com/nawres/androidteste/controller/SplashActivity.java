package com.nawres.androidteste.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.nawres.androidteste.R;
import com.nawres.androidteste.globale.Constant;

import static com.nawres.androidteste.globale.Constant.KEY_NAME;

public class SplashActivity extends AppCompatActivity {
    Animation topAnim, bottomAnim;
    ImageView imageApp;
    TextView textApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        topAnim = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);

        imageApp=findViewById(R.id.imagedelapp);
        textApp=findViewById(R.id.nomdelapp);


        imageApp.setAnimation(topAnim);
        textApp.setAnimation(bottomAnim);

        Handler handler= new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                openNextScreen();
                finish();
            }
        }, Constant.Splash_Screen);
    }

    private void openNextScreen(){
        SharedPreferences sharedPref = getSharedPreferences(Constant.MY_PREF, Context.MODE_PRIVATE);
        String name=sharedPref.getString(KEY_NAME,null);
        if(name != null){
            startActivity(new Intent(SplashActivity.this, MainActivity.class));

        }
        else{
            startActivity(new Intent(SplashActivity.this, LoginActivity.class));
        }

    }


}

