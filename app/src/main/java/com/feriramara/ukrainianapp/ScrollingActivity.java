package com.feriramara.ukrainianapp;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import static com.feriramara.ukrainianapp.Tab1fragment.EXTRA_AUTHOR;
import static com.feriramara.ukrainianapp.Tab1fragment.EXTRA_ID;
import static com.feriramara.ukrainianapp.Tab1fragment.EXTRA_IMAG;
import static com.feriramara.ukrainianapp.Tab1fragment.EXTRA_TEXT;
import static com.feriramara.ukrainianapp.Tab1fragment.EXTRA_TITLE;

public class ScrollingActivity extends AppCompatActivity {

    TextView mTextView;
    private int imgBIG;
    DBHelper localDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);


        localDB = new DBHelper(this);
        mTextView = findViewById(R.id.content_textview);

        AppBarLayout layout = (AppBarLayout) findViewById(R.id.app_bar);

        final Intent intent = getIntent();
        String text = intent.getStringExtra(EXTRA_TEXT);
        String title = intent.getStringExtra(EXTRA_TITLE);
        String author = intent.getStringExtra(EXTRA_AUTHOR);
        final int id = intent.getIntExtra(EXTRA_ID, 0);
        final int favor = intent.getIntExtra(EXTRA_IMAG, 0);

        getSupportFragmentManager().addOnBackStackChangedListener(
                new FragmentManager.OnBackStackChangedListener() {
                    public void onBackStackChanged() {
                        finish();
                    }
                });




        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!localDB.isFavorite(id)) {
                    localDB.addToFavorites(id);
                    fab.setImageResource(R.drawable.ic_favorite_black_24dp);
                    Snackbar.make(view, "Додано в Улюблені!", Snackbar.LENGTH_SHORT)
                            .setAction("Action", null).show();
                } else {
                    localDB.removeFromFavorites(id);
                    fab.setImageResource(R.drawable.ic_favorite_border_black_24dp);
                    Snackbar.make(view, "Видалено з Улюблених!", Snackbar.LENGTH_SHORT)
                            .setAction("Action", null).show();
                }
            }
        });

        if(favor == 0) {
            fab.setImageResource(R.drawable.ic_favorite_border_black_24dp);
        } else {
            fab.setImageResource(R.drawable.ic_favorite_black_24dp);
        }



        switch (author) {
            case "Леся Українка":
                break;
            case "Тарас Шевченко":
                imgBIG = R.drawable.taras2;
                break;
            case "Ліна Костенко":
                break;
            case "Василь Стус":
                break;
            case "Іван Франко":
                break;
            default:
                imgBIG = R.drawable.ic_launcher_foreground;
                break;


        }


        mTextView.setText(text);
        mTextView.setTextColor(Color.parseColor("#282828"));
        mTextView.setTextSize(17);
        toolbar.setTitle(title);
        layout.setBackgroundResource(imgBIG);

    }



}
