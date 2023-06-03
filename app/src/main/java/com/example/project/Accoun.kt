package com.example.project

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate

class Accoun : Fragment() {
    // deklarasi request code untuk startActivityForResult
    val request_code = 1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_accoun, container, false)

        val button = view.findViewById<Button>(R.id.button4)
        button.setOnClickListener {
            val phoneNumber = "6281259481580"
            val message =
                "Haloo..." +
                        " Saya membutuhkan bantuan anda"
            val url =

                "https://api.whatsapp.com/send?phone=$phoneNumber&text=${Uri.encode(message)}"
            try {
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse(url)
                startActivity(intent)
            } catch (e: ActivityNotFoundException) {
                Toast.makeText(requireContext(), "Aplikasi WhatsApp tidak ditemukan!", Toast.LENGTH_SHORT).show()
                e.printStackTrace()
            }
        }



        // deklarasi view berdasarkan id
        val btnEdit = view.findViewById<Button>(R.id.btnNext)
        val nama = view.findViewById<TextView>(R.id.tvnameuser)

        // ketika tombol edit diklik, maka akan berpindah ke ActivityEdit
        btnEdit.setOnClickListener {
            val intent = Intent(activity, Main3::class.java)

            // mengirimkan data ke ActivityEdit
            intent.putExtra("nama", nama.text.toString())

            // memulai ActivityEdit dengan startActivityForResult
            startActivityForResult(intent, request_code)
        }
        val switchDarkMode = view.findViewById<Switch>(R.id.switch1)

        switchDarkMode.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                // Ubah ke dark mode
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            } else {
                // Ubah ke light mode
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }


        return view
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == request_code && resultCode == AppCompatActivity.RESULT_OK) {
            val nama = view?.findViewById<TextView>(R.id.tvnameuser)

            nama?.text = data?.getStringExtra("nama")
        }
    }
}
