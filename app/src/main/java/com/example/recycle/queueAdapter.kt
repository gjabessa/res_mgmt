package com.example.recycle

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recycle.model.Queue
import kotlinx.android.synthetic.main.food.view.*
import kotlinx.android.synthetic.main.order.view.*

class QueueAdapter(val context: Context): RecyclerView.Adapter<QueueAdapter.QueueViewHolder>(){
    private var QueueList: List<Queue> = listOf(
        Queue("111","hello","image",12)
    )
    private val inflater = LayoutInflater.from(context)
    override fun getItemCount() = QueueList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QueueViewHolder {
        val recyclerViewItem = inflater.inflate(R.layout.order,parent,false)

        return QueueViewHolder(recyclerViewItem)
    }

    override fun onBindViewHolder(holder: QueueViewHolder, position: Int) {
        val queue = QueueList[position]
        Log.d("zzzzzzzzzzzzz",QueueList.toString())
        Log.d("tttt",QueueList.toString())
        holder.itemView.order_name.text = queue.name
        holder.itemView.price.text = queue.price.toString()

    }

    internal fun setQueue(queues: List<Queue>){
        Log.d("taaag",queues.toString())
        this.QueueList = queues
        Log.d("aaaaaad",QueueList.toString())
        notifyDataSetChanged()
    }


    class QueueViewHolder(itemView:View): RecyclerView.ViewHolder(itemView){

    }
}