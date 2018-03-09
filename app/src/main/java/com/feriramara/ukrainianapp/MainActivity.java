package com.feriramara.ukrainianapp;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.feriramara.ukrainianapp.adapters.SectionPageAdapter;
import com.feriramara.ukrainianapp.fragments.FragmentBest;
import com.feriramara.ukrainianapp.fragments.FragmentByAuthor;
import com.feriramara.ukrainianapp.fragments.FragmentFavorites;
import com.feriramara.ukrainianapp.fragments.FragmentNew;


public class MainActivity extends AppCompatActivity {

    private SectionPageAdapter mSectionPageAdapter;
    private ViewPager mViewPager;
    SectionPageAdapter adapter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mSectionPageAdapter = new SectionPageAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.container);
        setupViewPager(mViewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

    }



    public void setupViewPager(ViewPager viewPager) {
        adapter = new SectionPageAdapter(getSupportFragmentManager());
        adapter.addFragments(new FragmentBest(), "Найкращі");
        adapter.addFragments(new FragmentByAuthor(), "Автор");
        adapter.addFragments(new FragmentNew(), "Нові");
        adapter.addFragments(new FragmentFavorites(), "Улюблені");
        viewPager.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {

        if (mViewPager.getCurrentItem() == 1) {
            mViewPager.setAdapter(adapter);
            mViewPager.setCurrentItem(1);
        } else {
            finish();
        }

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_settings) {
            Intent intent = new Intent(this, Settings.class);
            startActivity(intent);
        } else if (id == R.id.action_exit) {
            this.finishAffinity();

        }

        return super.onOptionsItemSelected(item);
    }


}
