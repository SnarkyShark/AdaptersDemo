package edu.temple.adaptersdemo;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CheckerAdapter extends BaseAdapter {

    Context context;
    int size;

    public CheckerAdapter(Context context, int size) {
        this.context = context;
        this.size = size;
    }

    @Override
    public int getCount() {
        return size * size;
    }

    @Override   //uses getCount()
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View checker = new TextView(context);

        ((TextView) checker).setText(String.valueOf(position));
        ((TextView) checker).setTextSize(28);

        checker.setLayoutParams(new ViewGroup.LayoutParams(120, 120));

        checker.setBackgroundColor(Color.GRAY);
        //checker.setPadding(5,5,5,5);

        return checker;
    }
}
