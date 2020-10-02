package com.example.myjihc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FurnitureListAdapter extends RecyclerView.Adapter<FurnitureListAdapter.MyTViewHolder>{
    private Context context;
    private List<Furniture> furnitureList;

    public class MyTViewHolder extends RecyclerView.ViewHolder{

        public ImageView photo;
        public TextView title, desc, count, price;

        public MyTViewHolder(/*View firebase changeable anywhere*/View view) {
            super(view);
            photo = view.findViewById(R.id.photo);
            title = view.findViewById(R.id.title);
            desc = view.findViewById(R.id.desc);
            count = view.findViewById(R.id.count);
            price = view.findViewById(R.id.price);
        }
    }

    public FurnitureListAdapter(Context context, List<Furniture> furnitureList) {
        this.context = context;
        this.furnitureList = furnitureList;
    }

    @Override
    public MyTViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView;
        itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_furniture, parent, false);

        return new MyTViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyTViewHolder sborka, int position) {
        Furniture item = furnitureList.get(position);

        sborka.photo.setImageResource(item.getPhoto());
        sborka.title.setText(item.getTitle());
        sborka.desc.setText(item.getDesc());
        sborka.count.setText(""+item.getCount());
        sborka.price.setText(""+item.getPrice());
    }

    @Override
    public int getItemCount() { return furnitureList.size();
    }

}