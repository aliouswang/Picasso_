package com.example.aliouswang.picasso_;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by aliouswang on 2017/9/26.
 */

public class ImageAdapter extends RecyclerView.Adapter<DefaultViewHolder>{

    @Override
    public DefaultViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_image_adapter, parent, false);
        return new DefaultViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DefaultViewHolder holder, int position) {
        holder.loadImage(R.id.imageView, ImageConstant.images[position]);
    }

    @Override
    public int getItemCount() {
        return ImageConstant.images.length;
    }
}
