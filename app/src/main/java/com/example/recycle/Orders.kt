package com.example.recycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recycle.viewmodel.QueueView
import kotlinx.android.synthetic.main.activity_orders.*

class Orders : AppCompatActivity() {
    lateinit var queueView: QueueView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_orders)
        queueView = ViewModelProviders.of(this).get(QueueView::class.java)

        recycler_view.adapter = QueueAdapter(this)
        recycler_view.layoutManager = LinearLayoutManager(this)

        val queueAdapter = QueueAdapter(this)
        queueView.allQueues.observe(this, Observer{
                queue -> queue?.let{queueAdapter.setQueue(queue)}
        })
        //queueAdapter.notifyDataSetChanged()
    }

}
