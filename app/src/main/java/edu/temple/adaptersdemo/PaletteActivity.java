package edu.temple.adaptersdemo;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

import java.nio.file.attribute.UserPrincipalLookupService;

public class PaletteActivity extends AppCompatActivity implements ColorFragment.GetColorInterface {

    final static public String COLOR_KEY = "color_key";
    FragmentManager fm;
    boolean landOrTablet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        landOrTablet = findViewById(R.id.container_2) != null;

        fm = getSupportFragmentManager();

        fm.beginTransaction()
                .replace(R.id.container_1, new ColorFragment())
                .commit();
    }

    @Override
    public void colorSelected(String color) {

        CanvasFragment cf = CanvasFragment.newInstance(Color.parseColor(color));

        fm.beginTransaction()
                .replace(landOrTablet ? R.id.container_2 : R.id.container_1, cf)
                .addToBackStack(null)
                .commit();
    }
}
