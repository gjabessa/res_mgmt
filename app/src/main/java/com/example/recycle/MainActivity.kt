package com.example.recycle

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.widget.*
import com.example.recycle.model.DataModel
import com.example.recycle.model.OrderModel
import com.example.recycle.retrofit.ApiClient
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    var category = listOf(
        Category("Food"),
        Category("Drinks")
    )
    var dataList = ArrayList<DataModel>()
    lateinit var recyclerView: RecyclerView
    lateinit var viewpager: ViewPager
    lateinit var pagerAdapter: pagerAdapter
    lateinit var button: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        spinner2.setOnItemSelectedListener(this)

        var aa = ArrayAdapter.createFromResource(this, R.array.type_array,android.R.layout.simple_spinner_item).also{
            adapter -> adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

            spinner2.adapter = adapter
        }
        spinner2.onItemSelectedListener = this
        button = button2
        button.setOnClickListener{
            val intent = Intent(this, drag::class.java)
            startActivity(intent)
        }
        val call: Call<List<OrderModel>> = ApiClient.getClient.getOrders()
        call.enqueue(object : Callback<List<OrderModel>> {

            override fun onResponse(call: Call<List<OrderModel>>?, response: Response<List<OrderModel>>?) {
                //progerssProgressDialog.dismiss()
                val list: List<OrderModel>? = response?.body();
                var i = 0;
                list?.forEach {
                    i+= it.price
                }
                textView2.text = i.toString()+"ETB"
            }

            override fun onFailure(call: Call<List<OrderModel>>?, t: Throwable?) {
                //progerssProgressDialog.dismiss()
                Log.d("tag","er")
                Log.d("tag",t.toString())
            }
        })
        viewpager = viewPager
        pagerAdapter = pagerAdapter(supportFragmentManager, category, Category(""))
        viewpager.adapter = pagerAdapter
        var tab = tabs
        tab.setupWithViewPager(viewpager)
    }
    override fun onItemSelected(parent: AdapterView<*>, view: View, pos: Int, id: Long) {
        Toast.makeText(this,"Addeds "+parent.selectedItem.toString(), Toast.LENGTH_SHORT).show()
        pagerAdapter = pagerAdapter(supportFragmentManager, category,Category(parent.selectedItem.toString()))
        viewpager.adapter = pagerAdapter
    }



    override fun onNothingSelected(parent: AdapterView<*>) {
        Toast.makeText(this,"Added jq", Toast.LENGTH_SHORT).show()
    }


}
