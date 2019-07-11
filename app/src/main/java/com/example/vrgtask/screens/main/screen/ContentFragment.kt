package com.example.vrgtask.screens.main.screen

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.vrgtask.BuildConfig
import com.example.vrgtask.R

class ContentFragment: Fragment() {

    companion object {
        private const val PAGE_NUMBER = "${BuildConfig.APPLICATION_ID}_PAGE_NUMBER"

        fun create(page: Int): Fragment {
            val fragment = ContentFragment()
            val arguments = Bundle()
            arguments.putInt(PAGE_NUMBER, page)
            fragment.arguments = arguments
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val pageNumber = arguments?.getInt(PAGE_NUMBER)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_content, container, false)
    }
}