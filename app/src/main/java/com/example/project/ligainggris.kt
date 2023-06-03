package com.example.project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ligainggris : AppCompatActivity() {

    lateinit var recycle2: RecyclerView
    lateinit var recycleAdapter2: adapterdata
    lateinit var listData2: ArrayList<DataJadwal>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_liga_inggris)


        recycle2 = findViewById(R.id.RVligainggris)
        listData2 = ArrayList()

        val layoutManager = GridLayoutManager(this, 1)
        recycle2.layoutManager = layoutManager
        recycleAdapter2 = adapterdata(listData2, this)

        recycle2.adapter = recycleAdapter2
        listData2.add(DataJadwal("Tottenham", "Bournemouth", "11:53AM","21 aug", R.drawable.img_14, R.drawable.img_15))
        listData2.add(DataJadwal("Everton", "Fulham", "11:59PM","22 aug", R.drawable.img_16, R.drawable.img_17))
        listData2.add(DataJadwal("Chelsea", "Brighton", "06:57PM","23 aug", R.drawable.img, R.drawable.img_6))
        listData2.add(DataJadwal("Manchester City", "Leicester City", "10:40AM","24 aug", R.drawable.img_1, R.drawable.img_7))
        listData2.add(DataJadwal("West Ham", "Arsenal", "00:31PM","26 aug", R.drawable.img_8, R.drawable.img_9))
        listData2.add(DataJadwal("Nottingham Forest", "Manchester United", "10:20PM","26 aug", R.drawable.img_10, R.drawable.img_11))
        listData2.add(DataJadwal("Leeds United", "Liverpool", "01:36AM","27 aug", R.drawable.img_12, R.drawable.img_13))



    }
}