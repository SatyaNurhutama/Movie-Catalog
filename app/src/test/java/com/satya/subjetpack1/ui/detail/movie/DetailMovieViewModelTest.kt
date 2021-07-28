package com.satya.subjetpack1.ui.detail.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.satya.subjetpack1.data.Repository
import com.satya.subjetpack1.data.source.local.entity.MovieWithId
import com.satya.subjetpack1.utils.DataDummy
import com.satya.subjetpack1.vo.Resource
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailMovieViewModelTest{

    private lateinit var viewModel: DetailMovieViewModel
    private val dummyMovie = DataDummy.generateDummyMovies()[0]
    private val movieId = dummyMovie.movieId

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepository: Repository

    @Mock
    private lateinit var observer: Observer<Resource<MovieWithId>>

    @Before
    fun setup(){
        viewModel = DetailMovieViewModel(movieRepository)
        viewModel.setSelectedMovie(movieId)
    }

    @Test
    fun getMovieById() {
        val dummyMovieWithId = Resource.success(DataDummy.generateDummyMovieWithId(dummyMovie,false))
        val movie = MutableLiveData<Resource<MovieWithId>>()
        movie.value = dummyMovieWithId
        `when`(movieRepository.getMovie(movieId)).thenReturn(movie)
        viewModel.movieById.observeForever(observer)
        verify(observer).onChanged(dummyMovieWithId)
    }

}

