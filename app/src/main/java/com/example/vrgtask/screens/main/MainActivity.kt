package com.example.vrgtask.screens.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.vrgtask.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var adapter: ViewPagerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViewPager()
        initView()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    private fun initViewPager() {
        adapter = ViewPagerAdapter(supportFragmentManager, this)
        container.adapter = adapter
    }

    private fun initView() {

    }

    /*private fun replaceFragment(fragment: Fragment, tag: ContentFrgEnum) {
        supportFragmentManager.beginTransaction()
                .addToBackStack(tag.name)
                .replace(R.id.container, fragment, tag.name)
                .commit()
    }*/
}
