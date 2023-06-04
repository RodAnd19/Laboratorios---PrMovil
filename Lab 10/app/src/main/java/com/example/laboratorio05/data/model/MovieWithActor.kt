package com.example.laboratorio05.data.model

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation


data class MovieWithActor(
    // @Embedded indica que los atributos seran incrustados directamente en la colummna resultante.
    @Embedded val movie : MovieModel,
    // @Relation establece una relación entre entidades de ROOM.
    @Relation(
        parentColumn = "movieId",
        entityColumn = "actorId",
        associateBy = Junction(CastModel::class)
    )
    val actors : List<ActorModel>
)
