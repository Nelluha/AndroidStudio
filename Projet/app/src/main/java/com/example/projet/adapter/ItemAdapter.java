package com.example.projet.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projet.AnimeDetail;
import com.example.projet.CategoryItem;
import com.example.projet.PageAnime;
import com.example.projet.R;


import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

    Context context;
    List<CategoryItem> categoryItemList;

    public ItemAdapter(Context context, List<CategoryItem> categoryItemList) {

        this.context = context;
        this.categoryItemList = categoryItemList;
    }


    @Override
    public ItemAdapter.ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        return new ItemAdapter.ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_horizontal,parent,false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.ImageAnime.setImageResource(categoryItemList.get(position).getImage());
        holder.TextNameAnime.setText(categoryItemList.get(position).getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, PageAnime.class);
                i.putExtra("animeId",categoryItemList.get(position).getId());
                i.putExtra("animeImage",categoryItemList.get(position).getImage());
                i.putExtra("animeName",categoryItemList.get(position).getName());
                context.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return categoryItemList.size();
    }

    public static final class ViewHolder extends RecyclerView.ViewHolder{

        ImageView ImageAnime;
        TextView TextNameAnime;

        public ViewHolder(View itemView){
            super(itemView);
            ImageAnime = itemView.findViewById(R.id.image_item);
            TextNameAnime = itemView.findViewById(R.id.nom_item);

        }
    }
}
