package com.example.macbook.nestedrecyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.macbook.nestedrecyclerview.adapter.MainAdapter;
import com.example.macbook.nestedrecyclerview.model.ModelHorizontal;
import com.example.macbook.nestedrecyclerview.model.ModelHorizontalGrid;
import com.example.macbook.nestedrecyclerview.model.ModelVertical;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recycler_view_main)
    RecyclerView recyclerViewMain;


    private ArrayList<Object> objects = new ArrayList<>();


    //ini adalah list dari grid layout
    public static ArrayList<ModelHorizontalGrid> getGridViewData() {

        ArrayList<ModelHorizontalGrid> modelHorizontalGrids = new ArrayList<>();
        modelHorizontalGrids.add(new ModelHorizontalGrid("Kucing Gila",R.drawable.kucinggrid1));
        modelHorizontalGrids.add(new ModelHorizontalGrid("Kucing Stress",R.drawable.kucinggrid2));
        modelHorizontalGrids.add(new ModelHorizontalGrid("Kucing Sakit",R.drawable.kucinggrid2));
        modelHorizontalGrids.add(new ModelHorizontalGrid("Kucing Keren",R.drawable.kucinggrid3));
        modelHorizontalGrids.add(new ModelHorizontalGrid("Kucing Demam",R.drawable.kucinggrid3));
        modelHorizontalGrids.add(new ModelHorizontalGrid("Kucing Pilek",R.drawable.kucinggrid4));
        modelHorizontalGrids.add(new ModelHorizontalGrid("Kucing Batuk",R.drawable.kucinggrid4));
        modelHorizontalGrids.add(new ModelHorizontalGrid("Kucing Dugem",R.drawable.kucinggrid5));
        modelHorizontalGrids.add(new ModelHorizontalGrid("Kucing Dugem",R.drawable.kucinggrid5));



        return modelHorizontalGrids;
    }


    //ini adalah isi dari vertical layout
    public static ArrayList<ModelVertical> getAdvData() {
        ArrayList<ModelVertical> modelVerticals = new ArrayList<>();
        modelVerticals.add(new ModelVertical("Kucing ini adalah kucing \nsultan",R.drawable.kucing2,"Kucing Sultan"));
        modelVerticals.add(new ModelVertical("Kucing ini adalah kucing \norang",R.drawable.kucing2,"Kucing Orang"));
        modelVerticals.add(new ModelVertical("Kucing ini adalah kucing \ngembel",R.drawable.kucing2,"Kucing Gembel"));

        return modelVerticals;
    }

    //ini adalah isi dari horizontal layout

    public static ArrayList<ModelHorizontal> getMovieData(){
        ArrayList<ModelHorizontal> modelHorizontals = new ArrayList<>();
        modelHorizontals.add(new ModelHorizontal("Kucing Gila",R.drawable.kucing2));
        modelHorizontals.add(new ModelHorizontal("Kucing Miskin",R.drawable.kucing2));
        modelHorizontals.add(new ModelHorizontal("Kucing Pilek",R.drawable.kucing2));
        modelHorizontals.add(new ModelHorizontal("Kucing Galau",R.drawable.kucing2));

        return modelHorizontals;
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view_main);
        MainAdapter adapter = new MainAdapter(this, getObject());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }

    private ArrayList<Object> getObject() {
        objects.add(getGridViewData().get(0));
        objects.add(getMovieData().get(0));
        objects.add(getAdvData().get(0));
        return objects;

    }

}
