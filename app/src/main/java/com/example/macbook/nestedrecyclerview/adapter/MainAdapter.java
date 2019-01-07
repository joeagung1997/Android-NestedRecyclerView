package com.example.macbook.nestedrecyclerview.adapter;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ethanhua.skeleton.Skeleton;
import com.ethanhua.skeleton.SkeletonScreen;
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
                view = inflater.inflate(R.layout.viewpager_grid, parent, false);
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

        /*ini buat menampilkan ViewPagernya */
        PagerGridAdapter pagerGridAdapter = new PagerGridAdapter(context,getGridViewData());
        holder.pager.setAdapter(pagerGridAdapter);

        /*ini buat menampilkan DotIndicatornya */
        holder.tabLayout.setupWithViewPager(holder.pager,true);
    }

    private void horizontalView(HorizontalViewHolder holder) {

        RecyclerHorizontalAdapter horizontalViewAdapter = new RecyclerHorizontalAdapter(getMovieData());
        holder.recyclerViewHorizontal.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        holder.recyclerViewHorizontal.setAdapter(horizontalViewAdapter);

        /* Ini fungsi Snap Helpernya */
        SnapHelper snapHelper = new LinearSnapHelper();
        snapHelper.attachToRecyclerView(holder.recyclerViewHorizontal);

        /* Ini buat menampilkan SkeletonScreenya  */
        final SkeletonScreen skeletonScreen = Skeleton.bind(holder.recyclerViewHorizontal)
                .adapter(horizontalViewAdapter)
                .shimmer(false)
                .angle(20)
                .frozen(false)
                .duration(1200)
                .count(20)
                .load(R.layout.item_skeleton_horizontal)
                .show(); //default count is 10

        holder.recyclerViewHorizontal.postDelayed(new Runnable() {
            @Override
            public void run() {
                skeletonScreen.hide();
            }
        }, 3000);
        return;


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
        ViewPager pager;
        TabLayout tabLayout;

        public GridHorizontalViewHolder(View itemView) {
            super(itemView);
            pager = (ViewPager)itemView.findViewById(R.id.pager_grid);
            tabLayout = (TabLayout)itemView.findViewById(R.id.tabDots);
            recyclerViewGridHorizontal = (RecyclerView) itemView.findViewById(R.id.rvHorizontalGrid);
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
