package com.example.recycle.retrofit
import com.example.recycle.model.DataModel
import com.example.recycle.model.OrderModel
import com.example.recycle.model.ingredients
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

interface ApiInterface{

    @GET("drinks")
    fun getDrinks(): Call<List<DataModel>>

    @GET("meals")
    fun getFoods(): Call<List<DataModel>>

    @GET("breakfasts")
    fun getBreakFast(): Call<List<DataModel>>

    @GET("lunches")
    fun getLunch(): Call<List<DataModel>>

    @GET("dinner")
    fun getDinner(): Call<List<DataModel>>

    @GET("ingredients")
    fun getIngredients(): Call<List<ingredients>>

    @POST("queues")
    fun postQueue(@Body request: RequestBody): Call<List<OrderModel>>

    @GET("orders")
    fun getOrders(): Call<List<OrderModel>>
}