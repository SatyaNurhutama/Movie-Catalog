package com.satya.subjetpack1.injection

import android.content.Context
import com.satya.subjetpack1.data.Repository
import com.satya.subjetpack1.data.source.local.LocalDataSource
import com.satya.subjetpack1.data.source.local.room.MovieDatabase
import com.satya.subjetpack1.data.source.remote.RemoteDataSource
import com.satya.subjetpack1.utils.AppExecutors
import com.satya.subjetpack1.utils.JsonHelper

object Injection {

    fun provideRepository(context: Context): Repository {

        val database = MovieDatabase.getInstance(context)

        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))
        val localDataSource = LocalDataSource.getInstance(database.movieDao())
        val appExecutors = AppExecutors()

        return Repository.getInstance(remoteDataSource, localDataSource, appExecutors)

    }

}