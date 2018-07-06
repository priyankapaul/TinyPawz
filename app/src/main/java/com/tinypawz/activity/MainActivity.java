package com.tinypawz.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.tinypawz.R;
import com.tinypawz.adapter.DogCategoryAdapter;
import com.tinypawz.model.DogCategoryModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView categoryRecyclerView;
    private DogCategoryAdapter mAdapter;
    private ArrayList<DogCategoryModel> movieList = new ArrayList<>();
    DogCategoryModel dogCategoryModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        categoryRecyclerView = findViewById(R.id.category_listView);

        prepareData();

        mAdapter = new DogCategoryAdapter(movieList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        categoryRecyclerView.setLayoutManager(mLayoutManager);
        categoryRecyclerView.setItemAnimator(new DefaultItemAnimator());
        categoryRecyclerView.setAdapter(mAdapter);
       // mAdapter.notifyDataSetChanged();
    }

    private void prepareData() {
        dogCategoryModel = new DogCategoryModel("Dog Food", "description", "http://runsickcattle.com/data/out/68/703565.gif");
        movieList.add(dogCategoryModel);

        dogCategoryModel = new DogCategoryModel("Dog Accessories", "description", "http://runsickcattle.com/data/out/68/703565.gif");
        movieList.add(dogCategoryModel);

        dogCategoryModel = new DogCategoryModel("Dog Grooming", "description", "http://runsickcattle.com/data/out/68/703565.gif");
        movieList.add(dogCategoryModel);

        dogCategoryModel = new DogCategoryModel("Dog Supplies", "description", "http://runsickcattle.com/data/out/68/703565.gif");
        movieList.add(dogCategoryModel);



    }
}
