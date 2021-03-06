package com.satya.subjetpack1.ui.movie

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.satya.subjetpack1.databinding.FragmentMovieBinding
import com.satya.subjetpack1.viewmodel.ViewModelFactory
import com.satya.subjetpack1.vo.Status

class MovieFragment : Fragment() {

    private lateinit var fragmentMovieBinding: FragmentMovieBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        fragmentMovieBinding = FragmentMovieBinding.inflate(layoutInflater, container, false)
        return fragmentMovieBinding.root
    }

    @SuppressLint("FragmentLiveDataObserve")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {

            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[MovieViewModel::class.java]

            val movieAdapter = MovieAdapter()

            viewModel.getMovies().observe(this, { movies ->
                if (movies != null) {
                    when (movies.status) {
                        Status.LOADING -> fragmentMovieBinding.pbMovie.visibility = View.VISIBLE
                        Status.SUCCESS -> {
                            fragmentMovieBinding.pbMovie.visibility = View.GONE
                            movieAdapter.submitList(movies.data)
                        }
                        Status.ERROR -> {
                            fragmentMovieBinding.pbMovie.visibility = View.GONE
                            Toast.makeText(context, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            })
            with(fragmentMovieBinding?.rvMovie) {
                this.layoutManager = LinearLayoutManager(context)
                this.setHasFixedSize(true)
                this.adapter = movieAdapter
            }
        }
    }

}