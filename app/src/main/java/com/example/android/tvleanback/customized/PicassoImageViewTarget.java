package com.example.android.tvleanback.customized;


import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

public class PicassoImageViewTarget implements Target {

    private static final String TAG = PicassoImageViewTarget.class.getSimpleName();
    private ImageView imageView;


    public PicassoImageViewTarget(ImageView imageView) {
        this.imageView = imageView;
    }

    @Override
    public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
        Drawable bitmapDrawable = new BitmapDrawable(imageView.getContext().getResources(), bitmap);
        imageView.setImageDrawable(bitmapDrawable);
    }

    @Override
    public void onBitmapFailed(Drawable errorDrawable) {
        Log.e(TAG, "failed to load image. Going to use the errorDrawable");
        imageView.setImageDrawable(errorDrawable);
    }

    @Override
    public void onPrepareLoad(Drawable placeHolderDrawable) {

    }
}
