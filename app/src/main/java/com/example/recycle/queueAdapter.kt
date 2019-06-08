package com.example.recycle

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recycle.model.Queue
import kotlinx.android.synthetic.main.food.view.*
import kotlinx.android.synthetic.main.order.view.*

class QueueAdapter(val context: Context): RecyclerView.Adapter<QueueAdapter.QueueViewHolder>(){
    private var QueueList: List<Queue> = emptyList()
    private val inflater = LayoutInflater.from(context)
    override fun getItemCount() = QueueList.size

    override fun onBindViewHolder(holder: QueueViewHolder, position: Int) {
        val queue = QueueList[position]
        Glide
            .with(context)
            .load(queue.image)
            .centerCrop()
            .into(holder.itemView.imager)
        holder.itemView.order_name.text = queue.name
        holder.itemView.price.text = queue.price.toString()
        holder.itemView.textView7.text = queue.amount.toString()
        holder.itemView.addButton.setOnClickListener{
            queue.amount += 1;
            Log.d("tag",queue.toString())
            (context as Orders).insertQueue(queue)
//            notifyDataSetChanged()
        }
        holder.itemView.undoButton.setOnClickListener{
            if(queue.amount > 1) {
                queue.amount -= 1
                (context as Orders).insertQueue(queue)
            } else {
                (context as Orders).deleteQueue(queue)
            }
//            notifyDataSetChanged()
        }
    }

    internal fun setQueue(queues: List<Queue>){
        this.QueueList = queues
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QueueViewHolder {
        val recyclerViewItem = inflater.inflate(R.layout.order,parent,false)

        return QueueViewHolder(recyclerViewItem)
    }

    class QueueViewHolder(itemView:View): RecyclerView.ViewHolder(itemView){

    }
}