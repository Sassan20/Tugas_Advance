package com.test.tugasadvancetim.di

import android.content.Context
import com.test.tugasadvancetim.data.local.LocalDataSource
import com.test.tugasadvancetim.data.local.room.TeamDatabase
import com.test.tugasadvancetim.data.repository.TeamRepositoryImpl
import com.test.tugasadvancetim.domain.repository.TeamRepository

object Injection {
    fun provideRepository(context: Context): TeamRepository{
        val database = TeamDatabase.getInstance(context)

        val localDataSource = LocalDataSource.getInstance(database.teamDao())

        return TeamRepositoryImpl.getInstance(localDataSource)
    }
}