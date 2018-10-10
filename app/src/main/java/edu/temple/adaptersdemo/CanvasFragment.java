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

    public static String COLOR_KEY = "color";
    int color;

    public CanvasFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // example of grabbing resources: String[] values = context.getResources().getStringArray();

        Bundle bundle = getArguments(); // always returns whatever arguments were used to create the fragment (this is the proper place, in onCreate)

        this.color = bundle.getInt(COLOR_KEY);  // setting the color
    }

    public static CanvasFragment newInstance(int color){
        // Creates an instance of the defined fragments
        CanvasFragment colorFragment = new CanvasFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(CanvasFragment.COLOR_KEY, color);
        colorFragment.setArguments(bundle);

        return colorFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // intercept the view & inflate it
        final View v =  inflater.inflate(R.layout.fragment_canvas, container, false);

        v.setBackgroundColor(color);

        return v;
    }

}
