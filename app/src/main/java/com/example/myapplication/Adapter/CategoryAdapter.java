package com.example.myapplication.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapplication.Domain.Category;
import com.example.myapplication.R;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    private ArrayList<Category> items;
    private Context context;

    public CategoryAdapter(ArrayList<Category> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_category, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Category category = items.get(position);
        holder.titleTxt.setText(category.getName());

        // Set background drawable based on position
        switch (position) {
            case 0:
                holder.pic.setBackgroundResource(R.drawable.cat_0_background);
                break;
            case 1:
                holder.pic.setBackgroundResource(R.drawable.cat_1_background);
                break;
            case 2:
                holder.pic.setBackgroundResource(R.drawable.cat_2_background);
                break;
            case 3:
                holder.pic.setBackgroundResource(R.drawable.cat_3_background);
                break;
            case 4:
                holder.pic.setBackgroundResource(R.drawable.cat_4_background);
                break;
            case 5:
                holder.pic.setBackgroundResource(R.drawable.cat_5_background);
                break;
            case 6:
                holder.pic.setBackgroundResource(R.drawable.cat_6_background);
                break;
            case 7:
                holder.pic.setBackgroundResource(R.drawable.cat_7_background);
                break;
        }

        // Load image using Glide
        int drawableResourceId = context.getResources().getIdentifier(category.getImagePath(),
                "drawable", context.getPackageName());
        Glide.with(context)
                .load(drawableResourceId)
                .into(holder.pic);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //start from here
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView titleTxt;
        ImageView pic;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTxt = itemView.findViewById(R.id.catNameTxt);
            pic = itemView.findViewById(R.id.imgCat);
        }
    }
}





