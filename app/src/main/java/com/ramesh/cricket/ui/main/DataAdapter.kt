package com.ramesh.cricket.ui.main

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ramesh.cricket.R
import com.ramesh.cricket.data.remote.response.DataList
import com.ramesh.cricket.databinding.AdapterDataBinding
import com.ramesh.cricket.ui.details.ScoreCardDetailsActivity

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
            holder.binding.textTypeStatus.text =
                dataList[position]?.matchType.plus(" | ").plus(dataList[position]?.status)
            holder.binding.textVenueDate.text =
                dataList[position]?.venue.plus(" | ").plus(dataList[position]?.date)

            Glide.with(context).load(dataList[position]?.teamInfo?.get(0)?.img).placeholder(
                R.mipmap.ic_launcher
            ).into(holder.binding.imgTeam1)
            holder.binding.tvTeam1Shortname.text = dataList[position]?.teamInfo?.get(0)?.shortname
            Glide.with(context).load(dataList[position]?.teamInfo?.get(1)?.img).placeholder(
                R.mipmap.ic_launcher
            ).into(holder.binding.imgTeam2)
            holder.binding.tvTeam2Shortname.text = dataList[position]?.teamInfo?.get(1)?.shortname

            holder.itemView.setOnClickListener {
                val id = dataList[position]?.id.toString()
                val intent = ScoreCardDetailsActivity.newIntent(
                    context,
                    id
                )
                context.startActivity(intent)
            }
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

