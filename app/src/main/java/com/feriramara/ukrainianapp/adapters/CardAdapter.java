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



public class CardAdapter extends RecyclerView.Adapter<CardAdapter.CardHolder> {

    private ArrayList<Card> authors;
    private Context mContext;
    private OnItemClickListener mListener;
    private int img;

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
                break;
            case "Тарас Шевченко":
                img = R.drawable.taras;
                break;
            case "Ліна Костенко":
                img = R.drawable.lina_kostenko;
                break;
            case "Василь Стус":
                img = R.drawable.vasyl_stus;
                break;
            case "Іван Франко":
                img = R.drawable.ivan_franko;
                break;
            case "Андрій Малишко":
                img = R.drawable.andrii_malyshko;
                break;
            case "Борис Грінченко":
                img = R.drawable.borys_grinchenko;
                break;
            case "Євген Маланюк":
                img = R.drawable.evgen_malanyuk;
                break;
            case "Іван Драч":
                img = R.drawable.ivan_drach;
                break;
            case "Микола Хвильовий":
                img = R.drawable.mykola_hvylovy;
                break;
            case "Микола Сингаївський":
                img = R.drawable.mykola_syngaisvkii;
                break;
            case "Микола Вінграновський":
                img = R.drawable.mykola_vigranovsky;
                break;
            case "Олег Ольжич":
                img = R.drawable.oleg_olzhych;
                break;
            case "Олена Теліга":
                img = R.drawable.olena_teliga;
                break;
            case "Олесь Гончар":
                img = R.drawable.oles_gonchar;
                break;
            case "Олекса Стефанович":
                img = R.drawable.olexa_stefanovych;
                break;
            case "Олександр Олесь":
                img = R.drawable.olexandr_oles;
                break;
            case "Оксана Лятуринська":
                img = R.drawable.oxana_lyaturinska;
                break;
            case "Пантелеймон Куліш":
                img = R.drawable.panteleimon_kulish;
                break;
            case "Павло Тичина":
                img = R.drawable.pavlo_tychyna;
                break;
            case "Петро Перебийніс":
                img = R.drawable.petro_perebiynis;
                break;
            case "Максим Рильський":
                img = R.drawable.rylskyy_maksym;
                break;
            case "Степан Руданський":
                img = R.drawable.stepan_rudansky;
                break;
            case "Тодось Осьмачка":
                img = R.drawable.todos_osmachka;
                break;
            case "Симоненко Василь":
                img = R.drawable.vasyl_simonenko;
                break;
            case "Володимир Самійленко":
                img = R.drawable.volodymyr_samiylenko;
                break;
            case "Володимир Сосюра":
                img = R.drawable.volodymyr_sosyura;
                break;
            case "Юрій Тарнавський":
                img = R.drawable.yuri_tarnavsly;
                break;
            default:
                img = R.drawable.default_small1;
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
