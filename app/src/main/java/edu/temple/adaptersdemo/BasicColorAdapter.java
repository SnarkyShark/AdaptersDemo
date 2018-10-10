package edu.temple.adaptersdemo;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

//this is simpler than ColorAdapter
//much faster, since the only change I want to make is changing the TextView color
public class BasicColorAdapter extends ArrayAdapter {

    public BasicColorAdapter(@NonNull Context context, int resource, String [] objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        TextView textView = (TextView) super.getView(position, convertView, parent);
        textView.setBackgroundColor(Color.parseColor((String) getItem(position)));

        return textView;
    }
}
