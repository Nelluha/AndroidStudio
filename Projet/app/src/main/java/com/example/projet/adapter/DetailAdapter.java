package com.example.projet.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projet.Category;
import com.example.projet.CategoryItem;
import com.example.projet.R;
import com.example.projet.Saison;
import com.example.projet.Type;

import java.util.List;

public class DetailAdapter extends RecyclerView.Adapter<DetailAdapter.ViewHolder>{
    Context context;
    List<Type> TypeList;

    public DetailAdapter(Context context, List<Type> typeList) {
        this.context = context;
        this.TypeList = typeList;
    }

    @Override
    public DetailAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new DetailAdapter.ViewHolder(LayoutInflater.from(context).inflate(R.layout.detail_recycler_horizontal,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.TypeName.setText(TypeList.get(position).getTypeName());
        setSaisonItemRecycler(holder.SaisonRecycler,TypeList.get(position).getSaisonList());
    }

    @Override
    public int getItemCount() {
            return TypeList.size();

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView TypeName;
        RecyclerView SaisonRecycler;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            TypeName = itemView.findViewById(R.id.textView_detail_recycler_anime);
            SaisonRecycler = itemView.findViewById(R.id.detail_recycler);
        }
    }
    public void setSaisonItemRecycler(RecyclerView recyclerView, List<Saison> saisonList){

        SaisonAdapter saisonAdapter = new SaisonAdapter(context, saisonList);
        recyclerView.setLayoutManager(new LinearLayoutManager(context,RecyclerView.HORIZONTAL,false));
        recyclerView.setAdapter(saisonAdapter);

    }
}
