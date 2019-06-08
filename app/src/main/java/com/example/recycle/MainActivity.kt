package com.example.recycle

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.*
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.recycle.model.DataModel
import com.example.recycle.model.OrderModel
import com.example.recycle.model.Queue
import com.example.recycle.retrofit.ApiClient
import com.example.recycle.viewmodel.QueueView
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    var category = listOf(
        Category("Food"),
        Category("Drinks")
    )
    var dataList = ArrayList<DataModel>()
    lateinit var recyclerView: androidx.recyclerview.widget.RecyclerView
    lateinit var viewpager: androidx.viewpager.widget.ViewPager
    lateinit var pagerAdapter: pagerAdapter
    lateinit var button: Button
    lateinit var order_button: Button
    lateinit var queueView: QueueView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        spinner2.setOnItemSelectedListener(this)

        queueView = ViewModelProviders.of(this).get(QueueView::class.java)
        //val model = ViewModelProviders.of(this).get(QueueView::class.java)

        var aa = ArrayAdapter.createFromResource(this, R.array.type_array,android.R.layout.simple_spinner_item).also{
            adapter -> adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

            spinner2.adapter = adapter
        }
        //val queueAdapter = QueueAdapter(this)
//        queueView.allQueues.observe(this, Observer {
//                queue -> queue?.let{queueAdapter.setQueue(queue)}
//        })
        spinner2.onItemSelectedListener = this
        button = button2
        button.setOnClickListener{
            val intent = Intent(this, drag::class.java)
            startActivity(intent)
        }
        order_button = order_btn
        order_button.setOnClickListener{
            val intent = Intent(this, Orders::class.java)
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
                total_price.text = i.toString()+"ETB"
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


    fun updateTP(value: Int){
        total_price.text = value.toString()
    }

    fun insertQueue(value: Queue){
        Log.d("tag",value.toString())
        queueView.insertQueue(value)
    }
    override fun onNothingSelected(parent: AdapterView<*>) {
        Toast.makeText(this,"Added jq", Toast.LENGTH_SHORT).show()
    }


}
