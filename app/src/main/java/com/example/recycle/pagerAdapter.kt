package com.example.recycle

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class pagerAdapter(fragmentManager: androidx.fragment.app.FragmentManager, var category:List<Category>, var exceptional:Category):
    androidx.fragment.app.FragmentStatePagerAdapter(fragmentManager){
    override fun getCount(): Int {
        return category.size
    }

    override fun getItem(p0: Int): androidx.fragment.app.Fragment {
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