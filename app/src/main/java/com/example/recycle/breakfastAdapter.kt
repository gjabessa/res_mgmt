package com.example.recycle

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.recycle.model.DataModel
import com.example.recycle.model.DrinksModel
import kotlinx.android.synthetic.main.food.view.*

class BreakfastAdapter(private var dataList: List<DataModel>,val context: Context): RecyclerView.Adapter<BreakfastAdapter.ViewHolder>(){

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): BreakfastAdapter.ViewHolder {
        val inflater = LayoutInflater.from(p0.context)
        val rec = inflater.inflate(R.layout.food,p0,false)

        rec.setOnClickListener{
            val intent = Intent(context,detail::class.java)

            context.startActivity(intent)
        }
        return ViewHolder(rec)
    }

    override fun onBindViewHolder(p0: BreakfastAdapter.ViewHolder, p1: Int) {
        val food = dataList[p1]
        p0.itemView.menu_name.text = food.name+" ETB "+food.price
        Glide
            .with(context)
            .load(food.image)
            .centerCrop()
            .into(p0.itemView.menu_image);
        //p0.itemView.menu_image.setImageResource(R.drawable.d)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    class ViewHolder(viewItem: View): RecyclerView.ViewHolder(viewItem)
}