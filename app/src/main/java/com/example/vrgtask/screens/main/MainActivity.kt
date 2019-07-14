package com.example.vrgtask.screens.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.view.View
import android.widget.Toast
import com.example.vrgtask.R
import com.example.vrgtask.app.App
import com.example.vrgtask.app.model.ArticleInfo
import com.example.vrgtask.screens.main.di.DaggerMainComponent
import com.example.vrgtask.screens.main.di.MainComponent
import com.example.vrgtask.screens.main.di.MainModule
import com.example.vrgtask.screens.main.screen.ContentFragment
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainContract.View {

    val component: MainComponent by lazy {
        DaggerMainComponent.builder()
                .appComponent((application as App).component)
                .activity(this)
                .plus(MainModule())
                .build()
    }

    @Inject
    lateinit var presenter: MainPresenter
    var adapter: ViewPagerAdapter? = null
    var listener: MainListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        component.inject(this)
        presenter.bindView(this)
        initViewPager()
        initView()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.unbindView()
    }

    override fun showLoading() {
        progress.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        progress.visibility = View.GONE
    }

    override fun publishData(data: List<ArticleInfo>) {
        listener?.dataToFragment(data)
    }

    override fun showMessage(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }

    private fun initViewPager() {
        adapter = ViewPagerAdapter(supportFragmentManager, this)
        container.adapter = adapter
    }

    private fun initView() {
        listener = ContentFragment()
        container.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(p0: Int) {
                //To do Nothing
            }

            override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {
                //To do Nothing
            }

            override fun onPageSelected(position: Int) {
                when (adapter?.getPageTitle(position)) {
                    getString(R.string.nav_emailed) -> presenter.onViewCreated(ArticlesTypeEnum.EMAILED)
                    getString(R.string.nav_shared) -> presenter.onViewCreated(ArticlesTypeEnum.SHARED)
                    getString(R.string.nav_viewed) -> presenter.onViewCreated(ArticlesTypeEnum.VIEWED)
                }
            }
        })
    }

    interface MainListener {
        fun dataToFragment(list: List<ArticleInfo>)
    }
}
