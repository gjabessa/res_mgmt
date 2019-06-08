package com.example.recycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recycle.model.Queue
import com.example.recycle.viewmodel.QueueView
import kotlinx.android.synthetic.main.activity_orders.*

class Orders : AppCompatActivity() {
    lateinit var queueView: QueueView
    lateinit var checkoutB: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_orders)
        queueView = ViewModelProviders.of(this).get(QueueView::class.java)

        val queueAdapter = QueueAdapter(this)
        recycler_view.adapter = queueAdapter
        recycler_view.layoutManager = LinearLayoutManager(this)

        queueView.allQueues.observe(this, Observer{
                queue -> queue?.let{queueAdapter.setQueue(queue)}
        })
        checkoutB = checkout
        checkout.setOnClickListener{
            var builder = AlertDialog.Builder(this)

            builder.setTitle("Are you sure you want to proceed?")
            builder.setPositiveButton("YES"){dialog, which ->
                Toast.makeText(this,"Order assigned ", Toast.LENGTH_SHORT).show()
            }
            builder.setNegativeButton("No"){dialog, which ->
                Toast.makeText(this,"checkout cancelled ", Toast.LENGTH_SHORT).show()
            }
            builder.setNeutralButton("Cancel"){dialog, which ->
                Toast.makeText(this,"checkout cancelled ", Toast.LENGTH_SHORT).show()
            }
            builder.create()
            builder.show()
        }
        //queueAdapter.notifyDataSetChanged()

    }

    fun insertQueue(value: Queue){
        Log.d("taog",value.toString())
        queueView.insertQueue(value)
    }
    fun deleteQueue(value:Queue){
        queueView.deleteQueue(value)
    }

}
