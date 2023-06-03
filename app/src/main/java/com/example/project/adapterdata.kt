package com.example.project


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class adapterdata (private val listJadwal: ArrayList<DataJadwal>, private val context: Context
): RecyclerView.Adapter<adapterdata.CourseViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): adapterdata.CourseViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.data,
            parent, false
        )
        return CourseViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: adapterdata.CourseViewHolder, position: Int) {
        holder.tim1.text = listJadwal.get(position).namatim1
        holder.tim2.text = listJadwal.get(position).namatim2
        holder.waktu.text = listJadwal.get(position).waktu
        holder.datee.text = listJadwal.get(position).datee
        holder.gambar1.setImageResource(listJadwal.get(position).Img1)
        holder.gambar2.setImageResource(listJadwal.get(position).Img2)
    }

    override fun getItemCount(): Int {
        return listJadwal.size
    }

    class CourseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val gambar1: ImageView = itemView.findViewById(R.id.idgambar1)
        val gambar2: ImageView = itemView.findViewById(R.id.idgambar2)
        val tim1: TextView = itemView.findViewById(R.id.tv_nama_tim_1)
        val tim2: TextView = itemView.findViewById(R.id.tv_nama_tim_2)
        val waktu: TextView = itemView.findViewById(R.id.idwaktu)
        val datee: TextView = itemView.findViewById(R.id.idtgll)

    }

}