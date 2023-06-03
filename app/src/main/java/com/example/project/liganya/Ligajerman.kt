package com.example.project.liganya

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.project.DataJadwal
import com.example.project.R
import com.example.project.adapterdata

class Ligajerman : AppCompatActivity() {

    private lateinit var recycle1: RecyclerView
    private lateinit var recycleAdapter1: adapterdata
    private lateinit var listData1: ArrayList<DataJadwal>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ligajerman)

        recycle1 = findViewById(R.id.RVligajerman)
        listData1 = ArrayList()

        val layoutManager = GridLayoutManager(this, 1)
        recycle1.layoutManager = layoutManager
        recycleAdapter1 = adapterdata(listData1, this)

        recycle1.adapter = recycleAdapter1

        listData1.add(DataJadwal("Wolfsburd", "FC Koln", "08:30PM","27 aug", R.drawable.img_25, R.drawable.img_31))
        listData1.add(DataJadwal("Dortmund", "Mainz", "08:30PM","27 aug", R.drawable.img_26, R.drawable.img_30))
        listData1.add(DataJadwal("Bayern Munich","Freiburg","08:30PM","27 aug", R.drawable.bayern_munich, R.drawable.freiburg))
        listData1.add(DataJadwal("Bochum", "Bremen", "08:30PM","27 aug", R.drawable.bochum, R.drawable.bremen))
        listData1.add(DataJadwal("Eintracht Frankfurt", "Leverkusen", "08:30PM","27 aug", R.drawable.eintracht_frankfurt, R.drawable.leverkusen))
        listData1.add(DataJadwal("RB Leipzig","Union Berlin","08:30PM","27 aug", R.drawable.rb_leipzig, R.drawable.union_berlin))
        listData1.add(DataJadwal("hoffenheim", "FC Koln", "08:30PM","27 aug", R.drawable.hoffenheim, R.drawable.img_31))
        listData1.add(DataJadwal("Monchengladbach", "Leverkusen", "08:30PM","27 aug", R.drawable.monchengladbach, R.drawable.leverkusen))




    }
}