package com.example.recycle

import android.content.Context
import android.content.Intent
import androidx.recyclerview.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.recycle.model.DataModel
import com.example.recycle.model.OrderModel
import com.example.recycle.retrofit.ApiClient
import kotlinx.android.synthetic.main.activity_detail.view.*
import kotlinx.android.synthetic.main.food.view.*
import okhttp3.MediaType
import okhttp3.RequestBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FoodAdapter(private var dataList: List<DataModel>,val context: Context): androidx.recyclerview.widget.RecyclerView.Adapter<FoodAdapter.ViewHolder>(){
    var foodList = listOf(
        Food("Coffee",R.drawable.d),
        Food("Coffee",R.drawable.d),
        Food("Coffee",R.drawable.d),
        Food("Coffee",R.drawable.d),
        Food("Coffee",R.drawable.d)
    )
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): FoodAdapter.ViewHolder {
        val inflater = LayoutInflater.from(p0.context)
        val rec = inflater.inflate(R.layout.food,p0,false)

        rec.checkBox.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                Toast.makeText(context,"Added "+dataList[p1].name,Toast.LENGTH_SHORT).show()

                    val json = JSONObject()
                    json.put("name",dataList[p1].name)
                    json.put("price",dataList[p1].price)
                    var requestBody: RequestBody = RequestBody.create(MediaType.parse("application/json"),json.toString())
                    val call: Call<List<OrderModel>> = ApiClient.getClient.postQueue(requestBody)
                    call.enqueue(object : Callback<List<OrderModel>> {

                        override fun onResponse(call: Call<List<OrderModel>>?, response: Response<List<OrderModel>>?) {
                            //progerssProgressDialog.dismiss()
                            Log.d("tagg",response.toString())
                        }

                        override fun onFailure(call: Call<List<OrderModel>>?, t: Throwable?) {
                            //progerssProgressDialog.dismiss()
                            Log.d("tag","er")
                            Log.d("tag",t.toString())
                        }
                    })

            } else {
                Toast.makeText(context,"Removed "+dataList[p1].name,Toast.LENGTH_SHORT).show()
            }

        }
        return ViewHolder(rec)
    }

    override fun onBindViewHolder(p0: FoodAdapter.ViewHolder, p1: Int) {
        val food = dataList[p1]
        p0.itemView.menu_name.text = food.name+" ETB "+food.price
        Glide
            .with(context)
            .load(food.image)
            .centerCrop()
            .into(p0.itemView.menu_image);
        //p0.itemView.menu_image.setImageResource(R.drawable.d)

        p0.itemView.setOnClickListener{
            val intent = Intent(context,detail::class.java)
            intent.putExtra("name",dataList[p1].name)
            intent.putExtra("description",dataList[p1].description)
            intent.putExtra("image_large",dataList[p1].image_large)
            intent.putExtra("price",dataList[p1].price)
            context.startActivity(intent)
        }
        p0.itemView.checkBox.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                Toast.makeText(context,"Added "+dataList[p1].name,Toast.LENGTH_SHORT).show()

//                val json = JSONObject()
//                json.put("name",dataList[p1].name)
//                json.put("price",dataList[p1].price)
//                var requestBody: RequestBody = RequestBody.create(MediaType.parse("application/json"),json.toString())
//                val call: Call<List<OrderModel>> = ApiClient.getClient.postQueue(requestBody)
//                call.enqueue(object : Callback<List<OrderModel>> {
//
//                    override fun onResponse(call: Call<List<OrderModel>>?, response: Response<List<OrderModel>>?) {
//                        //progerssProgressDialog.dismiss()
//                        Log.d("tagg",response.toString())
//                    }
//
//                    override fun onFailure(call: Call<List<OrderModel>>?, t: Throwable?) {
//                        //progerssProgressDialog.dismiss()
//                        Log.d("tag","er")
//                        Log.d("tag",t.toString())
//                    }
//                })

            } else {
                Toast.makeText(context,"Removed "+dataList[p1].name,Toast.LENGTH_SHORT).show()
            }

        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    class ViewHolder(viewItem: View): androidx.recyclerview.widget.RecyclerView.ViewHolder(viewItem)
}