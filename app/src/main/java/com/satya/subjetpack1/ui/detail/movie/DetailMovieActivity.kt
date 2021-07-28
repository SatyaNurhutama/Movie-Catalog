package com.satya.subjetpack1.ui.detail.movie

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.satya.subjetpack1.R
import com.satya.subjetpack1.data.source.local.entity.MovieEntity
import com.satya.subjetpack1.databinding.ActivityDetailMovieBinding
import com.satya.subjetpack1.databinding.ContentDetailMovieBinding
import com.satya.subjetpack1.viewmodel.ViewModelFactory
import com.satya.subjetpack1.vo.Status

class DetailMovieActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_MOVIE = "extra_movie"
    }

    private lateinit var activity: ActivityDetailMovieBinding
    private lateinit var detailContentBinding: ContentDetailMovieBinding

    private lateinit var viewModel: DetailMovieViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activity = ActivityDetailMovieBinding.inflate(layoutInflater)
        detailContentBinding = activity.detailMovie

        setContentView(activity.root)

        val adapter = DetailMovieAdapter()


        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, factory)[DetailMovieViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val movieId = extras.getString(EXTRA_MOVIE)
            if (movieId != null) {

                activity.pbMovie.visibility = View.VISIBLE
                activity.content.visibility = View.INVISIBLE
                viewModel.setSelectedMovie(movieId)

                viewModel.movieById.observe(this, { movieResource ->
                    if (movieResource != null) {
                        when (movieResource.status) {
                            Status.LOADING -> activity.pbMovie.visibility = View.VISIBLE
                            Status.SUCCESS -> if (movieResource.data != null) {
                                activity.pbMovie.visibility = View.GONE
                                activity.content.visibility = View.VISIBLE
                                adapter.notifyDataSetChanged()
                                populateMovie(movieResource.data.idMovie)

                                val state = movieResource.data.idMovie.favorite
                                setStatusFavorite(state)
                            }
                            Status.ERROR -> {
                                activity.pbMovie.visibility = View.GONE
                                activity.content.visibility = View.VISIBLE
                                Toast.makeText(
                                    applicationContext,
                                    "Terjadi kesalahan",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                        detailContentBinding.imgFav.setOnClickListener {
                            viewModel.setFavoriteMovie()
                        }
                    }
                })
            }
        }
    }


    private fun populateMovie(movieEntity: MovieEntity?) {
        detailContentBinding.tvTitle.text = movieEntity?.title
        detailContentBinding.tvSinopsis.text = movieEntity?.synopsis
        detailContentBinding.tvGenreFilm.text = movieEntity?.genre
        detailContentBinding.tvYear.text = movieEntity?.year
        detailContentBinding.tvRating.text = movieEntity?.rating
        detailContentBinding.tvDurasiFilm.text = movieEntity?.duration

        Glide.with(this)
            .load(movieEntity?.image)
            .transform(RoundedCorners(20))
            .apply(
                RequestOptions.placeholderOf(R.drawable.ic_loading)
                    .error(R.drawable.ic_error)
            )
            .into(detailContentBinding.imgMovie)

        detailContentBinding.imgShare.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            val shareTitle = (R.string.share_movie)
            val shareBody = resources.getString(R.string.share_movie2, movieEntity?.title)
            intent.putExtra(Intent.EXTRA_SUBJECT, shareTitle)
            intent.putExtra(Intent.EXTRA_TEXT, shareBody)
            startActivity(Intent.createChooser(intent, "Bagikan movie"))
        }
    }

    private fun setStatusFavorite(state: Boolean) {
        if (state) {
            detailContentBinding.imgFav.setImageDrawable(
                ContextCompat.getDrawable(this, R.drawable.ic_favorited)
            )

        } else {
            detailContentBinding.imgFav.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.ic_baseline_favorite_border_24
                )
            )
        }
    }
}