package com.example.macbook.nestedrecyclerview.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.macbook.nestedrecyclerview.R;
import com.example.macbook.nestedrecyclerview.model.ModelHorizontal;

import java.util.ArrayList;

public class RecyclerHorizontalAdapter extends RecyclerView.Adapter<RecyclerHorizontalAdapter.MyViewHolder> {

    ArrayList<ModelHorizontal> data = new ArrayList<>();

    public RecyclerHorizontalAdapter(ArrayList<ModelHorizontal> data) {
        this.data = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_horizontal, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.titleMovie.setText(data.get(position).getTitleMovie());
        holder.imageMovie.setImageResource(data.get(position).getImageMovie());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView titleMovie;
        ImageView imageMovie;

        public MyViewHolder(View itemView) {
            super(itemView);

            titleMovie = (TextView) itemView.findViewById(R.id.text_view_title_movie);
            imageMovie = (ImageView) itemView.findViewById(R.id.image_view_movie);

        }
    }
}
