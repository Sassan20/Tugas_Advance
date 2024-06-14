package com.test.tugasadvancetim.data.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.test.tugasadvancetim.data.local.entity.TeamEntity

@Database(entities = [TeamEntity::class], version = 2, exportSchema = false)
abstract class TeamDatabase : RoomDatabase() {

    abstract fun teamDao(): TeamDao

    companion object {
        private var INSTANCE: TeamDatabase? = null

        fun getInstance(context: Context): TeamDatabase =
            INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    TeamDatabase::class.java,
                    "db_team"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
    }
}