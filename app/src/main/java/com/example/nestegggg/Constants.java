package com.example.nestegggg;

public class Constants {

    // db name
    public static final String DB_NAME = "PERSON_GOAL_DB";
    // db version
    public static final int DB_VERSION = 1;
    // db table name
    public static final String TABLE_NAME = "GOAL_INFO_TABLE";
    // columns of table
    public static final String C_ID = "ID";
    public static final String C_TITLE = "TITLE";
    public static final String C_AMOUNT = "AMOUNT";
    public static final String C_IMAGE = "IMAGE";
    public static final String C_Add_TIMESTAMP = "TIMESTAMP";
    public static final String C_UPDATED_TIMESTAMP = "UPDATED_TIMESTAMP";
    // create table query
    public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " ("
            + C_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + C_TITLE + " TEXT,"
            + C_AMOUNT + " TEXT,"
            + C_IMAGE + " TEXT,"
            + C_Add_TIMESTAMP + " TEXT,"
            + C_UPDATED_TIMESTAMP + " TEXT"
            + ")";
}
