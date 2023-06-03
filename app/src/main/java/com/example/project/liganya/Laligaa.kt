package com.example.project.liganya

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.project.DataJadwal
import com.example.project.R
import com.example.project.adapterdata

class Laligaa : AppCompatActivity() {
    private lateinit var recycle3: RecyclerView
    private lateinit var recycleAdapter3: adapterdata
    private lateinit var listData3: ArrayList<DataJadwal>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_laligaa)

        recycle3 = findViewById(R.id.idRVCourses2)
        listData3 = ArrayList()

        val layoutManager = GridLayoutManager(this, 1)
        recycle3.layoutManager = layoutManager
        recycleAdapter3 = adapterdata(listData3, this)

        recycle3.adapter = recycleAdapter3

        listData3.add(DataJadwal("Atlect bilbao", "atletico madrid", "08:00PM","27 aug", R.drawable.atletic_bilbao, R.drawable.atletico_madrid))
        listData3.add(DataJadwal("Cadiz FC", "Getafe", "08:30PM","27 aug", R.drawable.cadiz_fc, R.drawable.getafe))
        listData3.add(DataJadwal("Girona FC", "Mallorca FC", "08:30PM","27 aug", R.drawable.gironafc, R.drawable.mallorca_fc))
        listData3.add(DataJadwal("Roya Vallecano", "Real Betis", "08:00PM","27 aug", R.drawable.rayo_vallecano, R.drawable.real_betis))
        listData3.add(DataJadwal("Real Madrid", "Villareal", "08:30PM","27 aug", R.drawable.cadiz_fc, R.drawable.villareal))
        listData3.add(DataJadwal("Sevillan FC", "Velencia", "08:30PM","27 aug", R.drawable.sevilla_fc, R.drawable.valencia))

    }
}