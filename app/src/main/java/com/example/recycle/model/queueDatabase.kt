package com.example.recycle.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database (entities = arrayOf(Queue::class), version = 1)
abstract class QueueDatabase: RoomDatabase(){
    abstract fun queueDao():QueueDao

    companion object{
        @Volatile
        private var INSTANCE: QueueDatabase? = null

        fun getDatabase(context: Context):QueueDatabase{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                        context.applicationContext,
                        QueueDatabase::class.java, "queue_database"
                        ).build()

                    INSTANCE = instance
                    return instance

            }
        }
    }
}