package com.myfitness.ui.main

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.myfitness.databinding.ActivityMainBinding
import com.myfitness.ui.base.BaseActivity
import com.myfitness.utils.PaginationScrollListener

class MainActivity : BaseActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val viewModel by lazy { ViewModelProvider(this)[MainViewModel::class.java] }
    private var isLoading = true
    private var page = 1
    private val arraylist = arrayListOf<com.myfitness.service.model.Result>()
    private val adapter by lazy { UserAdapter(activity, arraylist) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        viewModel.progress.observe(this) {
            isLoading = it
            if (it) {
                binding.shimmerView.visibility = View.VISIBLE
                binding.rvUsers.visibility = View.GONE
            } else {
                binding.shimmerView.visibility = View.GONE
                binding.rvUsers.visibility = View.VISIBLE
            }
        }

        viewModel.userModel.observe(this) {
            arraylist.addAll(it.results)
            adapter.notifyDataSetChanged()
        }

        binding.rvUsers.adapter = adapter

        viewModel.getUsers(appDelegate, page)

        binding.rvUsers.addOnScrollListener(object :
            PaginationScrollListener(binding.rvUsers.layoutManager as LinearLayoutManager) {
            override fun loadMoreItems() {
                page++
                viewModel.getUsers(appDelegate, page)
            }

            override fun isLastPage(): Boolean {
                return page > 5
            }

            override fun isLoading(): Boolean {
                return isLoading
            }

        })
    }
}