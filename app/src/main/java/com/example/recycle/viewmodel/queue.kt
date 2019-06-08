package com.example.recycle.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recycle.model.DataModel
import com.example.recycle.model.Queue
import com.example.recycle.model.QueueDatabase
import com.example.recycle.repository.QueueRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class QueueView(application: Application): AndroidViewModel(application){

    private val queueRepository: QueueRepository
    val allQueues: LiveData<List<Queue>>

    init{
        val queueDao = QueueDatabase.getDatabase(application).queueDao()
        queueRepository = QueueRepository(queueDao)
        allQueues = queueRepository.allQueues()
    }

    fun insertQueue(queue: Queue) = viewModelScope.launch(Dispatchers.IO) {
        queueRepository.insertQueue(queue)
    }

    fun deleteQueue(queue: Queue) = viewModelScope.launch(Dispatchers.IO) {
        queueRepository.deleteQueue(queue)
    }
//    val queue = DataModel(name="",description = "",image = "",image_large = "",price = 0,id = "");
}