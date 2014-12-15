package com.example.android.tvleanback.customized;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v17.leanback.widget.Presenter;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.tvleanback.Movie;
import com.example.android.tvleanback.R;
import com.example.android.tvleanback.Utils;
import com.squareup.picasso.Picasso;

public class RatingCardViewHolder extends Presenter.ViewHolder {
    private final Drawable defaultCardImage;
    private final PicassoImageViewTarget imageCardViewTarget;
    private Movie movie;

    public RatingCardViewHolder(View view) {
        super(view);
        defaultCardImage = view.getContext().getResources().getDrawable(R.drawable.movie);

        ImageView cardImageView = (ImageView) view.findViewById(R.id.card_image);
        imageCardViewTarget = new PicassoImageViewTarget(cardImageView);
    }

    public void setMovie(Movie movie) {
        this.movie = movie;

        TextView titleView = (TextView) view.findViewById(R.id.card_title);
        titleView.setText(movie.getTitle());

        for (int i = 0; i < Movie.MAX_RATING; i++) {
            View ratingView = view.findViewWithTag("rating_" + i);
            if (movie.getRating() > i) {
                ratingView.setVisibility(View.VISIBLE);
            } else {
                ratingView.setVisibility(View.INVISIBLE);
            }
        }
        Context ctx = view.getContext();
        Picasso.with(ctx)
                .load(movie.getCardImageUrl())
                .resize(Utils.convertDpToPixel(ctx, 240),
                        Utils.convertDpToPixel(ctx, 180))
                .error(defaultCardImage)
                .into(imageCardViewTarget);
    }
}
