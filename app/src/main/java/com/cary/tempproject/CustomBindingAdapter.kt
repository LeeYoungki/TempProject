package com.cary.tempproject

import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView

object CustomBindingAdapter {
    @BindingAdapter("setAdapter")
    @JvmStatic
    fun setAdapter(recyclerView: RecyclerView, items: List<User>?) {
        if (recyclerView.adapter == null) {
            val adapter = MainActivity.UserAdapter()
            adapter.setHasStableIds(true)   // 깜박임 방지
            recyclerView.adapter = adapter
        }

        val myAdapter = recyclerView.adapter as MainActivity.UserAdapter

        items?.let {
            myAdapter.userList = it
            myAdapter.notifyDataSetChanged()
        }
    }
}