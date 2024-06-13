package com.test.tugasadvancetim.data.sqlite

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.test.tugasadvancetim.domain.model.Team

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    companion object {
        private const val DATABASE_NAME = "db_team"
        private const val DATABASE_VERSION = 1
        const val TABLE_NAME = "teams"
        const val ID = "id"
        const val NAME = "name"
        const val ROLE = "role"
        const val LATITUDE = "latitude"
        const val LONGITUDE = "longitude"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val createTableQuery = """
            CREATE TABLE $TABLE_NAME (
                $ID INTEGER PRIMARY KEY AUTOINCREMENT,
                $NAME TEXT,
                $ROLE TEXT,
                $LATITUDE TEXT,
               $LONGITUDE TEXT 
            )
        """.trimIndent()
        db.execSQL(createTableQuery)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun insertData(name: String, role: String, latitude: String, longitude: String): Long {
        val values = ContentValues().apply {
            put(NAME, name)
            put(ROLE, role)
            put(LATITUDE, latitude)
            put(LONGITUDE, longitude)
        }

        return writableDatabase.insert(TABLE_NAME, null, values)
    }

    fun readData(): List<Team> {
        val dataList = mutableListOf<Team>()
        val cursor = readableDatabase.query(TABLE_NAME, null, null, null, null, null, null)

        with(cursor) {
            while (moveToNext()) {
                val id = getInt(getColumnIndexOrThrow(ID))
                val name = getString(getColumnIndexOrThrow(NAME))
                val role = getString(getColumnIndexOrThrow(ROLE))
                val latitude = getString(getColumnIndexOrThrow(LATITUDE))
                val longitude = getString(getColumnIndexOrThrow(LONGITUDE))

                dataList.add(Team(id, name, role, latitude, longitude))
            }
        }

        cursor.close()
        return dataList
    }

    fun updateData(id: Int, name: String, role: String, latitude: String, longitude: String): Int {
        val values = ContentValues().apply {
            put(NAME, name)
            put(ROLE, role)
            put(LATITUDE, latitude)
            put(LONGITUDE, longitude)
        }

        val selection = "$ID = ?"
        val selectionArgs = arrayOf(id.toString())

        return writableDatabase.update(TABLE_NAME, values, selection, selectionArgs)
    }

    fun deleteData(id: Int): Int {
        val selection = "$ID = ?"
        val selectionArgs = arrayOf(id.toString())

        return writableDatabase.delete(TABLE_NAME, selection, selectionArgs)
    }
}