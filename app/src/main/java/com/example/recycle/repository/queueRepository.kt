package com.example.recycle.repository

import androidx.lifecycle.LiveData
import com.example.recycle.model.Queue
import com.example.recycle.model.QueueDao

class QueueRepository(private val queueDao: QueueDao){
    fun allQueues(): LiveData<List<Queue>> = queueDao.getAllQueues()

    fun insertQueue(queue:Queue){
        queueDao.insertQueue(queue)
    }


}