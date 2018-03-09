package com.feriramara.ukrainianapp.fragments;

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

import com.feriramara.ukrainianapp.Card;
import com.feriramara.ukrainianapp.DBHelper;
import com.feriramara.ukrainianapp.R;
import com.feriramara.ukrainianapp.ScrollingActivity;
import com.feriramara.ukrainianapp.adapters.CardAdapter;

import java.util.ArrayList;



public class FragmentFavorites extends Fragment implements CardAdapter.OnItemClickListener{

    RecyclerView mRecyclerView;
    CardAdapter mCardAdapter;
    DBHelper dbHelper;
    ArrayList<Card> mList;
    private Parcelable recyclerViewState;

    public static final String EXTRA_TEXT = "text";
    public static final String EXTRA_TITLE = "title";
    public static final String EXTRA_IMAG = "image";
    public static final String EXTRA_AUTHOR = "author";
    public static final String EXTRA_ID = "id";

    private static final String TAG = "Tab4Fragment";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.tab4_fragment, container, false);
        mRecyclerView = v.findViewById(R.id.recyclerView4);

        loadDatabase();
        return v;
    }

    public void loadDatabase() {
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mList = new ArrayList<>();
        dbHelper = new DBHelper(getContext());

        mList = dbHelper.getAllFavorites();

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
