package com.feriramara.ukrainianapp;

import android.os.Bundle;
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
import android.widget.Toast;

import com.feriramara.ukrainianapp.adapters.CardAdapter;
import com.feriramara.ukrainianapp.adapters.CardAdapterByAuthor;

import java.util.ArrayList;

/**
 * Created by Alex on 21.02.2018.
 */

public class Tab2fragment extends Fragment implements CardAdapter.OnItemClickListener {

    RecyclerView mRecyclerView;
    CardAdapter mCardAdapter;
    DBHelper dbHelper;
    ArrayList<Card> mList;
    RecyclerView.LayoutManager mLayoutManager;

    View v;

    String mString[] = {"Тарас Шевченко", "Леся Українка", "Ліна Костенко", "Іван Франко",
            "Василь Стус", "Володимир Сосюра", "Олесь Гончар", "Євген Маланюк",
            "Олександр Олесь", "Василь Симоненко", "Олена Теліга", "Максим Рильський", "Руданський Степан",
            "Олег Ольжич", "Оксана Лятуринська", "Володимир Самійленко", "Юрій Тарнавський",
            "Пантелеймон Куліш", "Микола Вінграновський", "Андрій Малишко", "Олекса Стефанович",
            "Іван Драч", "Тодось Осьмачка", "Павло Тичина", "Степан Руданський", "Петро Перебийніс", "Борис Грінченко",
            "Сингаївський Микола", "Антонич Богдан-Ігор"};

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
                if (position == 0) {
                    Toast.makeText(getContext(), "You ckicked: " + mString[0], Toast.LENGTH_SHORT).show();
                    loadDatabase();
                    mRecyclerView.setVisibility(View.VISIBLE);
                    mListView.setVisibility(View.INVISIBLE);

                }
            }
        });

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
    public void onItemClick(int position) {

    }



//    @Override
//    public void onResume() {
//        super.onResume();
////        loadDatabase();
//    }

//    @Override
//    public void onItemClick(int position) {
//
//    }

//    public void loadDatabase() {
//        mRecyclerView.setHasFixedSize(true);
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
//        mList = new ArrayList<>();
//        dbHelper = new DBHelper(getContext());
//
//
////        mList = dbHelper.getAllFavorites();
//        mList = dbHelper.getCardsByAuthor("Тарас Шевченко");
//
//
//
////        mCardAdapter = new CardAdapter(mList, getContext());
//        mCardAdapter = new CardAdapterByAuthor(mList, getContext());
//        mRecyclerView.setAdapter(mCardAdapter);
//        mCardAdapter.setOnItemClickListener(this);
//    }
}
