package com.satya.subjetpack1.ui.detail.tvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.satya.subjetpack1.data.Repository
import com.satya.subjetpack1.data.source.local.entity.TvWithId
import com.satya.subjetpack1.utils.DataDummy
import com.satya.subjetpack1.vo.Resource
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailTvShowViewModelTest{

    private lateinit var viewModel: DetailTvShowViewModel
    private val dummyTv = DataDummy.generateDummyTvShows()[0]
    private val tvId = dummyTv.tvId

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var tvRepository: Repository

    @Mock
    private lateinit var observer: Observer<Resource<TvWithId>>

    @Before
    fun setup(){
        viewModel = DetailTvShowViewModel(tvRepository)
        viewModel.setSelectedTvShow(tvId)
    }

    @Test
    fun getTvShowById(){
        val dummyTvShowWithId = Resource.success(DataDummy.generateDummyTvShowWithId(dummyTv,false))
        val tvShow = MutableLiveData<Resource<TvWithId>>()
        tvShow.value = dummyTvShowWithId
        `when`(tvRepository.getTvShow(tvId)).thenReturn(tvShow)
        viewModel.tvShowById.observeForever(observer)
        verify(observer).onChanged(dummyTvShowWithId)
    }

}