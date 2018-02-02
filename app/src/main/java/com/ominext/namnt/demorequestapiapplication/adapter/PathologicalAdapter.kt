package com.ominext.namnt.demorequestapiapplication.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.ominext.namnt.demorequestapiapplication.model.Pathological
import com.ominext.namnt.demorequestapiapplication.R
import kotlinx.android.synthetic.main.item_pathological.view.*

/**
 * Created by nam on 02/02/2018.
 */
class PathologicalAdapter(var pathologicals: MutableList<Pathological>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun getItemCount(): Int {
        return pathologicals.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        return PathologicalviewHolder(LayoutInflater.from(parent!!.context).inflate(R.layout.item_pathological, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        if (holder is PathologicalviewHolder) {
            holder.bind(pathologicals[position])
        }
    }

    class PathologicalviewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        fun bind(pathological: Pathological) {
            itemView.txt_id.text = pathological.id.toString()
            itemView.txt_title.text = pathological.title.toString()
            itemView.txt_detail.text = pathological.detail.toString()

        }
    }
}