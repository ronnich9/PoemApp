package com.feriramara.ukrainianapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;



public class DBHelper extends SQLiteAssetHelper {

    private SQLiteDatabase db;

    private static String DATABASE_PATH = "/data/data/com.feriramara.ukrainianapp/databases/";



    private static final String DATABASE_NAME = "poetry.db";
    private static final int DATABASE_VERSION = 1;

    private Context mContext = null;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    public void addToFavorites(int id) {

        SQLiteDatabase db = getReadableDatabase();
        String query = String.format("UPDATE Poems SET favorite = '1' WHERE id='%s';", id);
        db.execSQL(query);
    }

    public void removeFromFavorites(int id) {

        SQLiteDatabase db = getReadableDatabase();
        String query = String.format("UPDATE Poems SET favorite = '0' WHERE id='%s';", id);
        db.execSQL(query);
    }

    public boolean isFavorite(int id) {
        SQLiteDatabase db = getReadableDatabase();
        String query = String.format("SELECT favorite FROM Poems WHERE id='%s';", id);
        Cursor cursor = db.rawQuery(query, null);
        boolean bul = false;
        if (cursor.moveToFirst()) {
            int num = cursor.getInt(cursor.getColumnIndex("favorite"));
            return (num == 1);

        }
        cursor.close();
        return false;
    }

    public ArrayList<Card> getAllFavorites() {

        String[] sqlSelect = {"id", "author", "title", "favorite", "text"};
        String tableName = "Poems";


        ArrayList<Card> list = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        qb.setTables(tableName);
        Cursor c = qb.query(db, sqlSelect, "favorite LIKE 1",null,null,null,null);

        if (c.moveToFirst()) {
            do {
                Card card = new Card();
                card.setId(c.getInt(c.getColumnIndex("id")));
                card.setAuthorName(c.getString(c.getColumnIndex("author")));
                card.setPoetryName(c.getString(c.getColumnIndex("title")));
                card.setText(c.getString(c.getColumnIndex("text")));
                card.setFavorites(c.getInt(c.getColumnIndex("favorite")));
                list.add(card);
            } while (c.moveToNext());
        }

        c.close();
        db.close();
        return list;
    }

    public ArrayList<Card> getPoemsByAuthor(String author) {

        String[] sqlSelect = {"id", "author", "title", "favorite", "text"};
        String tableName = "Poems";


        ArrayList<Card> list = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        qb.setTables(tableName);
        String query = String.format("author LIKE '%s'", author);
        Cursor c = qb.query(db, sqlSelect, query,null,null,null,null);

        if (c.moveToFirst()) {
            do {
                Card card = new Card();
                card.setId(c.getInt(c.getColumnIndex("id")));
                card.setAuthorName(c.getString(c.getColumnIndex("author")));
                card.setPoetryName(c.getString(c.getColumnIndex("title")));
                card.setText(c.getString(c.getColumnIndex("text")));
                card.setFavorites(c.getInt(c.getColumnIndex("favorite")));
                list.add(card);
            } while (c.moveToNext());
        }

        c.close();
        db.close();
        return list;
    }

    public ArrayList<Card> getNewPoems() {

        String[] sqlSelect = {"id", "author", "title", "favorite", "text"};
        String tableName = "Poems";


        ArrayList<Card> list = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        qb.setTables(tableName);
        String query = "id>755";
        Cursor c = qb.query(db, sqlSelect, query,null,null,null,null);

        if (c.moveToFirst()) {
            do {
                Card card = new Card();
                card.setId(c.getInt(c.getColumnIndex("id")));
                card.setAuthorName(c.getString(c.getColumnIndex("author")));
                card.setPoetryName(c.getString(c.getColumnIndex("title")));
                card.setText(c.getString(c.getColumnIndex("text")));
                card.setFavorites(c.getInt(c.getColumnIndex("favorite")));
                list.add(card);
            } while (c.moveToNext());
        }

        c.close();
        db.close();
        return list;
    }

    public ArrayList<Card> getBestPoems() {

        String[] sqlSelect = {"id", "author", "title", "favorite", "text"};
        String tableName = "Poems";


        ArrayList<Card> list = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        qb.setTables(tableName);
        String query = "id IN (1,3,14,42,46,105,152,185,213,269,279,403,447,735,756,764)";
        Cursor c = qb.query(db, sqlSelect, query,null,null,null,null);

        if (c.moveToFirst()) {
            do {
                Card card = new Card();
                card.setId(c.getInt(c.getColumnIndex("id")));
                card.setAuthorName(c.getString(c.getColumnIndex("author")));
                card.setPoetryName(c.getString(c.getColumnIndex("title")));
                card.setText(c.getString(c.getColumnIndex("text")));
                card.setFavorites(c.getInt(c.getColumnIndex("favorite")));
                list.add(card);
            } while (c.moveToNext());
        }

        c.close();
        db.close();
        return list;
    }























    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }

}


