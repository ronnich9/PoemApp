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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.feriramara.ukrainianapp.Card;
import com.feriramara.ukrainianapp.DBHelper;
import com.feriramara.ukrainianapp.R;
import com.feriramara.ukrainianapp.ScrollingActivity;
import com.feriramara.ukrainianapp.adapters.CardAdapter;

import java.util.ArrayList;


public class FragmentByAuthor extends Fragment implements CardAdapter.OnItemClickListener {

    RecyclerView mRecyclerView;
    CardAdapter mCardAdapter;
    DBHelper dbHelper;
    ArrayList<Card> mList;
    private Parcelable recyclerViewState;
    private int pozition;


    public static final String EXTRA_TEXT = "text";
    public static final String EXTRA_TITLE = "title";
    public static final String EXTRA_IMAG = "image";
    public static final String EXTRA_AUTHOR = "author";
    public static final String EXTRA_ID = "id";

    View v;
    String mString[] = {"Тарас Шевченко", "Леся Українка", "Ліна Костенко", "Іван Франко",
            "Василь Стус", "Володимир Сосюра", "Олесь Гончар", "Євген Маланюк",
            "Олександр Олесь", "Симоненко Василь", "Олена Теліга", "Максим Рильський",
            "Олег Ольжич", "Оксана Лятуринська", "Володимир Самійленко", "Юрій Тарнавський",
            "Пантелеймон Куліш", "Микола Вінграновський", "Андрій Малишко", "Олекса Стефанович",
            "Іван Драч", "Тодось Осьмачка", "Павло Тичина", "Степан Руданський", "Петро Перебийніс", "Борис Грінченко",
            "Микола Сингаївський", "Микола Хвильовий"};

    private static final String TAG = "Tab2Fragment";

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.list_view, container, false);

        final ListView mListView = v.findViewById(R.id.listview);
        mRecyclerView = v.findViewById(R.id.recyclerView_frag2);


        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, mString);
        mListView.setAdapter(arrayAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                pozition = position;

                    mRecyclerView.setVisibility(View.VISIBLE);
                    mListView.setVisibility(View.INVISIBLE);

                    loadDatabase(mString[position]);


            }
        });

        return v;
    }


    public void loadDatabase(String author) {
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mList = new ArrayList<>();
        dbHelper = new DBHelper(getContext());


        mList = dbHelper.getPoemsByAuthor(author);


        mCardAdapter = new CardAdapter(mList, getContext());
        mRecyclerView.setAdapter(mCardAdapter);
        mCardAdapter.setOnItemClickListener(this);
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


    @Override
    public void onResume() {
        super.onResume();
        loadDatabase(mString[pozition]);
        mRecyclerView.getLayoutManager().onRestoreInstanceState(recyclerViewState);//restore

    }

    @Override
    public void onPause() {
        super.onPause();
        recyclerViewState = mRecyclerView.getLayoutManager().onSaveInstanceState();//save
    }


}
