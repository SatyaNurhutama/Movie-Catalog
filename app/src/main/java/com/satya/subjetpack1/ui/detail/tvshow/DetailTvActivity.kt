package com.satya.subjetpack1.ui.detail.tvshow

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
import com.satya.subjetpack1.data.source.local.entity.TvEntity
import com.satya.subjetpack1.databinding.ActivityDetailTvBinding
import com.satya.subjetpack1.databinding.ContentDetailTvBinding
import com.satya.subjetpack1.viewmodel.ViewModelFactory
import com.satya.subjetpack1.vo.Status

class DetailTvActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_TV = "extra_tv"
    }

    private lateinit var activity : ActivityDetailTvBinding
    private lateinit var detailContentDetailBinding: ContentDetailTvBinding

    private lateinit var detailContentBinding: ContentDetailTvBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activity = ActivityDetailTvBinding.inflate(layoutInflater)
        detailContentBinding = activity.detailTv

        setContentView(activity.root)

        val adapter = DetailTvAdapter()

        val factory = ViewModelFactory.getInstance(this)
        val viewModel = ViewModelProvider(this, factory)[DetailTvShowViewModel::class.java]

        val extras = intent.extras

        if (extras != null) {
            val tvId = extras.getString(EXTRA_TV)
            if (tvId != null) {

                activity.pbTv.visibility = View.VISIBLE
                activity.content.visibility = View.INVISIBLE

                viewModel.setSelectedTvShow(tvId)
                viewModel.tvShowById.observe(this, { tvResource ->
                    if (tvResource != null) {
                        when (tvResource.status) {
                            Status.LOADING -> activity.pbTv.visibility =
                                View.VISIBLE
                            Status.SUCCESS -> if (tvResource.data != null) {
                                activity.pbTv.visibility = View.GONE
                                activity.content.visibility = View.VISIBLE
                                adapter.notifyDataSetChanged()
                                populateTvShow(tvResource.data.idTvShow)

                                val state = tvResource.data.idTvShow.favorite
                                setStatusFavorite(state)
                            }
                            Status.ERROR -> {
                                activity.pbTv.visibility = View.GONE
                                Toast.makeText(
                                    applicationContext,
                                    "Terjadi kesalahan",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                        detailContentBinding.imgFav.setOnClickListener {
                            viewModel.setFavoriteTvShow()
                        }
                    }
                })
            }
        }
    }

    private fun populateTvShow(tvEntity: TvEntity) {
        detailContentBinding.tvTitle.text = tvEntity.title
        detailContentBinding.tvSinopsisFilm.text = tvEntity.synopsis
        detailContentBinding.tvGenreFilm.text = tvEntity.genre
        detailContentBinding.tvYear.text = tvEntity.year
        detailContentBinding.tvRating.text = tvEntity.rating
        detailContentBinding.tvEpisode2.text = tvEntity.episode

        Glide.with(this)
            .load(tvEntity.image)
            .transform(RoundedCorners(20))
            .apply(
                RequestOptions.placeholderOf(R.drawable.ic_loading)
                    .error(R.drawable.ic_error)
            )
            .into(detailContentBinding.imgTv)

        detailContentBinding.imgShare.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            val shareTitle = (R.string.share_movie)
            val shareBody = resources.getString(R.string.share_tv, tvEntity.title)
            intent.putExtra(Intent.EXTRA_SUBJECT, shareTitle)
            intent.putExtra(Intent.EXTRA_TEXT, shareBody)
            startActivity(Intent.createChooser(intent, "Bagikan tv show"))

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