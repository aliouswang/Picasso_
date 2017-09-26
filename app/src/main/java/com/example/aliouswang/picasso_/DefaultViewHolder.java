package com.example.aliouswang.picasso_;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.example.aliouswang.library.VanGogh;

/**
 * Created by aliouswang on 2017/9/26.
 */

public class DefaultViewHolder extends RecyclerView.ViewHolder{

    public DefaultViewHolder(View itemView) {
        super(itemView);
    }

    public DefaultViewHolder loadImage(int imageViewId, String imageUrl) {
        ImageView imageView = itemView.findViewById(imageViewId);
        VanGogh.with(itemView.getContext())
                .load(imageUrl)
                .placeHolder(R.drawable.default_img_square_big)
                .into(imageView);
        return this;
    }

}
