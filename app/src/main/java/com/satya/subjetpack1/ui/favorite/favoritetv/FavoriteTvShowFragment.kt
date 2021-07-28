package com.satya.subjetpack1.ui.favorite.favoritetv

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.satya.subjetpack1.R
import com.satya.subjetpack1.databinding.FragmentFavoriteTvShowBinding
import com.satya.subjetpack1.ui.favorite.favoritemovie.FavoriteMovieAdapter
import com.satya.subjetpack1.ui.favorite.favoritemovie.FavoriteMovieViewModel
import com.satya.subjetpack1.viewmodel.ViewModelFactory

class FavoriteTvShowFragment : Fragment() {

    private var _fragmentFavoriteBinding: FragmentFavoriteTvShowBinding? = null
    private val binding get() = _fragmentFavoriteBinding

    private lateinit var viewModel: FavoriteTvShowViewModel
    private lateinit var adapter: FavoriteTvAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        _fragmentFavoriteBinding = FragmentFavoriteTvShowBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        itemTouchHelper.attachToRecyclerView(binding?.rvFavTvShow)
        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            viewModel = ViewModelProvider(this, factory)[FavoriteTvShowViewModel::class.java]

            adapter = FavoriteTvAdapter()
            binding?.pbFavTvShow?.visibility = View.VISIBLE
            viewModel.getTvShows().observe(viewLifecycleOwner, { tvShows ->
                binding?.pbFavTvShow?.visibility = View.GONE
                adapter.submitList(tvShows)
            })

            binding?.rvFavTvShow?.layoutManager = LinearLayoutManager(context)
            binding?.rvFavTvShow?.setHasFixedSize(true)
            binding?.rvFavTvShow?.adapter = adapter
        }
    }

    private val itemTouchHelper = ItemTouchHelper(object : ItemTouchHelper.Callback() {

        override fun getMovementFlags(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder): Int =
            makeMovementFlags(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT)

        override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean = true

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            if (view != null) {
                val swipedPosition = viewHolder.adapterPosition
                val tvEntity = adapter.getSwipedData(swipedPosition)
                tvEntity?.let { viewModel.setFavorite(it) }

                val snackbar = Snackbar.make(view as View, R.string.remove_undo, Snackbar.LENGTH_LONG)
                snackbar.setAction(R.string.remove_ok) { v ->
                    tvEntity?.let { viewModel.setFavorite(it) }
                }
                snackbar.show()
            }
        }
    })
}