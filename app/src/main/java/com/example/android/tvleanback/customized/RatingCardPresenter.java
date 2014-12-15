package com.example.android.tvleanback.customized;

import android.support.v17.leanback.widget.Presenter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.tvleanback.Movie;
import com.example.android.tvleanback.R;

public class RatingCardPresenter extends Presenter {

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.rating_movie_card, null);
        view.setFocusable(true);
        view.setFocusableInTouchMode(true);
        return new RatingCardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, Object o) {
        View rootView = viewHolder.view;
        ((RatingCardViewHolder)viewHolder).setMovie((Movie)o);
    }

    @Override
    public void onUnbindViewHolder(ViewHolder viewHolder) {
    }
}
