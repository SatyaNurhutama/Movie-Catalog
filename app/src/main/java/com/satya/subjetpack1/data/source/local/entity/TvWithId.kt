package com.satya.subjetpack1.data.source.local.entity

import androidx.room.Embedded
import androidx.room.Relation

data class TvWithId(

    @Embedded
    var idTvShow: TvEntity,

    @Relation(parentColumn ="tvId", entityColumn = "tvId")
    var mTvShow : List<TvEntity>
)