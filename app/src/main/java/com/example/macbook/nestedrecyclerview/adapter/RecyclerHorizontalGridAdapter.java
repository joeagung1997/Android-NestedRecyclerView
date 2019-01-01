package com.example.macbook.nestedrecyclerview.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.macbook.nestedrecyclerview.R;
import com.example.macbook.nestedrecyclerview.model.ModelHorizontalGrid;

import java.util.ArrayList;

public class RecyclerHorizontalGridAdapter extends RecyclerView.Adapter<RecyclerHorizontalGridAdapter.MyViewHolder> {

    ArrayList<ModelHorizontalGrid> data = new ArrayList<>();


    public RecyclerHorizontalGridAdapter(ArrayList<ModelHorizontalGrid> data) {
        this.data = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grid_horizontal, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.titleGrid.setText(data.get(position).getTitle());
        holder.imageGrid.setImageResource(data.get(position).getImage());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView titleGrid;
        ImageView imageGrid;

        public MyViewHolder(View itemView) {
            super(itemView);

            titleGrid = (TextView) itemView.findViewById(R.id.text_view_title_grid);
            imageGrid = (ImageView) itemView.findViewById(R.id.image_view_grid);
        }
    }
}
