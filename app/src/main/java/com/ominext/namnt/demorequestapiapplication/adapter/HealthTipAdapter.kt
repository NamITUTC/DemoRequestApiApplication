package com.ominext.namnt.demorequestapiapplication.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.ominext.namnt.demorequestapiapplication.R
import com.ominext.namnt.demorequestapiapplication.model.HealthTip
import kotlinx.android.synthetic.main.item_health_tip.view.*

/**
 * Created by nam on 02/02/2018.
 */
class HealthTipAdapter(var tips: MutableList<HealthTip>, var iClick: IClick, var context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun getItemCount(): Int {
        return tips.size
    }

    interface IClick {
        fun itemClick(position: Int, link: String)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        if (holder is TipViewHolder) {
            holder.bind(tips.get(position), iClick, context)
            holder.itemView.setOnClickListener { iClick.itemClick(position, tips.get(position).linkDetail) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        return TipViewHolder(LayoutInflater.from(parent!!.context).inflate(R.layout.item_health_tip, parent, false))
    }

    class TipViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        fun bind(healthTip: HealthTip, iClick: IClick, context: Context) {
            itemView.txt_title.text = healthTip.title
            itemView.txt_content.text = healthTip.content
            Glide.with(context).load(healthTip.image).into(itemView.img_ava)
        }
    }
}