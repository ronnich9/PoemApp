package com.feriramara.ukrainianapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.feriramara.ukrainianapp.adapters.CardAdapter;

import java.util.ArrayList;

/**
 * Created by Alex on 21.02.2018.
 */

public class Tab1fragment extends Fragment implements CardAdapter.OnItemClickListener {

    RecyclerView mRecyclerView;
    CardAdapter mCardAdapter;
    DBHelper dbHelper;
    ArrayList<Card> mList;
    RecyclerView.LayoutManager mLayoutManager;
    ListView mListView;
    private Parcelable recyclerViewState;

    private static final String TAG = "Tab1Fragment";

    public static final String EXTRA_TEXT = "text";
    public static final String EXTRA_TITLE = "title";
    public static final String EXTRA_IMAG = "image";
    public static final String EXTRA_AUTHOR = "author";
    public static final String EXTRA_ID = "id";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.tab1_fragment, container, false);
        mRecyclerView = v.findViewById(R.id.recyclerView);

        loadDatabase();

        return v;


    }

    public void loadDatabase() {
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mList = new ArrayList<>();
        dbHelper = new DBHelper(getContext());

        mList = dbHelper.getAllPoems();

        mCardAdapter = new CardAdapter(mList, getContext());
        mRecyclerView.setAdapter(mCardAdapter);
        mCardAdapter.setOnItemClickListener(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        loadDatabase();
        mRecyclerView.getLayoutManager().onRestoreInstanceState(recyclerViewState);//restore

    }

    @Override
    public void onPause() {
        super.onPause();
        recyclerViewState = mRecyclerView.getLayoutManager().onSaveInstanceState();//save
    }

//    @Override
//    public void onSaveInstanceState(Bundle savedInstanceState) {
//        super.onSaveInstanceState(savedInstanceState);
//        mRecyclerView = mLayoutManager.onSaveInstanceState();
//    }



    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(getActivity(), ScrollingActivity.class);
        Card card = mList.get(position);

        intent.putExtra(EXTRA_ID, card.getId());
        intent.putExtra(EXTRA_TEXT, card.getText());
        intent.putExtra(EXTRA_TITLE, card.getPoetryName());
        intent.putExtra(EXTRA_IMAG, card.getFavorites());
        intent.putExtra(EXTRA_AUTHOR, card.getAuthorName());
        startActivity(intent);

    }
}


