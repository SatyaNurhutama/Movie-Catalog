package com.satya.subjetpack1.data.source.remote.response

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TvResponse(
        val tvId: String,
        val title: String,
        val synopsis: String,
        val genre: String,
        val year: String,
        val rating: String,
        val episode: String,
        val image: String
) : Parcelable