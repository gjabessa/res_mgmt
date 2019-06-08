package com.example.recycle.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity (tableName = "queue")
data class Queue(
    @PrimaryKey @ColumnInfo(name = "id") val id:String,
    @ColumnInfo(name="name") val name: String,
    @ColumnInfo(name="image") val image: String,
    @ColumnInfo(name="price") val price: Int,
    @ColumnInfo(name="amount") var amount: Int
):Serializable
