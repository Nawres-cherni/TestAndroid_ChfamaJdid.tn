package com.nawres.androidteste.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.WindowManager;

import com.nawres.androidteste.R;
import com.nawres.androidteste.models.ArcticleAdapter;
import com.nawres.androidteste.models.Article;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<Article> artcile_list;
    RecyclerView.Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_home);




        artcile_list=new ArrayList<>();
        recyclerView=findViewById(R.id.recyclerview_artcile);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        artcile_list.add(new Article(R.drawable.ahmini,getString(R.string.ahmini_title),getString(R.string.ahmini_description)));
        artcile_list.add(new Article(R.drawable.ins,getString(R.string.ins_title),getString(R.string.ins_description)));
        artcile_list.add(new Article(R.drawable.dabchy,getString(R.string.dabchy_ttile),getString(R.string.dabchy_decription)));
        artcile_list.add(new Article(R.drawable.ahkili,getString(R.string.ahkili_title),getString(R.string.ahkili_descriptio)));
        artcile_list.add(new Article(R.drawable.onboard,getString(R.string.onboard_title),getString(R.string.onboard_description)));
        artcile_list.add(new Article(R.drawable.oxahost,getString(R.string.oxahost_title),getString(R.string.oxahost_description)));
        artcile_list.add(new Article(R.drawable.invest,getString(R.string.invest_title),getString(R.string.invest_description)));
        adapter=new ArcticleAdapter(artcile_list,getApplicationContext());
        recyclerView.setAdapter(adapter);



    }
}
