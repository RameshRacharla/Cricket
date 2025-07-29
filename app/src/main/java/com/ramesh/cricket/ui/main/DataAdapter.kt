package com.ramesh.cricket.ui.main

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ramesh.cricket.data.remote.response.DataList
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ramesh.cricket.R
import com.ramesh.cricket.data.remote.response.DataList
import com.ramesh.cricket.databinding.AdapterDataBinding

class DataAdapter(
    val context: Context, var dataList: ArrayList<DataList?>
) : RecyclerView.Adapter<DataAdapter.DataViewHolder>() {


    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): DataViewHolder {
        val binding = AdapterDataBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DataViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: DataViewHolder, position: Int
    ) {
        try {
            holder.binding.textName.text = dataList[position]?.name
            Glide.with(context).load(dataList[position]?.profile_image).placeholder(
                R.mipmap.ic_launcher
            ).into(holder.binding.imageLogo)

        } catch (e: Exception) {
            e.stackTrace
        }

    }


    fun onAddItems(list: ArrayList<DataList?>) {
        this.dataList = list
        notifyDataSetChanged()
    }


    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }


    class DataViewHolder(val binding: AdapterDataBinding) : RecyclerView.ViewHolder(binding.root) {}

}

