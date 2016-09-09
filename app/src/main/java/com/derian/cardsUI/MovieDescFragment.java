package com.derian.cardsUI;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class MovieDescFragment extends Fragment {

    private static final String ARG_TITLE = "title";
    private static final String ARG_DESCRIPTION = "description";
    private static final String ARG_IMAGE_ID = "image id";
    private static final String ARG_POSITION = "position";

    public static MovieDescFragment newInstance(String title, String description,
                                                int imageResourceId, int position) {
        MovieDescFragment fragment = new MovieDescFragment();
        Bundle args = new Bundle();
        args.putString(ARG_TITLE, title);
        args.putString(ARG_DESCRIPTION, description);
        args.putInt(ARG_IMAGE_ID, imageResourceId);
        args.putInt(ARG_POSITION, position);
        fragment.setArguments(args);
        return fragment;
    }

    public MovieDescFragment() {
        // Required empty public constructor
    }

     @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         View rootView = inflater.inflate(R.layout.fragment_movie_desc, container, false);

         TextView movieTitleView = (TextView)rootView.findViewById(R.id.movieTitle);
         TextView movieDescriptionView = (TextView)rootView.findViewById(R.id.movieDescription);
         ImageView topImageView = (ImageView)rootView.findViewById(R.id.topImage);

         Bundle args = getArguments();
         int position = args.getInt(ARG_POSITION);

         movieTitleView.setText(args.getString(ARG_TITLE));
         movieTitleView.setTransitionName("title_text_" + position);
         movieDescriptionView.setText(args.getString(ARG_DESCRIPTION));
         topImageView.setImageResource(args.getInt(ARG_IMAGE_ID));
         topImageView.setTransitionName("movie_image_" + position);

         return rootView;
    }

}
