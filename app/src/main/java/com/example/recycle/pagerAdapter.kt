package com.example.recycle

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.widget.Toast

class pagerAdapter(fragmentManager: FragmentManager, var category:List<Category>,var exceptional:Category):FragmentStatePagerAdapter(fragmentManager){
    override fun getCount(): Int {
        return category.size
    }

    override fun getItem(p0: Int): Fragment {
        val hold = 100;
        if(exceptional.Title == "" ) {
            val hold = p0
            return baseFragment.newInstance(category[p0])
        } else {
            if(p0 == 0) {
                return baseFragment.newInstance(exceptional)
            } else if(p0 != hold){
                p0 == hold
                return baseFragment.newInstance(category[p0])
            } else {
                return baseFragment.newInstance(exceptional)
            }
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return category[position].Title
    }
}