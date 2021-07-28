package com.satya.subjetpack1.ui.detail.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.satya.subjetpack1.data.Repository
import com.satya.subjetpack1.data.source.local.entity.MovieEntity
import com.satya.subjetpack1.data.source.local.entity.TvEntity
import com.satya.subjetpack1.data.source.local.entity.TvWithId
import com.satya.subjetpack1.vo.Resource

class DetailTvShowViewModel(private val tvShowRepository: Repository) : ViewModel() {

    val tvId = MutableLiveData<String>()

    fun setSelectedTvShow(tvId: String) {
        this.tvId.value = tvId
    }

    var tvShowById: LiveData<Resource<TvWithId>> = Transformations.switchMap(tvId) { mTvShowId ->
        tvShowRepository.getTvShow(mTvShowId)
    }

    fun setFavoriteTvShow() {
        val tvShowResource = tvShowById.value
        if (tvShowResource != null) {
            val tvWithId = tvShowResource.data
            if (tvWithId != null) {
                val tvEntity = tvWithId.idTvShow
                val newState = !tvEntity.favorite
                tvShowRepository.setTvFavorite(tvEntity, newState)

            }
        }

    }

}