package com.satya.subjetpack1.ui.detail.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.satya.subjetpack1.data.source.local.entity.MovieEntity
import com.satya.subjetpack1.databinding.ItemsMovieBinding

class DetailMovieAdapter : RecyclerView.Adapter<DetailMovieAdapter.MovieViewHolder>() {

    private val listMovies = ArrayList<MovieEntity>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val itemMovieListBinding = ItemsMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(itemMovieListBinding)
    }

    override fun onBindViewHolder(viewHolder: MovieViewHolder, position: Int) {
        val movie = listMovies[position]
        viewHolder.bind(movie)
    }

    override fun getItemCount(): Int = listMovies.size

    inner class MovieViewHolder(private val binding: ItemsMovieBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: MovieEntity) {
            binding.tvItemTitle.text = movie.title
        }
    }

}