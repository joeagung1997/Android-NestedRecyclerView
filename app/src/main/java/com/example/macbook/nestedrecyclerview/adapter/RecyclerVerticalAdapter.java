package com.example.macbook.nestedrecyclerview.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.macbook.nestedrecyclerview.R;
import com.example.macbook.nestedrecyclerview.model.ModelVertical;

import java.util.ArrayList;

public class RecyclerVerticalAdapter extends RecyclerView.Adapter<RecyclerVerticalAdapter.MyViewHolder> {

    //buat menampung data
    ArrayList<ModelVertical> data = new ArrayList<>();


    public RecyclerVerticalAdapter(ArrayList<ModelVertical> data) {
        this.data = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_vertical, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tvTitleAdv.setText(data.get(position).getTitleAdv());
        holder.tvDescAdv.setText(data.get(position).getDescriptionAdv());
        holder.imgAdv.setImageResource(data.get(position).getImageAdv());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitleAdv, tvDescAdv;
        ImageView imgAdv;

        public MyViewHolder(View itemView) {
            super(itemView);

            tvTitleAdv = (TextView) itemView.findViewById(R.id.text_view_title_adv);
            tvDescAdv = (TextView) itemView.findViewById(R.id.text_view_description_adv);
            imgAdv = (ImageView) itemView.findViewById(R.id.image_view_Adv);


        }
    }
}
