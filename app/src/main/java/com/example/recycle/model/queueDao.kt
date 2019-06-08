package com.example.recycle.model

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface QueueDao{
    @Query("Select * from queue ORDER BY id")
    fun getAllQueues(): LiveData<List<Queue>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertQueue(queue: Queue): Long

    @Delete
    fun deleteQueue(queue: Queue)
}