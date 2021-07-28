package com.satya.subjetpack1.data.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.satya.subjetpack1.data.source.local.LocalDataSource
import com.satya.subjetpack1.data.source.local.entity.MovieEntity
import com.satya.subjetpack1.data.source.local.entity.MovieWithId
import com.satya.subjetpack1.data.source.local.entity.TvEntity
import com.satya.subjetpack1.data.source.local.entity.TvWithId
import com.satya.subjetpack1.data.source.remote.RemoteDataSource
import com.satya.subjetpack1.utils.AppExecutors
import com.satya.subjetpack1.utils.DataDummy
import com.satya.subjetpack1.utils.LiveDataTestUtil
import com.satya.subjetpack1.utils.PagedListUtil
import com.satya.subjetpack1.vo.Resource
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.*

class RepositoryTest{

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = Mockito.mock(RemoteDataSource::class.java)
    private val local = mock(LocalDataSource::class.java)
    private val appExecutors = mock(AppExecutors::class.java)

    private val repository = FakeRepository(remote, local, appExecutors)

    private val movieResponses = DataDummy.generateRemoteDummyMovies()
    private val tvResponses = DataDummy.generateRemoteDummyTvShows()
    private val movieId = movieResponses[0].movieId
    private val tvShowId = tvResponses[0].tvId

    @Test
    fun getMovies(){
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getAllMovies()).thenReturn(dataSourceFactory)
        repository.getMovies()

        val movieEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyMovies()))
        verify(local).getAllMovies()
        assertNotNull(movieEntities.data)
        assertEquals(movieResponses.size.toLong(), movieEntities.data?.size?.toLong())
    }

    @Test
    fun getTvShows(){
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvEntity>
        `when`(local.getAllTvShow()).thenReturn(dataSourceFactory)
        repository.getTvShows()

        val tvShowEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyTvShows()))
        verify(local).getAllTvShow()
        assertNotNull(tvShowEntities.data)
        assertEquals(tvResponses.size.toLong(), tvShowEntities.data?.size?.toLong())
    }

    @Test
    fun getDetailMovie() {
        val dummyEntity = MutableLiveData<MovieWithId>()
        dummyEntity.value = DataDummy.generateDummyMovieWithId(DataDummy.generateDummyMovies()[0], false)
        `when`(local.getMovie(movieId)).thenReturn(dummyEntity)

        val movieEntities = LiveDataTestUtil.getValue(repository.getMovie(movieId))
        verify(local).getMovie(movieId)
        assertNotNull(movieEntities.data)
        assertNotNull(movieEntities.data?.idMovie?.title)
        assertEquals(movieResponses[0].title, movieEntities.data?.idMovie?.title)
    }

    @Test
    fun getDetailTvShow() {
        val dummyEntity = MutableLiveData<TvWithId>()
        dummyEntity.value = DataDummy.generateDummyTvShowWithId(DataDummy.generateDummyTvShows()[0], false)
        `when`(local.getTvShow(tvShowId)).thenReturn(dummyEntity)

        val tvShowEntities = LiveDataTestUtil.getValue(repository.getTvShow(tvShowId))
        verify(local).getTvShow(tvShowId)
        assertNotNull(tvShowEntities.data)
        assertNotNull(tvShowEntities.data?.idTvShow?.title)
        assertEquals(tvResponses[0].title, tvShowEntities.data?.idTvShow?.title)
    }

    @Test
    fun getFavoriteMovie() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getFavoritedMovie()).thenReturn(dataSourceFactory)
        repository.getFavoritedMovie()

        val movieEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyMovies()))
        verify(local).getFavoritedMovie()
        assertNotNull(movieEntities)
        assertEquals(movieResponses.size.toLong(), movieEntities.data?.size?.toLong())
    }

    @Test
    fun getFavoriteTvShow() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvEntity>
        `when`(local.getFavoritedTvShow()).thenReturn(dataSourceFactory)
        repository.getFavoritedTvShow()

        val tvShowEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyTvShows()))
        verify(local).getFavoritedTvShow()
        assertNotNull(tvShowEntities)
        assertEquals(tvResponses.size.toLong(), tvShowEntities.data?.size?.toLong())
    }
}
