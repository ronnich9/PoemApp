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
        String query = "id IN (1,105,185,403,655,42,213,151,362,458,3,123,224,266,46,220,653,393,447," +
                "152,269,404,532,603,756,279,472,758,735,372,476,669,379,485,705,761,598,608,764)";
        String order = "CASE id WHEN 1 THEN 0 WHEN 105 THEN 1 WHEN 185 THEN 2 WHEN 403 THEN 3 WHEN 655 THEN 4 WHEN 42 THEN 5 WHEN 213 THEN 6" +
                " WHEN 151 THEN 7 WHEN 362 THEN 8 WHEN 458 THEN 9 WHEN 3 THEN 10 WHEN 123 THEN 11 WHEN 224 THEN 12 WHEN 266 THEN 13 WHEN 46 THEN 14 WHEN 220 THEN 15" +
                " WHEN 653 THEN 16 WHEN 393 THEN 17 WHEN 447 THEN 18 WHEN 152 THEN 19 WHEN 269 THEN 20 WHEN 404 THEN 21 WHEN 532 THEN 22 WHEN 603 THEN 23 WHEN 756 THEN 24" +
                " WHEN 279 THEN 25 WHEN 472 THEN 26 WHEN 758 THEN 27 WHEN 735 THEN 28 WHEN 372 THEN 29 WHEN 476 THEN 30 WHEN 669 THEN 31 WHEN 379 THEN 32 WHEN 485 THEN 33" +
                " WHEN 705 THEN 34 WHEN 761 THEN 35 WHEN 598 THEN 36 WHEN 608 THEN 37 WHEN 764 THEN 38 END";
        Cursor c = qb.query(db, sqlSelect, query,null,null,null,order);

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


