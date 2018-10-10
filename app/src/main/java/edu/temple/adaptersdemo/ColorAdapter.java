package edu.temple.adaptersdemo;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ColorAdapter extends BaseAdapter {

    private Context context;
    private String myData[];
    private String realData[];

    public ColorAdapter(Context context, String myData[], String realData[]) {
        this.context = context;
        this.myData = myData;
        this.realData = realData;
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

        textView.setBackgroundColor(Color.parseColor(realData[position]));

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
