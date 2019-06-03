package com.example.recycle

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.recycle.model.ingredients
import kotlinx.android.synthetic.main.food.view.*

class IngredientsAdapter(private var dataList: List<ingredients>,val context: Context): RecyclerView.Adapter<IngredientsAdapter.ViewHolder>(){

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(p0: IngredientsAdapter.ViewHolder, p1: Int) {
        val ingredient = dataList[p1]
        p0.itemView.menu_name.text = ingredient.name

        Glide
            .with(context)
            .load(ingredient.image)
            .centerCrop()
            .into(p0.itemView.menu_image);

    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): IngredientsAdapter.ViewHolder {
        val inflater = LayoutInflater.from(p0.context)
        val rec = inflater.inflate(R.layout.food,p0,false)

        return ViewHolder(rec)
    }

    class ViewHolder(viewItem: View): RecyclerView.ViewHolder(viewItem)
}