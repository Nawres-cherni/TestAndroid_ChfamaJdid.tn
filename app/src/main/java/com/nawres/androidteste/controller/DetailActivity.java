package com.nawres.androidteste.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.nawres.androidteste.R;

public class DetailActivity extends AppCompatActivity {
    ImageView image_detail;
    TextView tile_detail, description_detail;
    String desc, titre;
    int img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_detail);
        initView();
        getData();
        setData();
    }

    private void initView() {
        image_detail = findViewById(R.id.image_detail);
        tile_detail = findViewById(R.id.title_detail);
        description_detail = findViewById(R.id.description_detail);
    }

    private void getData() {
        if (getIntent().hasExtra("title") && getIntent().hasExtra("description") && getIntent().hasExtra("image")){
            titre = getIntent().getStringExtra("title");
            desc = getIntent().getStringExtra("description");
            img = getIntent().getIntExtra("image", 1);
        }else

        {
            Toast.makeText(this, "No Data", Toast.LENGTH_LONG).show();
        }
    }


    private void setData(){
        tile_detail.setText(titre);
        description_detail.setText(desc);
        image_detail.setImageResource(img);
    }




}
