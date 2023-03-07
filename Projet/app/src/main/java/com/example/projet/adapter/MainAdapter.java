package com.example.projet.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.projet.Category;
import com.example.projet.CategoryItem;
import com.example.projet.R;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    Context context;
    List<Category> categoryList;

    public MainAdapter(Context context, List<Category> categoryList) {
        this.context = context;
        this.categoryList = categoryList;
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.main_recycler_horizontal,parent,false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder,int position) {
    holder.categoryTitle.setText(categoryList.get(position).getCategoryTitle());
    setItemRecycler(holder.itemRecycler,categoryList.get(position).getCategoryItemList());


    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView categoryTitle;
        RecyclerView itemRecycler;
        public ViewHolder(View itemView) {
            super(itemView);
            categoryTitle = itemView.findViewById(R.id.textView_main_recycler_category);
            itemRecycler = itemView.findViewById(R.id.item_recycler);
        }
    }

    public void setItemRecycler(RecyclerView recyclerView, List<CategoryItem> categoryItemList){

        ItemAdapter itemAdapter = new ItemAdapter(context,categoryItemList);
        recyclerView.setLayoutManager(new LinearLayoutManager(context,RecyclerView.HORIZONTAL,false));
        recyclerView.setAdapter(itemAdapter);

    }
}