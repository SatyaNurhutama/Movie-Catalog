package com.satya.subjetpack1.data.source.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.satya.subjetpack1.data.source.local.dao.MovieDao
import com.satya.subjetpack1.data.source.local.entity.MovieEntity
import com.satya.subjetpack1.data.source.local.entity.MovieWithId
import com.satya.subjetpack1.data.source.local.entity.TvEntity
import com.satya.subjetpack1.data.source.local.entity.TvWithId

class LocalDataSource private constructor(private val mMovieDao: MovieDao) {

    companion object {
        private var INSTANCE: LocalDataSource? = null

        fun getInstance(movieDao: MovieDao): LocalDataSource =
            INSTANCE ?: LocalDataSource(movieDao)
    }

    fun getAllMovies(): DataSource.Factory<Int, MovieEntity> = mMovieDao.getMovies()

    fun getMovie(movieId: String): LiveData<MovieWithId> =
        mMovieDao.getMovieById(movieId)

    fun getFavoritedMovie(): DataSource.Factory<Int, MovieEntity> = mMovieDao.getFavoritedMovie()

    fun getAllTvShow(): DataSource.Factory<Int, TvEntity> = mMovieDao.getTvShows()

    fun getTvShow(tvId: String): LiveData<TvWithId> =
        mMovieDao.getTvShowById(tvId)

    fun getFavoritedTvShow(): DataSource.Factory<Int, TvEntity> = mMovieDao.getFavoritedTvShow()

    fun insertMovies(movies: List<MovieEntity>) = mMovieDao.insertMovies(movies)

    fun insertTvShows(tvShows: List<TvEntity>) = mMovieDao.insertTvShows(tvShows)

    fun setMovieFavorite(movie: MovieEntity, newState: Boolean) {
        movie.favorite = newState
        mMovieDao.updateMovie(movie)
    }

    fun setTvShowFavorite(tvShow: TvEntity, newState: Boolean) {
        tvShow.favorite = newState
        mMovieDao.updateTvShow(tvShow)
    }

}