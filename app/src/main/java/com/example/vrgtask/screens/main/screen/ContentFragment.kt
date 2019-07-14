package com.example.vrgtask.screens.main.screen

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.vrgtask.BuildConfig
import com.example.vrgtask.R
import com.example.vrgtask.app.model.ArticleInfo
import com.example.vrgtask.screens.main.MainActivity
import kotlinx.android.synthetic.main.fragment_content.*
import timber.log.Timber

class ContentFragment: Fragment(), ContentAdapter.ArticleListener, MainActivity.MainListener {

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

    private var adapter: ContentAdapter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_content, container, false)
    }

    override fun onArticleClick(articleInfo: ArticleInfo) {
        //TODO
    }

    override fun dataToFragment(list: List<ArticleInfo>) {
        Timber.d("CODE IN FRAGMENT")
        adapter = ContentAdapter(list, this)
        contentRecycler.layoutManager = LinearLayoutManager(context).apply { orientation = LinearLayoutManager.VERTICAL }
        contentRecycler.adapter = adapter
    }
}