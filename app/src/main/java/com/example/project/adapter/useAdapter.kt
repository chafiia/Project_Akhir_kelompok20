package com.example.project.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.project.R
import com.example.project.dat.entitiy.user

class useAdapter(var list: List<user>) : RecyclerView.Adapter<useAdapter.ViewHolder>() {
    private lateinit var dialog: Dialog

    fun setDialog(dialog: Dialog){
        this.dialog = dialog
    }

    interface Dialog {
        fun onClick(position: Int)
    }

   inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        var titel: TextView
        var desc: TextView
        var timeStart: TextView

        init {
            titel = view.findViewById(R.id.tvTitleFinalValue)
            desc = view.findViewById(R.id.tvDescValueFinal)
            timeStart = view.findViewById(R.id.tvRangeTimeStartValueFinal)
            view.setOnClickListener{
                dialog.onClick(layoutPosition)

            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recycler, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.titel.text = list[position].title
        holder.desc.text = list[position].desc
        holder.timeStart.text = list[position].timeStart


    }
}