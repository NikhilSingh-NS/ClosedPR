package com.example.myclosedprs.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myclosedprs.R
import com.example.myclosedprs.model.PRModel
import com.example.myclosedprs.network.ApiHelper
import com.example.myclosedprs.network.RetrofitBuilder
import com.example.myclosedprs.util.Status
import com.example.myclosedprs.view.adapter.Adapter
import com.example.myclosedprs.view_model.PRViewModel
import com.example.myclosedprs.view_model.ViewModelFactory


class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: PRViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var progressBar: ProgressBar
    private lateinit var adapter: Adapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeViewModel()
        initializeUI()
        getPRs()
    }

    private fun initializeViewModel() {
        viewModel = ViewModelProviders.of(
            this,
            ViewModelFactory(ApiHelper(RetrofitBuilder.apiClient))
        ).get(PRViewModel::class.java)
    }

    private fun initializeUI() {
        recyclerView = findViewById(R.id.recycler_view)
        progressBar = findViewById(R.id.progress_bar)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = Adapter(arrayListOf())
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                recyclerView.context,
                (recyclerView.layoutManager as LinearLayoutManager).orientation
            )
        )
        recyclerView.adapter = adapter
    }

    private fun getPRs() {
        viewModel.getAllClosedPRs().observe(this, Observer {
            it?.let { response ->
                when (response.status) {
                    Status.SUCCESS -> {
                        recyclerView.visibility = View.VISIBLE
                        progressBar.visibility = View.GONE
                        response.data?.let { prs -> updateUI(prs) }
                    }
                    Status.FAILURE -> {
                        recyclerView.visibility = View.VISIBLE
                        progressBar.visibility = View.GONE
                        Toast.makeText(this, it.msg, Toast.LENGTH_LONG).show()
                    }
                    Status.LOADING -> {
                        progressBar.visibility = View.VISIBLE
                        recyclerView.visibility = View.GONE
                    }
                }
            }
        })
    }

    private fun updateUI(prs: List<PRModel>) {
        adapter.apply {
            addAllPRs(prs)
            notifyDataSetChanged()
        }
    }
}