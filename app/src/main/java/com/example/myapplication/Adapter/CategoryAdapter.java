package com.example.myapplication.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.example.myapplication.Domain.Category;
import com.example.myapplication.Domain.Foods;
import com.example.myapplication.R;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.viewholder> {

    ArrayList<Category> items;
    Context context; //Context provides access to application-specific resources like strings,
                    // drawables, layouts, and so on. In a RecyclerView adapter, you might need access to resources
                    // to inflate layouts, load images, or access localized strings.


    public CategoryAdapter(ArrayList<Category> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public CategoryAdapter.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext(); //By calling getContext() on the parent, you're retrieving the Context associated with
                                        // the RecyclerView or its immediate parent layout. This context can then be used within
                                         // the adapter for various purposes such as inflating layouts, accessing resources, or starting activities.
                                        //Also recyclerview adapter, parent refers to the parent ViewGroup to which the RecyclerView belongs.
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_category, parent, false);
        return new viewholder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.viewholder holder, int position) {

        holder.titleTxt.setText(items.get(position).getName());

        switch (position)
        {
            case 0:
            {
                holder.pic.setBackgroundResource(R.drawable.cat_0_background);
            }
            case 1:
            {
                holder.pic.setBackgroundResource(R.drawable.cat_1_background);
            }
            case 2:
            {
                holder.pic.setBackgroundResource(R.drawable.cat_2_background);
            }
            case 3:
            {
                holder.pic.setBackgroundResource(R.drawable.cat_3_background);
            }
            case 4:
            {
                holder.pic.setBackgroundResource(R.drawable.cat_4_background);
            }
            case 5:
            {
                holder.pic.setBackgroundResource(R.drawable.cat_5_background);
            }
            case 6:
            {
                holder.pic.setBackgroundResource(R.drawable.cat_6_background);
            }
            case 7:
            {
                holder.pic.setBackgroundResource(R.drawable.cat_7_background);
            }
        }

        int drawableResourceId = context.getResources().getIdentifier(items.get(position).getImagePath(),
                "drawable", holder.itemView.getContext().getPackageName());
        Glide.with(context)
                .load(drawableResourceId)
                .into(holder.pic);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class viewholder extends RecyclerView.ViewHolder{
        TextView titleTxt;
        ImageView pic;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            titleTxt = itemView.findViewById(R.id.catNameTxt);

            pic = itemView.findViewById(R.id.imgCat);

        }
    }
}
