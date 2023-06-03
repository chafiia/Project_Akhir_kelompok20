package com.example.project

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.content.ContentProviderCompat.requireContext
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textview.MaterialTextView
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class Main3 : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

// deklarasi view berdasarkan id
        val btnSubmitEditData = findViewById<Button>(R.id.btnsave)
        val inputName = findViewById<EditText>(R.id.edtName)


        // Mendapatkan nilai default dari Intent
        val nama = intent.getStringExtra("nama")


        // Menampilkan nilai default di inputan
        inputName.setText(nama)


        // ketika tombol submit diklik, maka akan kembali ke MainActivity
        btnSubmitEditData.setOnClickListener {
            val intent = intent

            // mengirimkan data ke MainActivity
            intent.putExtra("nama", inputName.text.toString())

            // mengirimkan result ke MainActivity
            setResult(RESULT_OK, intent)

            // menutup ActivityEdit
            finish()
        }
    }
}