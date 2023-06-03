package com.example.project.liganya

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.project.DataJadwal
import com.example.project.R
import com.example.project.adapterdata

class Ligaitalii : AppCompatActivity() {

    private lateinit var recycle4: RecyclerView
    private lateinit var recycleAdapter4: adapterdata
    private lateinit var listData4: ArrayList<DataJadwal>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ligaitalii)

        recycle4 = findViewById(R.id.RVligaitali)
        listData4 = ArrayList()

        val layoutManager = GridLayoutManager(this, 1)
        recycle4.layoutManager = layoutManager
        recycleAdapter4 = adapterdata(listData4, this)

        recycle4.adapter = recycleAdapter4
        listData4.add(DataJadwal("Leeds United", "Liverpool", "01:36AM","27 aug", R.drawable.img_7, R.drawable.img_11))
        listData4.add(DataJadwal("AC Milan", "Sampdoria", "05:36PM","27 aug", R.drawable.img_27, R.drawable.img_23))
        listData4.add(DataJadwal("Atalanta", "Udinese", "08:00PM","27 aug", R.drawable.img_29, R.drawable.img_32))
        listData4.add(DataJadwal("Napoli", "Udinese", "08:00PM","27 aug", R.drawable.img_22, R.drawable.img_32))
        listData4.add(DataJadwal("Atalanta", "Juventus", "08:00PM","27 aug", R.drawable.img_29, R.drawable.img_21))
        listData4.add(DataJadwal("Atalanta", "Udinese", "08:00PM","27 aug", R.drawable.img_29, R.drawable.img_32))

    }
}