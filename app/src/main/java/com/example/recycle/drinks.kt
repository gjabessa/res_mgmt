package com.example.recycle

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.recycle.model.DataModel
import kotlinx.android.synthetic.main.food.view.*

class DrinksAdapter(private var dataList: List<DataModel>,val context: Context): androidx.recyclerview.widget.RecyclerView.Adapter<DrinksAdapter.ViewHolder>(){
    var foodList = listOf(
        Food("Coffee",R.drawable.d),
        Food("Coffee",R.drawable.d),
        Food("Coffee",R.drawable.d),
        Food("Coffee",R.drawable.d),
        Food("Coffee",R.drawable.d)
    )
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): DrinksAdapter.ViewHolder {
        val inflater = LayoutInflater.from(p0.context)
        val rec = inflater.inflate(R.layout.food,p0,false)

        rec.setOnClickListener{
            val intent = Intent(context,detail::class.java)
            intent.putExtra("data","aaaaaaaaaa")
            context.startActivity(intent)
        }
        return ViewHolder(rec)
    }

    override fun onBindViewHolder(p0: DrinksAdapter.ViewHolder, p1: Int) {
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

    class ViewHolder(viewItem: View): androidx.recyclerview.widget.RecyclerView.ViewHolder(viewItem)
}