package com.derian.cardsUI;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.transition.ChangeBounds;
import android.transition.ChangeTransform;
import android.transition.Slide;
import android.transition.TransitionSet;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity
    implements OnSelectedMovieChangeListener
{
    String[] mTitles;
    String[] mDescriptions;

    int[] mImageLargeResourceIds = {
            R.drawable.antman_large,
            R.drawable.captainamerica_large,
            R.drawable.doctorstrange_large,
            R.drawable.avengersaou_large
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTitles = getResources().getStringArray(R.array.movie_titles);
        mDescriptions = getResources().getStringArray(R.array.movie_descriptions);

        // Create the Fragment and add
        Slide slideLeftTransition = new Slide(Gravity.LEFT);
        slideLeftTransition.setDuration(500);

        MovieListFragment listFragment = MovieListFragment.newInstance();
//        SingleCardFragment listFragment = SingleCardFragment.newInstance();
        listFragment.setExitTransition(slideLeftTransition);

        FragmentManager fm = getFragmentManager();
        fm.beginTransaction()
                .add(R.id.layoutRoot, listFragment)
                .commit();
    }

    @Override
    public void onSelectedMovieChanged(View view, int movieIndex) {

        TextView titleTextView = (TextView)view.findViewById(R.id.movieTitle);
        ImageView movieImageView = (ImageView)view.findViewById(R.id.topImage);

        Slide slideBottomTransition = new Slide(Gravity.BOTTOM);
        slideBottomTransition.setDuration(500);

        ChangeBounds changeBoundsTransition = new ChangeBounds();

        ChangeTransform changeTransformTransition = new ChangeTransform();

        TransitionSet transitionSet = new TransitionSet();
        transitionSet.addTransition(changeBoundsTransition);
        transitionSet.addTransition(changeTransformTransition);
        transitionSet.setDuration(500);

        MovieDescFragment movieDescFragment =
                MovieDescFragment.newInstance(mTitles[movieIndex], mDescriptions[movieIndex],
                        mImageLargeResourceIds[movieIndex], movieIndex);
        movieDescFragment.setEnterTransition(slideBottomTransition);
        movieDescFragment.setAllowEnterTransitionOverlap(false);
        movieDescFragment.setSharedElementEnterTransition(transitionSet);


        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.layoutRoot, movieDescFragment)
                .addSharedElement(movieImageView, "movie_image_" + movieIndex)
                .addSharedElement(titleTextView, "title_text_" + movieIndex)
                .addToBackStack(null)
                .commit();

    }

}
