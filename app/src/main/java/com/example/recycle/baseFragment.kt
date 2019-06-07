package com.example.recycle

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.recycle.model.DataModel
import com.example.recycle.retrofit.ApiClient
import kotlinx.android.synthetic.main.fragment_base.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class baseFragment : androidx.fragment.app.Fragment() {

    private lateinit var recyclerView: androidx.recyclerview.widget.RecyclerView
    var dataList = ArrayList<DataModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_base,container,false)
        val activity = activity as Context;
        recyclerView = view.menu_list

        val category = arguments?.getSerializable("category") as Category

        recyclerView.layoutManager = androidx.recyclerview.widget.GridLayoutManager(activity, 2)
        Log.d("trtttttt",category.Title)
//        if(category.Title == "BreakFast"){
//            recyclerView.adapter = BreakfastAdapter(dataList, activity)
//            getBreakFast()
//        }
//        if(category.Title == "Lunch"){
//            recyclerView.adapter = LunchAdapter(dataList, activity)
//            getLunch()
//        }
//        if(category.Title == "Dinner"){
//            recyclerView.adapter = DinnerAdapter(dataList, activity)
//            getDinner()
//        }
        recyclerView.adapter = FoodAdapter(dataList, activity)
        if(category.Title == "Breakfast"){
            //Toast.makeText(context,"Added ", Toast.LENGTH_SHORT).show()
            getBreakFast()
        }
        else if(category.Title == "Lunch"){
            getLunch()

        } else if(category.Title == "Dinner"){
            getDinner()
        }
        else if(category.Title == "Default") {
            //Toast.makeText(context,"Added ", Toast.LENGTH_SHORT).show()
            getFoods()
        } else {
            Toast.makeText(context,"Added ", Toast.LENGTH_SHORT).show()
            getDrinks()
        }

        return view

    }

    private fun getFoods(){
        val call: Call<List<DataModel>> = ApiClient.getClient.getFoods()
        call.enqueue(object : Callback<List<DataModel>> {

            override fun onResponse(call: Call<List<DataModel>>?, response: Response<List<DataModel>>?) {
                //progerssProgressDialog.dismiss()
                Log.d("tagg",response.toString())
                dataList.addAll(response!!.body()!!)
                recyclerView.adapter?.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<List<DataModel>>?, t: Throwable?) {
                //progerssProgressDialog.dismiss()
                Log.d("tag","er")
                Log.d("tag",t.toString())
            }
        })
    }

    private fun getBreakFast(){
        val call: Call<List<DataModel>> = ApiClient.getClient.getBreakFast()
        call.enqueue(object : Callback<List<DataModel>> {

            override fun onResponse(call: Call<List<DataModel>>?, response: Response<List<DataModel>>?) {
                //progerssProgressDialog.dismiss()
                Log.d("tagg",response.toString())
                dataList.addAll(response!!.body()!!)
                recyclerView.adapter?.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<List<DataModel>>?, t: Throwable?) {
                //progerssProgressDialog.dismiss()
                Log.d("tag","er")
                Log.d("tag",t.toString())
            }
        })
    }
    private fun getLunch(){
        val call: Call<List<DataModel>> = ApiClient.getClient.getLunch()
        call.enqueue(object : Callback<List<DataModel>> {

            override fun onResponse(call: Call<List<DataModel>>?, response: Response<List<DataModel>>?) {
                //progerssProgressDialog.dismiss()
                Log.d("tagg",response.toString())
                dataList.addAll(response!!.body()!!)
                recyclerView.adapter?.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<List<DataModel>>?, t: Throwable?) {
                //progerssProgressDialog.dismiss()
                Log.d("tag","er")
                Log.d("tag",t.toString())
            }
        })
    }

    private fun getDinner(){
        val call: Call<List<DataModel>> = ApiClient.getClient.getDinner()
        call.enqueue(object : Callback<List<DataModel>> {

            override fun onResponse(call: Call<List<DataModel>>?, response: Response<List<DataModel>>?) {
                //progerssProgressDialog.dismiss()
                Log.d("tagg",response.toString())
                dataList.addAll(response!!.body()!!)
                recyclerView.adapter?.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<List<DataModel>>?, t: Throwable?) {
                //progerssProgressDialog.dismiss()
                Log.d("tag","er")
                Log.d("tag",t.toString())
            }
        })
    }

    private fun getDrinks(){
        val call: Call<List<DataModel>> = ApiClient.getClient.getDrinks()
        call.enqueue(object : Callback<List<DataModel>> {

            override fun onResponse(call: Call<List<DataModel>>?, response: Response<List<DataModel>>?) {
                //progerssProgressDialog.dismiss()
                Log.d("tagg",response.toString())
                dataList.addAll(response!!.body()!!)
                recyclerView.adapter?.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<List<DataModel>>?, t: Throwable?) {
                //progerssProgressDialog.dismiss()
                Log.d("tag","er")
                Log.d("tag",t.toString())
            }
        })
    }


    companion object {
        fun newInstance(category: Category): baseFragment {
            val args = Bundle()
            Log.d("ttaaaaaaaaaaaaaag","taag")
            args.putSerializable("category",category)

            val basefragment = baseFragment()
            basefragment.arguments = args

            return basefragment


            }
    }
}
