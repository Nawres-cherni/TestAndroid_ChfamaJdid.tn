package com.nawres.androidteste.models;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nawres.androidteste.controller.DetailActivity;
import com.nawres.androidteste.R;

import java.util.List;

public class ArcticleAdapter extends RecyclerView.Adapter<ArcticleAdapter.MyViewHolder>{
    List<Article> artcile_liste;
    Context context;
    public ArcticleAdapter(List<Article> artcileListe, Context context) {
        this.artcile_liste = artcileListe;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.articles_list_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        final Article artticle=artcile_liste.get(position);
        holder.title_arti.setText(artticle.getTitle_artcile());
        holder.description_arti.setText(artticle.getDescription_artcile());
        holder.image_arti.setImageDrawable(context.getResources().getDrawable(artticle.getImage_artcile()));
        holder.reltive.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(context, DetailActivity.class);
                intent.putExtra("image",artticle.getImage_artcile());
                intent.putExtra("title",artticle.getTitle_artcile());
                intent.putExtra("description",artticle.getDescription_artcile());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return artcile_liste.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView image_arti;
        TextView title_arti,description_arti;
        RelativeLayout reltive;
        public MyViewHolder( View itemView) {
            super(itemView);
            image_arti=itemView.findViewById(R.id.image_artcile);
            title_arti=itemView.findViewById(R.id.text_title);
            description_arti=itemView.findViewById(R.id.text_description);
            reltive=itemView.findViewById(R.id.reltive);

        }
    }


}



