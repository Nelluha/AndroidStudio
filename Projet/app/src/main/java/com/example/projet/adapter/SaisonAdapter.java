package com.example.projet.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projet.PageAnime;
import com.example.projet.PageVideo;
import com.example.projet.R;
import com.example.projet.Saison;

import java.util.List;

public class SaisonAdapter extends RecyclerView.Adapter<SaisonAdapter.ViewHolder>{
    Context context;
    List<Saison> saisonList;

    public SaisonAdapter(Context context,List<Saison> saisonList) {
        this.context=context;
        this.saisonList = saisonList;
    }

    @NonNull
    @Override
    public SaisonAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SaisonAdapter.ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_saison_horizontal,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull SaisonAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.textView.setText(saisonList.get(position).getNum());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Saison.getType() == "Anime") {
                    Intent i = new Intent(context, PageVideo.class);
                    context.startActivity(i);
                }
                else {
                    Intent i = new Intent(context, PageAnime.class);
                    i.putExtra("saisonId", saisonList.get(position).getId());
                    i.putExtra("saisonNum", saisonList.get(position).getNum());
                    context.startActivity(i);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
            return saisonList.size();
        }
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.item_saison);
        }
    }
}
