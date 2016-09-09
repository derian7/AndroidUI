package com.derian.cardsUI;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class SingleCardFragment extends Fragment {
    public static SingleCardFragment newInstance() {
        SingleCardFragment fragment = new SingleCardFragment();
        return fragment;
    }

    public SingleCardFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.movie_card_view, container, false);
        rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnSelectedMovieChangeListener listener = (OnSelectedMovieChangeListener)getActivity();

                listener.onSelectedMovieChanged(rootView, 0);
            }
        });
        return rootView;
    }


}
