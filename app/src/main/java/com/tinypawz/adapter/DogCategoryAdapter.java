package com.tinypawz.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
        ImageView dogImgUrl;


        public MyViewHolder(View view) {
            super(view);
            dogName = (TextView) view.findViewById(R.id.tvDogName);
            dogDescription = (TextView) view.findViewById(R.id.tvDogDescription);
            dogImgUrl = (ImageView) view.findViewById(R.id.nivDogImg);
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
        holder.dogImgUrl.setImageResource(dogCategoryModel.getDogImgUrl());
        //holder.dogImgUrl.setImageUrl(dogCategoryModel.getDogImgUrl(), BaseApplication.getInstance().getImageLoader());
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public DogCategoryModel getItem(int position) {
        return categoryList.get(position);
    }


    public interface ClickListener {
        void onClick(View view, int position);

        void onLongClick(View view, int position);
    }

    public static class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {

        private GestureDetector gestureDetector;
        private DogCategoryAdapter.ClickListener clickListener;

        public RecyclerTouchListener(Context context, final RecyclerView recyclerView, final DogCategoryAdapter.ClickListener clickListener) {
            this.clickListener = clickListener;
            gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }

                @Override
                public void onLongPress(MotionEvent e) {
                    View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
                    if (child != null && clickListener != null) {
                        clickListener.onLongClick(child, recyclerView.getChildPosition(child));
                    }
                }
            });
        }


        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {

            View child = rv.findChildViewUnder(e.getX(), e.getY());
            if (child != null && clickListener != null && gestureDetector.onTouchEvent(e)) {
                clickListener.onClick(child, rv.getChildPosition(child));
            }
            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {
        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

        }
    }

}