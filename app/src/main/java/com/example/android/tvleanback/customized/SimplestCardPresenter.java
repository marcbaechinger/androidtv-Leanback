package com.example.android.tvleanback.customized;

import android.graphics.Color;
import android.support.v17.leanback.widget.Presenter;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.tvleanback.Movie;

/**
 * Created by bachinger on 12/15/14.
 */
public class SimplestCardPresenter extends Presenter {

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        TextView textView = new TextView(viewGroup.getContext());
        textView.setFocusable(true);
        textView.setFocusableInTouchMode(true);
        textView.setBackgroundColor(Color.YELLOW);
        textView.setGravity(Gravity.CENTER);
        textView.setTextColor(Color.rgb(30, 30, 30));
        textView.setLayoutParams(new ViewGroup.LayoutParams(340, 340));
        return new ViewHolder(textView);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, Object o) {
        Movie movie = (Movie)o;
        TextView textView = (TextView) viewHolder.view;
        textView.setText(movie.getTitle());
    }

    @Override
    public void onUnbindViewHolder(ViewHolder viewHolder) {

    }
}
