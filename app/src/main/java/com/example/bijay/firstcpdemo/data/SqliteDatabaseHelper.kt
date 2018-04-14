package com.example.bijay.firstcpdemo.data

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

internal class SqliteDatabaseHelper: SQLiteOpenHelper {

    private val TAG: String
        get() = SqliteDatabaseHelper::class.java.simpleName

    internal val TABLE_NAME = "Employ"
    internal val NAME = "Name"
    internal val AGE = "Age"
    internal val ID = "_id"

    private val CREATE_TABLE = "CREATE TABLE $TABLE_NAME($ID INTEGER PRIMARY KEY AUTOINCREMENT, $NAME VARCHAR(50), $AGE INTERGER);"
    private val DROP_TABLE = "DROP TABLE IF EXISTS $TABLE_NAME;"

    companion object {
        internal val DATABASE_NAME = "employ.db"
        internal val DATABASE_VERSION = 2
    }

    constructor(context: Context?): super(context, DATABASE_NAME, null, DATABASE_VERSION) {

        Log.d(TAG, "Constructor running in thread: ${Thread.currentThread().name}")
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db!!.execSQL(CREATE_TABLE)

        Log.d(TAG, "onCreate running in thread: ${Thread.currentThread().name}")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL(DROP_TABLE)
        onCreate(db)

        Log.d(TAG, "onUpgrade running in thread: ${Thread.currentThread().name}")
    }
}