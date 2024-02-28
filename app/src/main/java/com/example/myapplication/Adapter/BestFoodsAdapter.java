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
import com.example.myapplication.Domain.Foods;
import com.example.myapplication.R;

import java.util.ArrayList;

public class BestFoodsAdapter extends RecyclerView.Adapter<BestFoodsAdapter.viewholder> {

    ArrayList<Foods> items;
    Context context; //Context provides access to application-specific resources like strings,
                    // drawables, layouts, and so on. In a RecyclerView adapter, you might need access to resources
                    // to inflate layouts, load images, or access localized strings.


    public BestFoodsAdapter(ArrayList<Foods> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public BestFoodsAdapter.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext(); //By calling getContext() on the parent, you're retrieving the Context associated with
                                        // the RecyclerView or its immediate parent layout. This context can then be used within
                                         // the adapter for various purposes such as inflating layouts, accessing resources, or starting activities.
                                        //Also recyclerview adapter, parent refers to the parent ViewGroup to which the RecyclerView belongs.
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_best_deal, parent, false);
        return new viewholder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull BestFoodsAdapter.viewholder holder, int position) {

        holder.titleTxt.setText(items.get(position).getTitle()); //this line of code sets the text of a TextView (titleTxt) in the current ViewHolder to the title of the corresponding item in the dataset (items) at the given position. It's a key part of the process of populating the RecyclerView with data, as it dynamically updates the views as the user scrolls through the list
        holder.priceTxt.setText("$"+ items.get(position).getPrice());
        holder.timeTxt.setText(items.get(position).getTimeValue()+" min");
        holder.starTxt.setText(""+items.get(position).getStar());

        Glide.with(context)
                .load(items.get(position).getImagePath())
                .transform(new CenterCrop(), new RoundedCorners(30))
                .into(holder.pic);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class viewholder extends RecyclerView.ViewHolder{
        TextView titleTxt, starTxt, timeTxt, priceTxt;
        ImageView pic;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            titleTxt = itemView.findViewById(R.id.titleTxt);
            starTxt = itemView.findViewById(R.id.starTxt);
            timeTxt = itemView.findViewById(R.id.timeTxt);
            priceTxt = itemView.findViewById(R.id.priceTxt);
            pic = itemView.findViewById(R.id.pic);

        }
    }
}
