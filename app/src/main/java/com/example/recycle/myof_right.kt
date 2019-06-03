package com.example.recycle

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.recycle.model.DrinksModel
import com.example.recycle.model.ingredients
import com.example.recycle.retrofit.ApiClient
import kotlinx.android.synthetic.main.fragment_myof_right.*
import kotlinx.android.synthetic.main.fragment_myof_right.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class myof_right : Fragment() {
    lateinit var recyclerView: RecyclerView
    var ingredientsList = ArrayList<ingredients>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_myof_right, container, false)

        recyclerView = view.ingredients
        val activity = activity as Context;
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = IngredientsAdapter(ingredientsList,activity)
        getData()


        return view

    }

    private fun getData(){
        val call: Call<List<ingredients>> = ApiClient.getClient.getIngredients()
        call.enqueue(object : Callback<List<ingredients>> {

            override fun onResponse(call: Call<List<ingredients>>?, response: Response<List<ingredients>>?) {
                //progerssProgressDialog.dismiss()
                Log.d("tagg",response.toString())
                ingredientsList.addAll(response!!.body()!!)
                recyclerView.adapter?.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<List<ingredients>>?, t: Throwable?) {
                //progerssProgressDialog.dismiss()
                Log.d("tag","er")
                Log.d("tag",t.toString())
            }
        })
    }



}
