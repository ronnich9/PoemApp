package com.feriramara.ukrainianapp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.feriramara.ukrainianapp.Card;
import com.feriramara.ukrainianapp.R;

import java.util.ArrayList;

/**
 * Created by Alex on 21.02.2018.
 */

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.CardHolder> {

    private ArrayList<Card> authors;
    private Context mContext;
    private OnItemClickListener mListener;
    private int img;
    private int imgBIG;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public CardAdapter(ArrayList<Card> authors, Context context) {
        this.authors = authors;
        mContext = context;
    }

    public class CardHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView mTextView_author;
        TextView mTextView_poetryName;
        ImageView mImageView;
        ImageView mImageViewFavor;

        public CardHolder(View itemView) {
            super(itemView);
            mTextView_author = itemView.findViewById(R.id.author_textView);
            mTextView_poetryName = itemView.findViewById(R.id.poetryName_TextView);
            mImageView = itemView.findViewById(R.id.image_ImageView);
            mImageViewFavor = itemView.findViewById(R.id.favor_imageview);


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
    public CardHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.card_layout, parent, false);
        return new CardHolder(v);
    }

    @Override
    public void onBindViewHolder(CardHolder holder, int position) {
        Card card = authors.get(position);

        String author = card.getAuthorName();
        String poetry = card.getPoetryName();
        int favor = card.getFavorites();

        holder.mTextView_author.setText(author);
        holder.mTextView_poetryName.setText(poetry);

        switch (author) {
            case "Леся Українка":
                img = R.drawable.lesya;
//                imgBIG = R.drawable.lesa2;
                break;
            case "Тарас Шевченко":
                img = R.drawable.taras;
//                imgBIG = R.drawable.taras2;
                break;
            case "Ліна Костенко":
                img = R.drawable.lina;
                break;
            case "Василь Стус":
                img = R.drawable.stus;
                break;
            case "Іван Франко":
                img = R.drawable.franko;
                break;
            default:
                img = R.drawable.ic_launcher_background;
                imgBIG = R.drawable.ic_launcher_foreground;
                break;


        }
        holder.mImageView.setImageResource(img);


        if (favor == 0) {
            holder.mImageViewFavor.setImageResource(R.drawable.ic_favorite_border_black_24dp);
        } else {
            holder.mImageViewFavor.setImageResource(R.drawable.ic_favorite_black_24dp);
        }
    }

    @Override
    public int getItemCount() {
        return authors.size();
    }

}
