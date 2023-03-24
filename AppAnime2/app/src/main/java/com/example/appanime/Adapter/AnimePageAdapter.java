package com.example.appanime.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.appanime.AnimeModelClass;
import com.example.appanime.PageDetailAnime;
import com.example.appanime.R;

import java.util.List;

    public class AnimePageAdapter extends RecyclerView.Adapter<AnimePageAdapter.ViewHolder> {
        Context context;
        private List<AnimeModelClass> animeModelClassList;

        public AnimePageAdapter(Context context, List<AnimeModelClass> animeModelClassList) {
            this.context = context;

        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.vignette, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
            holder.name.setText(animeModelClassList.get(position).getAnimeTitle());

            Glide.with(context).load(animeModelClassList.get(position).getAnimeImg()).into(holder.img);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(context, PageDetailAnime.class);
                    i.putExtra("animeId",animeModelClassList.get(position).getAnimeId());
                    i.putExtra("animeImage",animeModelClassList.get(position).getAnimeImg());
                    i.putExtra("animeName",animeModelClassList.get(position).getAnimeTitle());
                    context.startActivity(i);
                }
            });
        }

        @Override
        public int getItemCount() {
            if(animeModelClassList==null) return 0;
            return animeModelClassList.size();
        }

        public static final class ViewHolder extends RecyclerView.ViewHolder {

            ImageView img;
            TextView name;


            public ViewHolder(View itemView) {
                super(itemView);

                img = itemView.findViewById(R.id.image_item);
                name = itemView.findViewById(R.id.nom_item);


            }
        }
    }
