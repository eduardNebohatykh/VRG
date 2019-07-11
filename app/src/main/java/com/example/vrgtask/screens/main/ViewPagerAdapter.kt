package com.example.vrgtask.screens.main

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.example.vrgtask.R
import com.example.vrgtask.screens.main.screen.ContentFragment

class ViewPagerAdapter(fm: FragmentManager, private val context: Context) : FragmentPagerAdapter(fm) {

    companion object {
        private const val PAGE_NUM = 3
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position) {
            0 -> context.getString(R.string.nav_emailed)
            1 -> context.getString(R.string.nav_shared)
            2 -> context.getString(R.string.nav_viewed)
            else -> ""
        }
    }

    override fun getItem(position: Int): Fragment = ContentFragment.create(position)

    override fun getCount() = PAGE_NUM
}