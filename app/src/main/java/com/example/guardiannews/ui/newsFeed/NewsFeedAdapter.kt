package com.example.guardiannews.ui.newsFeed

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.text.HtmlCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.RequestOptions
import com.example.guardiannews.R
import com.example.guardiannews.model.Results
import javax.inject.Inject


class NewsFeedAdapter : RecyclerView.Adapter<NewsFeedAdapter.NewsFeedItemViewHolder>() {

    @Inject
    lateinit var requestManager: RequestManager

    private val list = mutableListOf<Results>()
    var data: List<Results>
        get() = list.toList()
        set(value) {
            list.clear()
            list.addAll(value)
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsFeedItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.news_feed_item,
            parent,
            false
        )
        return NewsFeedItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsFeedItemViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    class NewsFeedItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: Results) {
            itemView.findViewById<TextView>(R.id.title).text = item.fields.headline
            itemView.findViewById<TextView>(R.id.subTitle).text = HtmlCompat.fromHtml(
                item.fields.trailText, 0
            )

            itemView.findViewById<ImageView>(R.id.thumbnail)?.let { imageView ->

                val requestOptions = RequestOptions
                        .placeholderOf(R.drawable.image_background)
                        .error(R.drawable.image_background)
                
                Glide.with(itemView.context).setDefaultRequestOptions(requestOptions)
                    .load(item.fields.thumbnail)
                    .into(imageView)
            }
        }
    }

}