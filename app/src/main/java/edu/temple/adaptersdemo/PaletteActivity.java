package edu.temple.adaptersdemo;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

import java.nio.file.attribute.UserPrincipalLookupService;

public class PaletteActivity extends AppCompatActivity {

    final static public String COLOR_KEY = "color_key";

    Spinner spinner;
    Boolean hasBeenSelectedOnce = false;
    //GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //6 usable items (colors)
        //8 total items (using labels of primary/secondary)
        //String myColors[] = {"Blue", "Red", "Yellow", "Green", "Magenta"};

        Resources res = this.getResources();
        String myColors[] = res.getStringArray(R.array.spinner_labels);
        final String realColors[] = res.getStringArray(R.array.spinner_values);

        spinner = findViewById(R.id.spinner);

        //ArrayAdapter adapter = new ArrayAdapter(PaletteActivity.this, android.R.layout.simple_dropdown_item_1line, myColors);

        ColorAdapter adapter = new ColorAdapter(this, myColors, realColors);


        //ArrayAdapter adapter = new BasicColorAdapter(PaletteActivity.this, android.R.layout.simple_dropdown_item_1line, myColors);


        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (hasBeenSelectedOnce) {
                    //String color = ((TextView) view).getText().toString();
                    int index = spinner.getSelectedItemPosition();
                    String color = realColors[index];

                    parent.setBackgroundColor(Color.parseColor(color));

                    Intent startCanvasIntent = new Intent(PaletteActivity.this, CanvasActivity.class);
                    startCanvasIntent.putExtra(COLOR_KEY, color);
                    startActivity(startCanvasIntent);
                }
                else hasBeenSelectedOnce = true;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        /*
        int size = 4;
        CheckerAdapter adapter = new CheckerAdapter(this, size);

        gridView .setStretchMode(GridView.NO_STRETCH);

        gridView.setNumColumns(size);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        }); */

    }
}
