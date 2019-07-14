package com.example.vrgtask.screens.main.screen

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.vrgtask.R
import com.example.vrgtask.app.model.ArticleInfo
import kotlinx.android.synthetic.main.item_article.view.*

class ContentAdapter(private val articles: List<ArticleInfo>, private val listener: ArticleListener) :
    RecyclerView.Adapter<ContentAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContentAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_article, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = articles.size

    override fun onBindViewHolder(holder: ContentAdapter.ViewHolder, position: Int) {
        holder.title.text = articles[position].title
        holder.itemView.setOnClickListener { listener.onArticleClick(articles[position]) }
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title = itemView.title!!
    }

    interface ArticleListener {
        fun onArticleClick(articleInfo: ArticleInfo)
    }
}