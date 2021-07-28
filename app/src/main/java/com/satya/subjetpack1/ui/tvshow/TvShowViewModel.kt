package com.satya.subjetpack1.ui.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.satya.subjetpack1.data.source.local.entity.TvEntity
import com.satya.subjetpack1.data.Repository
import com.satya.subjetpack1.vo.Resource

class TvShowViewModel(private val repository: Repository): ViewModel() {

    fun getTvShows() : LiveData<Resource<PagedList<TvEntity>>> = repository.getTvShows()
}