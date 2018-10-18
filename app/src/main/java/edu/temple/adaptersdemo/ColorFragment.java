package edu.temple.adaptersdemo;


import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ColorFragment extends Fragment {

    ListView listView;
    Context parent_context;
    String color;

    public ColorFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        this.parent_context = context;     // the right way to get context

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_color, container, false);
        listView = v.findViewById(R.id.listView);

        listView.setAdapter(new ColorAdapter(parent_context, parent_context.getResources().getStringArray(R.array.spinner_labels),
                parent_context.getResources().getStringArray(R.array.spinner_values)));

        // getting the color string value
        Resources res = getResources();
        final String realColors[] = res.getStringArray(R.array.spinner_values);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parentView, View view, int position, long id) {
                color = realColors[position];
                Log.d("tag","got here");
                ((GetColorInterface) parent_context).colorSelected(color);
            }
        });

        return v;
    }

    interface GetColorInterface {
        void colorSelected(String color);
    }

}
