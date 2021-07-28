package com.satya.subjetpack1.data.source.local.entity

import androidx.room.Embedded
import androidx.room.Relation

data class MovieWithId(
    @Embedded
    var idMovie: MovieEntity,

    @Relation(parentColumn = "movieId", entityColumn = "movieId")
    var mMovies: List<MovieEntity>
)