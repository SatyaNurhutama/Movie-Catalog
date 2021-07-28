package com.satya.subjetpack1.ui.favorite

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.satya.subjetpack1.ui.favorite.favoritemovie.FavoriteMovieFragment
import com.satya.subjetpack1.ui.favorite.favoritetv.FavoriteTvShowFragment

class SectionsPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                FavoriteMovieFragment()
            }
            else -> {
                return FavoriteTvShowFragment()
            }
        }
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence {
        return when (position) {
            0 -> "Movie"
            else -> {
                return "TvShow"
            }
        }
    }

}