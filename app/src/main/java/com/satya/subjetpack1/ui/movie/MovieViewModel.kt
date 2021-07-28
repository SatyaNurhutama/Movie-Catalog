package com.satya.subjetpack1.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList

import com.satya.subjetpack1.data.source.local.entity.MovieEntity
import com.satya.subjetpack1.data.Repository
import com.satya.subjetpack1.vo.Resource

class MovieViewModel(private val repository: Repository) : ViewModel() {

    fun getMovies(): LiveData<Resource<PagedList<MovieEntity>>> = repository.getMovies()

}