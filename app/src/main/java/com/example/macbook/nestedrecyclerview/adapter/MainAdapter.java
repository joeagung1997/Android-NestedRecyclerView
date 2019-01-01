package com.example.macbook.nestedrecyclerview.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.macbook.nestedrecyclerview.R;
import com.example.macbook.nestedrecyclerview.model.ModelHorizontal;
import com.example.macbook.nestedrecyclerview.model.ModelHorizontalGrid;
import com.example.macbook.nestedrecyclerview.model.ModelVertical;

import java.util.ArrayList;

import static com.example.macbook.nestedrecyclerview.MainActivity.getAdvData;
import static com.example.macbook.nestedrecyclerview.MainActivity.getGridViewData;
import static com.example.macbook.nestedrecyclerview.MainActivity.getMovieData;


public class MainAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final int GRID_HORIZONTAL = 1;
    private final int HORIZONTAL = 2;
    private final int VERTICAL = 3;

    private Context context;
    private ArrayList<Object> items;


    public MainAdapter(Context context, ArrayList<Object> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view;
        RecyclerView.ViewHolder holder;

        switch (viewType) {
            case GRID_HORIZONTAL:
                view = inflater.inflate(R.layout.recycler_horizontal_grid, parent, false);
                holder = new GridHorizontalViewHolder(view);
                break;
            case HORIZONTAL:
                view = inflater.inflate(R.layout.recycler_horizontal, parent, false);
                holder = new HorizontalViewHolder(view);
                break;
            case VERTICAL:
                view = inflater.inflate(R.layout.recycler_vertical, parent, false);
                holder = new VerticalViewHolder(view);
                break;

            default:
                view = inflater.inflate(R.layout.recycler_horizontal_grid, parent, false);
                holder = new GridHorizontalViewHolder(view);
                break;
        }
        return holder;
    }

    //here we bind view with data according to the position that we have defined.
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder.getItemViewType() == GRID_HORIZONTAL)
            gridHorizontalView((GridHorizontalViewHolder) holder);
        if (holder.getItemViewType() == HORIZONTAL)
            horizontalView((HorizontalViewHolder) holder);
        if (holder.getItemViewType() == VERTICAL)
            verticalView((VerticalViewHolder) holder);

    }


    private void gridHorizontalView(GridHorizontalViewHolder holder) {

        RecyclerHorizontalGridAdapter gridHorizontalViewAdapter = new RecyclerHorizontalGridAdapter(getGridViewData());
        holder.recyclerViewGridHorizontal.setLayoutManager(new GridLayoutManager(context, 2, LinearLayoutManager.HORIZONTAL, false));
        holder.recyclerViewGridHorizontal.setAdapter(gridHorizontalViewAdapter);
    }

    private void horizontalView(HorizontalViewHolder holder) {

        RecyclerHorizontalAdapter horizontalViewAdapter = new RecyclerHorizontalAdapter(getMovieData());
        holder.recyclerViewHorizontal.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        holder.recyclerViewHorizontal.setAdapter(horizontalViewAdapter);
    }

    private void verticalView(VerticalViewHolder holder) {

        RecyclerVerticalAdapter verticalViewAdapter = new RecyclerVerticalAdapter(getAdvData());
        holder.recyclerViewVertical.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
        holder.recyclerViewVertical.setAdapter(verticalViewAdapter);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    //this method return the number according to the advertisement object
    @Override
    public int getItemViewType(int position) {
        if (items.get(position) instanceof ModelHorizontalGrid)
            return GRID_HORIZONTAL;
        if (items.get(position) instanceof ModelHorizontal)
            return HORIZONTAL;
        if (items.get(position) instanceof ModelVertical)
            return VERTICAL;
        return -1;

    }

    public class GridHorizontalViewHolder extends RecyclerView.ViewHolder {
        RecyclerView recyclerViewGridHorizontal;

        public GridHorizontalViewHolder(View itemView) {
            super(itemView);
            recyclerViewGridHorizontal = (RecyclerView) itemView.findViewById(R.id.recycler_view_horizontal_grid);
        }
    }

    public class HorizontalViewHolder extends RecyclerView.ViewHolder {
        RecyclerView recyclerViewHorizontal;

        public HorizontalViewHolder(View itemView) {
            super(itemView);
            recyclerViewHorizontal = (RecyclerView) itemView.findViewById(R.id.recycler_view_horizontal);
        }
    }

    public class VerticalViewHolder extends RecyclerView.ViewHolder {
        RecyclerView recyclerViewVertical;

        public VerticalViewHolder(View itemView) {
            super(itemView);
            recyclerViewVertical = (RecyclerView) itemView.findViewById(R.id.recycler_view_vertical);
        }
    }
}
