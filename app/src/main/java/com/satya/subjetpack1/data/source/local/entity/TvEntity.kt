package com.satya.subjetpack1.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tventities")
data class TvEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "tvId")
    var tvId: String,

    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo(name = "synopsis")
    var synopsis: String,

    @ColumnInfo(name = "genre")
    var genre: String,

    @ColumnInfo(name = "year")
    var year: String,

    @ColumnInfo(name = "rating")
    var rating: String,

    @ColumnInfo(name = "episode")
    var episode: String,

    @ColumnInfo(name = "favorited")
    var favorite: Boolean = false,

    @ColumnInfo(name = "image")
    var image: String
)
