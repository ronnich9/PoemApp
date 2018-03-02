package com.feriramara.ukrainianapp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.feriramara.ukrainianapp.Card;
import com.feriramara.ukrainianapp.DBHelper;
import com.feriramara.ukrainianapp.R;

import java.util.ArrayList;

/**
 * Created by Alex on 01.03.2018.
 */

public class CardAdapterByAuthor extends RecyclerView.Adapter<CardAdapterByAuthor.ViewHolderByAuthor> {

    private ArrayList<Card> mCards;
    private Context mContext;
    private CardAdapter.OnItemClickListener mListener;
    private DBHelper localDB;
    private String[] mString = {"lello", "there", "how", "are you"};

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(CardAdapter.OnItemClickListener listener) {
        mListener = listener;
    }

    public CardAdapterByAuthor(ArrayList<Card> cards, Context context) {
        mCards = cards;
        mContext = context;
    }

    public class ViewHolderByAuthor extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView mTextView;
        TextView mTextViewCount;

        public ViewHolderByAuthor(View itemView) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.textView_byAuthor);
            mTextViewCount = itemView.findViewById(R.id.textView_byAuthor_count);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mListener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            mListener.onItemClick(position);
                        }
                    }
                }
            });
        }



        @Override
        public void onClick(View view) {

        }
    }


    @Override
    public ViewHolderByAuthor onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.card_layout_byauthor, parent, false);
        return new ViewHolderByAuthor(v);
    }

    @Override
    public void onBindViewHolder(ViewHolderByAuthor holder, int position) {
//        Card card = mCards.get(position);
//        localDB = new DBHelper(mContext);
//
//        String author = card.getAuthorName();
//        String count = String.valueOf(localDB.getNumberOfAuthors(author));
        String string = mString[position];


        holder.mTextView.setText(string);
        holder.mTextViewCount.setText("hi");


    }

    @Override
    public int getItemCount() {
        return mString.length;
    }

}
