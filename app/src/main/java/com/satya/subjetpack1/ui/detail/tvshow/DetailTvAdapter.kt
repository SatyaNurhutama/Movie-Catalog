package com.satya.subjetpack1.ui.detail.tvshow

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.satya.subjetpack1.data.source.local.entity.TvEntity
import com.satya.subjetpack1.databinding.ItemsTvBinding

class DetailTvAdapter : RecyclerView.Adapter<DetailTvAdapter.TvViewHolder>() {

    private val listTvShows = ArrayList<TvEntity>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvViewHolder {
        val itemTvListBinding = ItemsTvBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TvViewHolder(itemTvListBinding)
    }

    override fun onBindViewHolder(viewHolder: TvViewHolder, position: Int) {
        val tvShow = listTvShows[position]
        viewHolder.bind(tvShow)
    }

    override fun getItemCount(): Int = listTvShows.size

    inner class TvViewHolder(private val binding: ItemsTvBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(tvShow: TvEntity) {
            binding.tvTitleShows.text = tvShow.title
        }
    }

}