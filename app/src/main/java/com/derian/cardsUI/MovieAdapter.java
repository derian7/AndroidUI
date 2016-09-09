package com.derian.cardsUI;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {
    private String[] mTitles;
    private int[] mImageResourceIds;

    public MovieAdapter(String[] titles, int[] imageResourceIds) {
        mTitles = titles;
        mImageResourceIds = imageResourceIds;
    }

    @Override
    public MovieAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                      int viewType) {
        View rootView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_card_view, parent, false);

        ViewHolder vh = new ViewHolder(rootView);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mTextView.setText(mTitles[position]);
        holder.mTextView.setTransitionName("title_text_" + position);
        holder.mImageView.setImageResource(mImageResourceIds[position]);
        holder.mImageView.setTransitionName("movie_image_" + position);

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mTitles.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView;
        public ImageView mImageView;
        public ViewHolder(View v) {
            super(v);
            mTextView = (TextView)v.findViewById(R.id.movieTitle);
            mImageView = (ImageView)v.findViewById(R.id.topImage);
        }
    }


}