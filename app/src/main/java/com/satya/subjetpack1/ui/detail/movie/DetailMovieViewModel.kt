package com.satya.subjetpack1.ui.detail.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.satya.subjetpack1.data.Repository
import com.satya.subjetpack1.data.source.local.entity.MovieEntity
import com.satya.subjetpack1.data.source.local.entity.MovieWithId
import com.satya.subjetpack1.vo.Resource

class DetailMovieViewModel(private val movieRepository: Repository) : ViewModel() {

    val movieId = MutableLiveData<String>()

    fun setSelectedMovie(movieId: String) {
        this.movieId.value = movieId
    }

    var movieById: LiveData<Resource<MovieWithId>> =
        Transformations.switchMap(movieId) { mMovieId ->
            movieRepository.getMovie(mMovieId)
        }


    fun setFavoriteMovie() {
        val movieResource = movieById.value
        if (movieResource != null) {
            val movieWithId = movieResource.data
            if (movieWithId != null) {
                val movieEntity = movieWithId.idMovie
                val newState = !movieEntity.favorite
                movieRepository.setMovieFavorite(movieEntity, newState)

            }
        }

    }
}