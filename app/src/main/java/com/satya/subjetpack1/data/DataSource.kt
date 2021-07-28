package com.satya.subjetpack1.data

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.satya.subjetpack1.data.source.local.entity.MovieEntity
import com.satya.subjetpack1.data.source.local.entity.MovieWithId
import com.satya.subjetpack1.data.source.local.entity.TvEntity
import com.satya.subjetpack1.data.source.local.entity.TvWithId
import com.satya.subjetpack1.vo.Resource

interface DataSource {

    fun getMovies(): LiveData<Resource<PagedList<MovieEntity>>>

    fun getMovie(movieId: String): LiveData<Resource<MovieWithId>>

    fun getTvShows(): LiveData<Resource<PagedList<TvEntity>>>

    fun getTvShow(tvId: String): LiveData<Resource<TvWithId>>

    fun setMovieFavorite(movie: MovieEntity, state: Boolean)

    fun setTvFavorite(tvShow: TvEntity, state: Boolean)

    fun getFavoritedMovie(): LiveData<PagedList<MovieEntity>>

    fun getFavoritedTvShow(): LiveData<PagedList<TvEntity>>
}