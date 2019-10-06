package com.example.mjfan.utils;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.example.mjfan.R;

public class BindingUtils {

    @BindingAdapter("bind:imageUrl")
    public static void loadImage(AppCompatImageView imageView, String url) {
        Glide.with(imageView.getContext())
                .load(url)
                .circleCrop()
                .placeholder(R.mipmap.ic_launcher)
                .into(imageView);
    }
}
