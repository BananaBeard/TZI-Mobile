package com.kovalenko.tzimobile

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.*

class DatabaseHelper(ctx: Context) : ManagedSQLiteOpenHelper(ctx, "UserDatabase", null, 1) {

    override fun onCreate(database: SQLiteDatabase) {
        database.createTable(
                User.TABLE_NAME,true,
                User.COLUMN_ID to INTEGER + PRIMARY_KEY + UNIQUE,
                User.COLUMN_NAME to TEXT,
                User.COLUMN_PASSWORD to TEXT
        )
    }


    override fun onUpgrade(database: SQLiteDatabase, p1: Int, p2: Int) {
        database.dropTable(User.TABLE_NAME, true)
    }

    companion object {
        private var instance: DatabaseHelper? = null

        @Synchronized
        fun Instance(context: Context): DatabaseHelper {
            if (instance == null) {
                instance = DatabaseHelper(context.applicationContext)
            }
            return instance!!
        }
    }
}