package com.example.laboratorio05.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

// Esto sirve para identificar que esta clase es una entidad de la base de datos.
@Entity(tableName = "movie_table")

data class MovieModel (
    @PrimaryKey(autoGenerate = true) val movieId: Int,
    // @ColumnInfo sirve para especificar el nombre de la columna para cada dato.
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "category") val category: String,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "qualification") val qualification: String
)
{
    constructor(name: String, category: String, description: String, qualification: String) :
            this(0, name, category, description, qualification)
}