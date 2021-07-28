package com.satya.subjetpack1.utils

import android.content.Context
import com.satya.subjetpack1.data.source.remote.response.MovieResponse
import com.satya.subjetpack1.data.source.remote.response.TvResponse
import org.json.JSONObject
import java.io.IOException
import java.lang.Exception
import java.util.ArrayList

class JsonHelper(private val context: Context) {

    private fun parsingFileToString(fileName: String): String? {
        return try {
            val `is` = context.assets.open(fileName)
            val buffer = ByteArray(`is`.available())
            `is`.read(buffer)
            `is`.close()
            String(buffer)

        } catch (ex: IOException) {
            ex.printStackTrace()
            null
        }
    }

    fun loadMovies(): List<MovieResponse> {
        val list = ArrayList<MovieResponse>()
        try {
            val responseObject = JSONObject(parsingFileToString("MovieResponses.json").toString())
            val listArray = responseObject.getJSONArray("movies")
            for (i in 0 until listArray.length()) {
                val movies = listArray.getJSONObject(i)

                val movieId = movies.getString("movieId")
                val title = movies.getString("title")
                val synopsis = movies.getString("synopsis")
                val genre = movies.getString("genre")
                val year = movies.getString("year")
                val rating = movies.getString("rating")
                val duration = movies.getString("duration")
                val image = movies.getString("image")

                val movieResponse = MovieResponse(movieId, title, synopsis, genre, year, rating, duration, image)
                list.add(movieResponse)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return list
    }

    fun loadTvShows(): List<TvResponse> {
        val list = ArrayList<TvResponse>()
        try {
            val responseObject = JSONObject(parsingFileToString("TvResponses.json").toString())
            val listArray = responseObject.getJSONArray("tvShows")
            for (i in 0 until listArray.length()) {
                val tvShows = listArray.getJSONObject(i)

                val tvId = tvShows.getString("tvId")
                val title = tvShows.getString("title")
                val synopsis = tvShows.getString("synopsis")
                val genre = tvShows.getString("genre")
                val year = tvShows.getString("year")
                val rating = tvShows.getString("rating")
                val episode = tvShows.getString("episode")
                val image = tvShows.getString("image")

                val tvResponse = TvResponse(tvId, title, synopsis, genre, year, rating, episode, image)
                list.add(tvResponse)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return list
    }

}