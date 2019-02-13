package com.example.srs.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;


public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.context = context;
    }

    private Context context;

    // CREATE TABLE FAVORITE
    private static final String CREATE_FAVORITE = "CREATE TABLE favorite ("
            + "user_id integer PRIMARY KEY AUTOINCREMENT,"
            + "stock_id integer)";

    // CREATE TABLE HISTORY
    private static final String CREATE_HISTORY = "CREATE TABLE HISTORY ("
            + "history_id integer PRIMARY KEY AUTOINCREMENT,"
            + "type text,"
            + "quote integer,"
            + "date text,"
            + "user_id integer,"
            + "amount real,"
            + "stock_id text)";

    // CREATE TABLE NEWS
    private static final String CREATE_NEWS = "CREATE TABLE news ("
    + "news_id integer PRIMARY KEY AUTOINCREMENT,"
    + "stock_id integer,"
    + "news_title text,"
    + "news_content text,"
    + "date integer,"
    + "link text)";

    // CREATE TABLE NOTE
    private static final String CREATE_NOTE = "CREATE TABLE note ("
            + "note_id integer PRIMARY KEY AUTOINCREMENT,"
            + "user_id integer,"
            + "note_title text,"
            + "description text)";

    // CREATE TABLE QUESTION
    private static final String CREATE_QUESTION = "CREATE TABLE question ("
            + "question_id integer PRIMARY KEY AUTOINCREMENT,"
            + "question text)";

    // CREATE TABLE STOCK_ITEMS
    private static final String CREATE_STOCK_ITEMS = "CREATE TABLE stock_item ("
            + "stock_id integer PRIMARY KEY AUTOINCREMENT,"
            + "stock_name text,"
            + "stock_code text,"
            + "stock_quote text,"
            + "rate text)";

    // CREATE TABLE USER
    private static final String CREATE_USER = "CREATE TABLE user ("
            + "user_id integer PRIMARY KEY AUTOINCREMENT,"
            + "username text,"
            + "password text,"
            + "name text,"
            + "gender text,"
            + "age integer,"
            + "phone_number text,"
            + "question_id integer,"
            + "answer blob)";


    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO 创建数据库后，对数据库的操作
        db.execSQL(CREATE_FAVORITE);
        db.execSQL(CREATE_HISTORY);
        db.execSQL(CREATE_NEWS);
        db.execSQL(CREATE_NOTE);
        db.execSQL(CREATE_QUESTION);
        db.execSQL(CREATE_STOCK_ITEMS);
        db.execSQL(CREATE_USER);

        Toast.makeText(context, "创建数据库成功...", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO 更改数据库版本的操作
        db.execSQL("drop table if exists favorite");
        db.execSQL("drop table if exists history");
        db.execSQL("drop table if exists news");
        db.execSQL("drop table if exists note");
        db.execSQL("drop table if exists question");
        db.execSQL("drop table if exists stock_items");
        db.execSQL("drop table if exists user");
        onCreate(db);
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        // TODO 每次成功打开数据库后首先被执行
    }
}
