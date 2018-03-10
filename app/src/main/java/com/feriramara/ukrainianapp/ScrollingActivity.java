package com.feriramara.ukrainianapp;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import static com.feriramara.ukrainianapp.fragments.FragmentBest.EXTRA_AUTHOR;
import static com.feriramara.ukrainianapp.fragments.FragmentBest.EXTRA_ID;
import static com.feriramara.ukrainianapp.fragments.FragmentBest.EXTRA_IMAG;
import static com.feriramara.ukrainianapp.fragments.FragmentBest.EXTRA_TEXT;
import static com.feriramara.ukrainianapp.fragments.FragmentBest.EXTRA_TITLE;

public class ScrollingActivity extends AppCompatActivity {

    TextView mTextView;
    private int imgBIG;
    DBHelper localDB;
    Context context;

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
                imgBIG = R.drawable.lesa2;
                break;
            case "Тарас Шевченко":
                imgBIG = R.drawable.taras2;
                break;
            case "Ліна Костенко":
                imgBIG = R.drawable.lina2;
                break;
            case "Василь Стус":
                imgBIG = R.drawable.stus2;
                break;
            case "Іван Франко":
                imgBIG = R.drawable.franko2;
                break;
            case "Андрій Малишко":
                imgBIG = R.drawable.andrii2;
                break;
            case "Борис Грінченко":
                imgBIG = R.drawable.boris2;
                break;
            case "Євген Маланюк":
                imgBIG = R.drawable.malanjuk2;
                break;
            case "Іван Драч":
                imgBIG = R.drawable.drach2;
                break;
            case "Микола Хвильовий":
                imgBIG = R.drawable.mykola2;
                break;
            case "Микола Сингаївський":
                imgBIG = R.drawable.syngajivskyj2;
                break;
            case "Микола Вінграновський":
                imgBIG = R.drawable.vingranovsky2;
                break;
            case "Олег Ольжич":
                imgBIG = R.drawable.olzhych2;
                break;
            case "Олена Теліга":
                imgBIG = R.drawable.teliga2;
                break;
            case "Олесь Гончар":
                imgBIG = R.drawable.gonchar2;
                break;
            case "Олекса Стефанович":
                imgBIG = R.drawable.olexa2;
                break;
            case "Олександр Олесь":
                imgBIG = R.drawable.oles2;
                break;
            case "Оксана Лятуринська":
                imgBIG = R.drawable.oxana2;
                break;
            case "Пантелеймон Куліш":
                imgBIG = R.drawable.kulish2;
                break;
            case "Павло Тичина":
                imgBIG = R.drawable.pavlo2;
                break;
            case "Петро Перебийніс":
                imgBIG = R.drawable.petro2;
                break;
            case "Максим Рильський":
                imgBIG = R.drawable.maxim2;
                break;
            case "Степан Руданський":
                imgBIG = R.drawable.stepan2;
                break;
            case "Тодось Осьмачка":
                imgBIG = R.drawable.osmachka2;
                break;
            case "Симоненко Василь":
                imgBIG = R.drawable.simonenko2;
                break;
            case "Володимир Самійленко":
                imgBIG = R.drawable.samiylenko2;
                break;
            case "Володимир Сосюра":
                imgBIG = R.drawable.sosyura2;
                break;
            case "Юрій Тарнавський":
                imgBIG = R.drawable.tarnavskiy2;
                break;
            default:
                imgBIG = R.drawable.default_big;
                break;


        }


        mTextView.setText(text);
        mTextView.setTextColor(Color.parseColor("#282828"));
        toolbar.setTitle(title);
        layout.setBackgroundResource(imgBIG);

    }


}
