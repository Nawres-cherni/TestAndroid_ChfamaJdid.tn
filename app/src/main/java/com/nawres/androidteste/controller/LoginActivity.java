package com.nawres.androidteste.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;
import com.nawres.androidteste.R;
import com.nawres.androidteste.globale.Constant;

import static com.nawres.androidteste.globale.Constant.KEY_NAME;

public class LoginActivity extends AppCompatActivity {
    EditText EditEmail,EdiPassword,EditName;
    Button btnEnvoyer;
    CheckBox ShowPassword;
    AwesomeValidation awesomeValidation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);
        initView();
        validateChamp();
        showPassword();
    }
    private void  initView(){
        EditName= findViewById(R.id.edit_name);
        EditEmail= findViewById(R.id.edit_email);
        EdiPassword= findViewById(R.id.edit_password);
        btnEnvoyer= findViewById(R.id.btn_connect);
        ShowPassword=findViewById(R.id.showpassword);

    }

    private void validateChamp() {
        awesomeValidation=new AwesomeValidation(ValidationStyle.BASIC);
        awesomeValidation.addValidation(this,R.id.edit_name, RegexTemplate.NOT_EMPTY,R.string.name_invalid);
        awesomeValidation.addValidation(this,R.id.edit_password, RegexTemplate.NOT_EMPTY,R.string.password_invalid);
        awesomeValidation.addValidation(this,R.id.edit_email, Patterns.EMAIL_ADDRESS,R.string.email_invalid);
        btnEnvoyer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(awesomeValidation.validate()){
                    LoginUser();
                }

            }
        });

    }


    private void  showPassword(){
        ShowPassword.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    EdiPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
                else{
                    EdiPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });
    }




    private void LoginUser(){
        SharedPreferences sharedPref = getSharedPreferences(Constant.MY_PREF, Context.MODE_PRIVATE);
        String name=sharedPref.getString(KEY_NAME,null);
        if(name != null){
            startActivity(new Intent(LoginActivity.this, MainActivity.class));

        }
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(KEY_NAME,EditName.getText().toString());
        editor.apply();
        startActivity(new Intent(LoginActivity.this, MainActivity.class));
        finish();
    }




}
