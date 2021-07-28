package com.satya.subjetpack1.ui.favorite.favoritemovie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.satya.subjetpack1.data.Repository
import com.satya.subjetpack1.data.source.local.entity.MovieEntity

class FavoriteMovieViewModel(private val repository: Repository) : ViewModel() {

    fun getMovies(): LiveData<PagedList<MovieEntity>> = repository.getFavoritedMovie()

    fun setFavorite(movieEntity: MovieEntity) {
        val newState = !movieEntity.favorite
        repository.setMovieFavorite(movieEntity, newState)
    }

}