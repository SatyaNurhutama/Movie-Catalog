package com.satya.subjetpack1.data.source.local.dao

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import com.satya.subjetpack1.data.source.local.entity.MovieEntity
import com.satya.subjetpack1.data.source.local.entity.MovieWithId
import com.satya.subjetpack1.data.source.local.entity.TvEntity
import com.satya.subjetpack1.data.source.local.entity.TvWithId

@Dao
interface MovieDao {

    @Query("SELECT * FROM movieentities")
    fun getMovies(): DataSource.Factory<Int, MovieEntity>

    @Query("SELECT * FROM movieentities WHERE movieId = :movieId")
    fun getMovieById(movieId: String): LiveData<MovieWithId>

    @Query("SELECT * FROM movieentities WHERE favorited = 1")
    fun getFavoritedMovie(): DataSource.Factory<Int, MovieEntity>

    @Query("SELECT * FROM tventities")
    fun getTvShows(): DataSource.Factory<Int, TvEntity>

    @Query("SELECT * FROM tventities WHERE tvId = :tvId")
    fun getTvShowById(tvId: String): LiveData<TvWithId>

    @Query("SELECT * FROM tventities WHERE favorited = 1")
    fun getFavoritedTvShow(): DataSource.Factory<Int, TvEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovies(movies: List<MovieEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTvShows(tvShows: List<TvEntity>)

    @Update
    fun updateMovie(movie: MovieEntity)

    @Update
    fun updateTvShow(tvShow: TvEntity)
}