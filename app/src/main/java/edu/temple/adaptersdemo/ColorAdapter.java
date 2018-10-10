package edu.temple.adaptersdemo;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ColorAdapter extends BaseAdapter {

    Context context;
    String myData[];

    public ColorAdapter(Context context, String myData[]) {
        this.context = context;
        this.myData = myData;
    }

    @Override
    public int getCount() {
        return myData.length;   //2 being the labels of primary & secondary
    }

    @Override   //uses getCount()
    public Object getItem(int position) {
        return myData[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        TextView textView = new TextView(context);

        textView.setText(myData[position]);
        textView.setTextSize(22);

        textView.setBackgroundColor(Color.parseColor(myData[position]));

        return textView;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        //return super.getDropDownView(position, convertView, parent);
        TextView v = (TextView) getView(position, convertView, parent);

        v.setTextSize(48);

        return v;
    }
}
