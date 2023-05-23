package com.example.afinal.presentation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.afinal.R
import com.example.afinal.databinding.HeadlineListItemsBinding
import com.example.domain.model.Article
import com.example.domain.model.NewsResponse

class NewsAdapter : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {
    private lateinit var binding:HeadlineListItemsBinding
    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsAdapter.ViewHolder {
        var inflater = LayoutInflater.from(parent.context)
        binding=HeadlineListItemsBinding.inflate(inflater,parent,false)
        context=parent.context
        return ViewHolder()
    }

    override fun onBindViewHolder(holder: NewsAdapter.ViewHolder, position: Int) {
        holder.binding(differ.currentList[position])
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    inner class ViewHolder : RecyclerView.ViewHolder(binding.root){
        fun  binding(item: Article){
            binding.apply {
                text_title.text=item.title
                text_source.text=item.source
                val moviePosterURL=item.urlToImage
                img_headline.load(moviePosterURL){
                    crossfade(true)
                    placeholder(R.drawable.poster_placeholder)
                    scale(coil.size.Scale.FILL)
                }
            }
        }
    }

    private val differCallback= object :  DiffUtil.ItemCallback<NewsResponse>(){
        override fun areItemsTheSame(
            oldItem: NewsResponse,
            newItem: NewsResponse
        ): Boolean {
            return oldItem.id==newItem.id
        }

        override fun areContentsTheSame(
            oldItem: NewsResponse,
            newItem: NewsResponse
        ): Boolean {
            return oldItem==newItem
        }
    }

    var differ=AsyncListDiffer(this,differCallback)

}