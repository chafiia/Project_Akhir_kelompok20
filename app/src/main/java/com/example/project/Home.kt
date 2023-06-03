package com.example.project

import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.project.liganya.Laligaa
import com.example.project.liganya.Ligaitalii
import com.example.project.liganya.Ligajerman

class Home : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)



        // jadi jika dari img di klik akan mengarah ke ctivity sesuai liganya
        val ligajerman = view.findViewById<ImageView>(R.id.imgliga1)
        ligajerman.setOnClickListener {
            val intent = Intent(requireActivity(), Ligajerman::class.java)
            startActivity(intent)
        }

        val laliga = view.findViewById<ImageView>(R.id.imgliga2)
        laliga.setOnClickListener {
            val intent = Intent(requireActivity(), Laligaa::class.java)
            startActivity(intent)
        }

        val lainggris = view.findViewById<ImageView>(R.id.imgliga3)
        lainggris.setOnClickListener {
            val intent = Intent(requireActivity(), ligainggris::class.java)
            startActivity(intent)
        }

        val ligaitali = view.findViewById<ImageView>(R.id.imgliga4)
        ligaitali.setOnClickListener {
            val intent = Intent(requireActivity(), Ligaitalii::class.java)
            startActivity(intent)
        }


        val linearLayout = view.findViewById<LinearLayout>(R.id.lyout)
        val textView = view.findViewById<TextView>(R.id.tv3)

//if jika textview berdasarkan id diklik akan memunculkan linearlayout
        textView.setOnClickListener {
            if (linearLayout.visibility == View.GONE) {
                linearLayout.visibility = View.VISIBLE
            } else {
                linearLayout.visibility = View.GONE
            }
        }

        return view
    }
}
