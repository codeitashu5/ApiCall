package com.ashupandey.view.click.lisner.various.views.and.learnigapicall

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.get_layout.view.*

class CustomAdapter(val list: MutableList<Data>): RecyclerView.Adapter<CustomAdapter.CustomViewHolser>() {

    class CustomViewHolser(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolser {
        val view = LayoutInflater.from(parent.context).inflate(
                R.layout.get_layout,
                parent,
                false
        )

        return CustomViewHolser(view)
    }

    override fun onBindViewHolder(holder: CustomViewHolser, position: Int) {
        holder.itemView.email.text = "Body:"+list[position].email
        holder.itemView.firstName.text = "Id: "+list[position].first_name
        holder.itemView.lastName.text = "User Id: "+list[position].last_name
    }

    override fun getItemCount(): Int {
       return list.size
    }
}