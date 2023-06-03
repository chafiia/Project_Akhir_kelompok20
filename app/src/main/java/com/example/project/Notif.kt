package com.example.project

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.VERTICAL
import androidx.room.Database
import com.example.project.adapter.useAdapter
import com.example.project.dat.AppData
import com.example.project.dat.entitiy.user
import com.google.android.material.floatingactionbutton.FloatingActionButton

class Notif : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var fab: FloatingActionButton
    private var list = mutableListOf<user>()
    private lateinit var adapter: useAdapter
    private lateinit var database: AppData

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_notif, container, false)
        recyclerView = view.findViewById(R.id.rvDailyActivity)
        fab = view.findViewById(R.id.btnTambah)

        database = AppData.getInstance(requireContext())
        adapter = useAdapter(list)
        adapter.setDialog(object : useAdapter.Dialog{
            override fun onClick(position: Int) {
                //buat dialog view
                val dialog = AlertDialog.Builder(requireContext())
                dialog.setTitle(list[position].title)
                dialog.setItems(R.array.item_option, DialogInterface.OnClickListener{ dialog, which->
                    if (which==0){
                        //ubah
                        val intent = Intent(requireContext(), Addjaddwal::class.java)
                        intent.putExtra("id",list[position].uid)
                        startActivity(intent)
                    }else if(which==1){
                        //hapus
                        database.userDao().delete(list[position])
                        getData()
                    }else{
                        //back
                        dialog.dismiss()
                    }
                })
                val dialogView = dialog.create()
                dialogView.show()

            }

        })


        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext(), VERTICAL, false)
        recyclerView.addItemDecoration(DividerItemDecoration(requireContext(), VERTICAL))

        fab.setOnClickListener{
            startActivity(Intent(requireContext(), Addjaddwal::class.java))
        }

        return view
    }

    override fun onResume() {
        super.onResume()
        getData()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun getData(){
        list.clear()
        list.addAll(database.userDao().getAll())
        adapter.notifyDataSetChanged()
    }
}
