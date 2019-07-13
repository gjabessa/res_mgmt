package com.example.recycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail.*

class detail : AppCompatActivity() {

    lateinit var title: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        if(savedInstanceState == null) {
            name.text= intent.getStringExtra("name")
            price.text = intent.getIntExtra("price",0).toString()
            description.text = intent.getStringExtra("description")
            Glide
                .with(this)
                .load(intent.getStringExtra("image_large"))
                .centerCrop()
                .into(m);
            }
    }
}
