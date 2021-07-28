package com.satya.subjetpack1.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movieentities")
data class MovieEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "movieId")
    var movieId: String,

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

    @ColumnInfo(name = "duration")
    var duration: String,

    @ColumnInfo(name = "favorited")
    var favorite: Boolean = false,

    @ColumnInfo(name = "image")
    var image: String, )