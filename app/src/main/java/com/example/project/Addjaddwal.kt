package com.example.project

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.project.dat.AppData
import com.example.project.dat.entitiy.user
import java.util.*

// ini adalah activity 2 (kedua) kalau berdasarkan modul

class Addjaddwal : AppCompatActivity() {

//    // deklarasi repository
//    private lateinit var mDailyActivityRepository: DailyActivityRepository
//
//    // deklarasi id untuk menentukan apakah data akan diupdate atau ditambahkan
//    private var getId by Delegates.notNull<Int>()
//    private var status by Delegates.notNull<Boolean>()

    // deklarasi variabel beserta tipe view yang akan digunakan
    private lateinit var edtTitle: EditText
    private lateinit var edtDesc: EditText
    private lateinit var editStartTime: EditText
    private lateinit var btnsave: Button
    private lateinit var database: AppData


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addjaddwal)

        edtTitle = findViewById(R.id.edtTitle)
        edtDesc = findViewById(R.id.edtDesc)
        editStartTime = findViewById(R.id.editStartTime)
        btnsave = findViewById(R.id.btnSubmit)

        database = AppData.getInstance(applicationContext)

        var intent = intent.extras
        if (intent!=null){
            val id = intent.getInt("id", 0)
            var user = database.userDao().get(id)

            edtTitle.setText(user.title)
            edtDesc.setText(user.desc)
            editStartTime.setText(user.timeStart)
        }

        btnsave.setOnClickListener {
            if (edtTitle.text.length > 0 && edtDesc.text.length > 0 && editStartTime.text.length > 0) {
                if(intent!=null){
                    //edit
                    database.userDao().update(
                        user(
                            intent.getInt("id",0),
                            edtTitle.text.toString(),
                            edtDesc.text.toString(),
                            editStartTime.text.toString()

                        )
                    )

                }else{
                    //button tambah data
                    database.userDao().insertAll(
                        user(
                            null,
                            edtTitle.text.toString(),
                            edtDesc.text.toString(),
                            editStartTime.text.toString()

                        )
                    )
                }
                finish()
            } else {
                Toast.makeText(
                    applicationContext,
                    "Silahkan isi semua data dengan benar",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }


    }
    // fungsi untuk menampilkan date picker jika time start di klik
    fun showTimeStart(view: View?) {
        showDateTimePicker(editStartTime)
    }

    // fungsi untuk menampilkan date picker
    private fun showDateTimePicker(editText: EditText) {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)

        val datePickerDialog =
            DatePickerDialog(this, { _, selectedYear, selectedMonth, selectedDay ->
                val timePickerDialog = TimePickerDialog(this, { _, selectedHour, selectedMinute ->
                    val formattedDate = String.format(
                        "%02d/%02d/%04d",
                        selectedDay,
                        selectedMonth + 1,
                        selectedYear)
                    val formattedTime = String.format("%02d:%02d", selectedHour, selectedMinute)
                    val dateTime = "$formattedDate $formattedTime"

                    editText.setText(dateTime)
                }, hour, minute, true)
                timePickerDialog.show()
            }, year, month, day)
        datePickerDialog.show()
    }


}