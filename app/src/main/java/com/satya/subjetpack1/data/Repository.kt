package com.satya.subjetpack1.data

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.satya.subjetpack1.data.source.local.LocalDataSource
import com.satya.subjetpack1.data.source.local.entity.MovieEntity
import com.satya.subjetpack1.data.source.local.entity.MovieWithId
import com.satya.subjetpack1.data.source.local.entity.TvEntity
import com.satya.subjetpack1.data.source.local.entity.TvWithId
import com.satya.subjetpack1.data.source.remote.RemoteDataSource
import com.satya.subjetpack1.data.source.remote.response.ApiResponse
import com.satya.subjetpack1.data.source.remote.response.MovieResponse
import com.satya.subjetpack1.data.source.remote.response.TvResponse
import com.satya.subjetpack1.utils.AppExecutors
import com.satya.subjetpack1.vo.Resource

class Repository private constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : DataSource {

    companion object {
        @Volatile
        private var instance: Repository? = null

        fun getInstance(
            remoteData: RemoteDataSource,
            localData: LocalDataSource,
            appExecutors: AppExecutors
        ): Repository =
            instance ?: synchronized(this) {
                instance ?: Repository(remoteData, localData, appExecutors).apply{
                    instance = this
                }
            }
    }

    override fun getMovies(): LiveData<Resource<PagedList<MovieEntity>>>{
        return object : NetworkBoundResource<PagedList<MovieEntity>, List<MovieResponse>>(appExecutors) {
            public override fun loadFromDB(): LiveData<PagedList<MovieEntity>> {
            val config = PagedList.Config.Builder()
                .setEnablePlaceholders(false)
                .setInitialLoadSizeHint(4)
                .setPageSize(4)
                .build()
            return LivePagedListBuilder(localDataSource.getAllMovies(), config).build()
            }

            override fun shouldFetch(data: PagedList<MovieEntity>?): Boolean =
                data == null || data.isEmpty()

            public override fun createCall(): LiveData<ApiResponse<List<MovieResponse>>> =
                remoteDataSource.getMovies()

            public override fun saveCallResult(data: List<MovieResponse>) {
                val movieList = ArrayList<MovieEntity>()
                for (response in data) {
                    val movie = MovieEntity(
                        response.movieId,
                        response.title,
                        response.synopsis,
                        response.genre,
                        response.year,
                        response.rating,
                        response.duration,
                        false,
                        response.image)
                    movieList.add(movie)
                }
                localDataSource.insertMovies(movieList)
            }
        }.asLiveData()
    }

    override fun getMovie(movieId: String): LiveData<Resource<MovieWithId>> {
        return object : NetworkBoundResource<MovieWithId, List<MovieResponse>>(appExecutors) {
            override fun loadFromDB(): LiveData<MovieWithId> =
                localDataSource.getMovie(movieId)

            override fun shouldFetch(data: MovieWithId?): Boolean =
                data?.mMovies == null || data.mMovies.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<MovieResponse>>> =
                remoteDataSource.getMovie(movieId)

            override fun saveCallResult(data: List<MovieResponse>) {
                val movieList = ArrayList<MovieEntity>()
                for (response in data) {
                    val movie = MovieEntity(
                        response.movieId,
                        response.title,
                        response.synopsis,
                        response.genre,
                        response.year,
                        response.rating,
                        response.duration,
                        false,
                        response.image)
                    movieList.add(movie)
                }
                localDataSource.insertMovies(movieList)
            }
        }.asLiveData()
    }

    override fun getFavoritedMovie(): LiveData<PagedList<MovieEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getFavoritedMovie(), config).build()
    }


    override fun getTvShows(): LiveData<Resource<PagedList<TvEntity>>>{
        return object : NetworkBoundResource<PagedList<TvEntity>, List<TvResponse>>(appExecutors) {
            public override fun loadFromDB(): LiveData<PagedList<TvEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()
                return LivePagedListBuilder(localDataSource.getAllTvShow(), config).build()
            }

            override fun shouldFetch(data: PagedList<TvEntity>?): Boolean =
                data == null || data.isEmpty()

            public override fun createCall(): LiveData<ApiResponse<List<TvResponse>>> =
                remoteDataSource.getTvShows()

            public override fun saveCallResult(data: List<TvResponse>) {
                val tvList = ArrayList<TvEntity>()
                for (response in data) {
                    val tvShow = TvEntity(
                        response.tvId,
                        response.title,
                        response.synopsis,
                        response.genre,
                        response.year,
                        response.rating,
                        response.episode,
                        false,
                        response.image)
                    tvList.add(tvShow)
                }
                localDataSource.insertTvShows(tvList)
            }
        }.asLiveData()
    }

    override fun getTvShow(tvShowId: String): LiveData<Resource<TvWithId>> {
        return object : NetworkBoundResource<TvWithId, List<TvResponse>>(appExecutors) {
            override fun loadFromDB(): LiveData<TvWithId> =
                localDataSource.getTvShow(tvShowId)

            override fun shouldFetch(data: TvWithId?): Boolean =
                data?.mTvShow == null || data.mTvShow.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<TvResponse>>> =
                remoteDataSource.getTvShow(tvShowId)

            override fun saveCallResult(data: List<TvResponse>) {
                val tvShowList = ArrayList<TvEntity>()
                for (response in data) {
                    val tvShow = TvEntity(
                        response.tvId,
                        response.title,
                        response.synopsis,
                        response.genre,
                        response.year,
                        response.rating,
                        response.episode,
                        false,
                        response.image)
                    tvShowList.add(tvShow)
                }
                localDataSource.insertTvShows(tvShowList)
            }
        }.asLiveData()
    }

    override fun getFavoritedTvShow(): LiveData<PagedList<TvEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getFavoritedTvShow(), config).build()
    }

    override fun setMovieFavorite(movie: MovieEntity, state: Boolean) {
        appExecutors.diskIO().execute { localDataSource.setMovieFavorite(movie, state) }
    }

    override fun setTvFavorite(tvShow: TvEntity, state: Boolean) =
        appExecutors.diskIO().execute { localDataSource.setTvShowFavorite(tvShow, state) }
}