package com.tinypawz.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;
import com.tinypawz.R;
import com.tinypawz.helper.BaseApplication;
import com.tinypawz.model.DogCategoryModel;

import java.util.List;

public class DogCategoryAdapter extends RecyclerView.Adapter<DogCategoryAdapter.MyViewHolder> {

    private List<DogCategoryModel> categoryList;
    DogCategoryModel dogCategoryModel;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView dogName, dogDescription;
        NetworkImageView dogImgUrl;


        public MyViewHolder(View view) {
            super(view);
            dogName = (TextView) view.findViewById(R.id.tvDogName);
            dogDescription = (TextView) view.findViewById(R.id.tvDogDescription);
            dogImgUrl = (NetworkImageView) view.findViewById(R.id.nivDogImg);
        }
    }


    public DogCategoryAdapter(List<DogCategoryModel> categoryList) {
        this.categoryList = categoryList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_layout, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        DogCategoryModel dogCategoryModel = categoryList.get(position);
        holder.dogName.setText(dogCategoryModel.getDogName());
        holder.dogDescription.setText(dogCategoryModel.getDogDescription());
        holder.dogImgUrl.setImageUrl(dogCategoryModel.getDogImgUrl(), BaseApplication.getInstance().getImageLoader());
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }
}