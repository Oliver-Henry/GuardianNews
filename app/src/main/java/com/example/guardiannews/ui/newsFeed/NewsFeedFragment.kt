package com.example.guardiannews.ui.newsFeed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.RequestOptions
import com.example.guardiannews.R
import com.example.guardiannews.ui.base.BaseFragment
import com.example.guardiannews.viewModel.ViewModelFactory
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import javax.inject.Inject
import javax.inject.Named

class NewsFeedFragment : BaseFragment() {

    lateinit var viewModel: NewsFeedViewModel

    @Inject
    lateinit var adapter: NewsFeedAdapter

    @Inject
    lateinit var providerFactory : ViewModelFactory

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.news_feed_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel =
                ViewModelProvider(requireActivity(), providerFactory).get(NewsFeedViewModel::class.java)

        attachObservers()
        viewModel.fetchNews()
        view?.findViewById<RecyclerView>(R.id.newsList)?.let { recyclerView ->
            recyclerView.layoutManager = LinearLayoutManager(context)
            recyclerView.adapter = adapter
        }
    }

    private fun attachObservers() {
        viewModel.loading.observe(viewLifecycleOwner, Observer { visible ->
            when (visible) {
                true -> {
                    view?.findViewById<LinearLayout>(R.id.progressBarContainer)?.visibility =
                            View.VISIBLE
                }
                else -> {
                    view?.findViewById<LinearLayout>(R.id.progressBarContainer)?.visibility =
                            View.GONE
                }
            }
        })

        viewModel.newsData.observe(viewLifecycleOwner, Observer { data ->
            data?.let {
                view?.findViewById<LinearLayout>(R.id.progressBarContainer)?.visibility = View.GONE
                adapter.data = it.response.results
            }
        })
    }

}