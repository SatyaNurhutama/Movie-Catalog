package com.satya.subjetpack1.ui.favorite.favoritetv

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.satya.subjetpack1.data.Repository
import com.satya.subjetpack1.data.source.local.entity.MovieEntity
import com.satya.subjetpack1.data.source.local.entity.TvEntity

class FavoriteTvShowViewModel(private val repository: Repository) : ViewModel() {

    fun getTvShows(): LiveData<PagedList<TvEntity>> = repository.getFavoritedTvShow()

    fun setFavorite(tvShowEntity: TvEntity) {
        val newState = !tvShowEntity.favorite
        repository.setTvFavorite(tvShowEntity, newState)
    }
}