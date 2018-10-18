package edu.temple.adaptersdemo;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 */
public class CanvasFragment extends Fragment {

    View background;
    public static final String COLOR_KEY = "color";
    int color;

    public CanvasFragment() {
        // Required empty public constructor
    }

    public static CanvasFragment newInstance(int color){
        CanvasFragment colorFragment = new CanvasFragment();

        Bundle bundle = new Bundle();
        bundle.putInt(CanvasFragment.COLOR_KEY, color);

        colorFragment.setArguments(bundle);

        return colorFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null)
            this.color = getArguments().getInt(COLOR_KEY);  // setting the color
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // intercept the view & inflate it
        View v =  inflater.inflate(R.layout.fragment_canvas, container, false);
        background = v.findViewById(R.id.background);

        background.setBackgroundColor(color);

        return v;
    }

}
