package com.example.agendatf.nucleo

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class SQLiteHelper (context: Context): SQLiteOpenHelper(context, "addressBook.db",null, 1) {

    companion object {
        const val TABLE_NAME = "contacts"
        const val FIELD_ID = "_id"
        const val FIELD_NAME = "name"
        const val FIELD_LAST_NAME = "last_name"
        const val FIELD_MAIL = "email"
        const val FIELD_PHONE = "phone"
    }


    override fun onCreate(db: SQLiteDatabase?) {
        val commandCreate = "CREATE TABLE $TABLE_NAME (" +
                "$FIELD_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "$FIELD_NAME TEXT," +
                "$FIELD_LAST_NAME TEXT," +
                "$FIELD_MAIL TEXT," +
                "$FIELD_PHONE TEXT)"
        db!!.execSQL(commandCreate)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    }

    fun addData(name: String, last_name: String, email: String, phone: String) {
        val data = ContentValues()
        data.put(FIELD_NAME, name)
        data.put(FIELD_LAST_NAME, last_name)
        data.put(FIELD_MAIL, email)
        data.put(FIELD_PHONE, phone)
        val db = this.writableDatabase
        db.insert(TABLE_NAME, null, data)
        db.close()
    }

    fun deleteData(id: String): Int {
        val args = arrayOf(id)

        val db = this.writableDatabase
        val affectedRows = db.delete(TABLE_NAME, "_id = ?", args)
        db.close()
        return affectedRows
    }

    fun updateData(id: String, name: String, last_name: String, email: String, phone: String): Int {
        val args = arrayOf(id)

        val data = ContentValues()
        data.put(FIELD_NAME, name)
        data.put(FIELD_LAST_NAME, last_name)
        data.put(FIELD_MAIL, email)
        data.put(FIELD_PHONE, phone)
        val db = this.writableDatabase
        val affectedRows = db.update(TABLE_NAME, data, "_id = ?", args)
        db.close()
        return affectedRows
    }
}
