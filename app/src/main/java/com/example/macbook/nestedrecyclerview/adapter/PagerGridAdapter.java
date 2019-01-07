package com.example.macbook.nestedrecyclerview.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.ethanhua.skeleton.Skeleton;
import com.ethanhua.skeleton.SkeletonScreen;
import com.example.macbook.nestedrecyclerview.R;
import com.example.macbook.nestedrecyclerview.model.ModelHorizontalGrid;

import java.util.ArrayList;

public class PagerGridAdapter extends PagerAdapter {

    private Context context;

    /* Buat list item page 1 dan 2 di viewpager*/
    private ArrayList<ModelHorizontalGrid> list1 = new ArrayList<>();
    private ArrayList<ModelHorizontalGrid> list2 = new ArrayList<>();

    private RecyclerHorizontalGridAdapter[] listAdapter = new RecyclerHorizontalGridAdapter[] {
            new RecyclerHorizontalGridAdapter(list1),
            new RecyclerHorizontalGridAdapter(list2)

    };

    public PagerGridAdapter (Context context , ArrayList<ModelHorizontalGrid> list) {
        this.context = context;

        /* Nambahin berdasarkan jumlah item
         * page pertama urutan 0 sampe 6 karena colomnya ada 3
         * page kedua urutan 6 sampe jumlah total item */

            list1.addAll(list.subList(0,6));
            list2.addAll(list.subList(6,list.size()));
    }

    @Override
    public int getCount() {
        return listAdapter.length;
    }

    @Override
    public boolean isViewFromObject(View view,Object o) {
        return view == o;
    }


    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        /* Ngambil layout yang isi nya recyclerview*/
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_horizontal_grid,container,false);

        RecyclerView recyclerView = view.findViewById(R.id.rvHorizontalGrid);
        recyclerView.setLayoutManager(new GridLayoutManager( context,3));


        /* Setting adapter tiap page*/
        recyclerView.setAdapter(listAdapter[position]);

        /* disini buat menampilkan SkeletonScreen   */
        final SkeletonScreen skeletonScreen = Skeleton.bind(recyclerView)
                .adapter(listAdapter[position])
                .shimmer(true)
                .angle(7)
                .frozen(false)
                .duration(1200)
                .count(6)
                .load(R.layout.item_skeleton_grid)
                .show(); //default count is 10

        recyclerView.postDelayed(new Runnable() {
            @Override
            public void run() {
                skeletonScreen.hide();
            }
        }, 3000);

        container.addView(view);

        return view;

    }

    @Override
    public void destroyItem(ViewGroup container, int position,Object object) {
        /* object cast ke LinearLayout karena parent di recycler_horizontal_grid.xml
         * adalah LinearLayout */
            container.removeView((LinearLayout) object);
        }
}
