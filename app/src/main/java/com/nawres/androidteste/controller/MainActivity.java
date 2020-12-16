package com.nawres.androidteste.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.nawres.androidteste.R;
import com.nawres.androidteste.globale.Constant;

import static com.nawres.androidteste.globale.Constant.KEY_NAME;

public class MainActivity extends AppCompatActivity {
    TextView txtView;
    Button btn_click;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        sharedMethode();
        clickMethode();
    }


    private void sharedMethode(){
        txtView=findViewById(R.id.nametext);
        SharedPreferences sharedPref = getSharedPreferences(Constant.MY_PREF, Context.MODE_PRIVATE);
        String name=sharedPref.getString(KEY_NAME,null);
        if(name != null){
            txtView.setText("User Name :"+name);
        }
    }


    private void clickMethode(){
        btn_click=findViewById(R.id.btn_start);
        btn_click.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent=new Intent(MainActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

    }


}

