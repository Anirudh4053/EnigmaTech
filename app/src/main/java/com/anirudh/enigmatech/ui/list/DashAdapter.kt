package com.anirudh.enigmatech.ui.list

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.anirudh.enigmatech.R
import com.anirudh.enigmatech.data.model.User
import kotlinx.android.synthetic.main.custom_item.view.*

class DashAdapter(private var context: Context, private var userList: List<User>,
                  private var onItemClick:(item: User)->Unit = {}): RecyclerView.Adapter<DashAdapter.CommentsHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentsHolder{
        val view = LayoutInflater.from(parent.context).inflate(
                R.layout.custom_item, parent,
                false)
        return CommentsHolder(view)
    }

    override fun getItemCount(): Int = userList.size

    override fun onBindViewHolder(holder: CommentsHolder, position: Int) {
        val item = userList[position]
        holder.itemView.titleTV.text = "${item.fname} ${item.lname}"
        holder.itemView.ageTV.text = "${item.age} yr"
        holder.itemView.setOnClickListener {
            onItemClick(item)
        }

    }

    class CommentsHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}