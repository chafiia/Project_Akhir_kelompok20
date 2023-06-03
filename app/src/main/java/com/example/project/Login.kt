package com.example.project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textview.MaterialTextView

class Login : AppCompatActivity() {
    //user dan pass yang harus dimasukkan
    private val usernameUser = "admin"
    private val passwordUser = "kelompok20"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

            val edtUsername = findViewById<TextInputEditText>(R.id.edtUsername)
            val edtPassword = findViewById<TextInputEditText>(R.id.edtPassword)
            val cbTampil = findViewById<CheckBox>(R.id.cbTampil)
            val button = findViewById<Button>(R.id.button)

        //checkbox jika dikik, password akan di hide
            cbTampil.setOnCheckedChangeListener { compoundButton, isChecked ->
                if (isChecked) {
                    edtPassword.transformationMethod = HideReturnsTransformationMethod.getInstance()
                } else {
                    edtPassword.transformationMethod = PasswordTransformationMethod.getInstance()
                }
            }

            //button login untuk memunculkan toast jika user pass kosong
            button.setOnClickListener {
                val usernameInput = edtUsername.text.toString()
                val passwordInput = edtPassword.text.toString()

                if (usernameInput == "") {
                    Toast.makeText(this, "Username tidak boleh kosong", Toast.LENGTH_SHORT).show()
                } else if (passwordInput == "") {
                    Toast.makeText(this, "Password tidak boleh kosong", Toast.LENGTH_SHORT).show()
                } else {
                    // memunculkan toast jika username pass salah
                    if (usernameInput != usernameUser) {
                        Toast.makeText(this, "Username salah", Toast.LENGTH_SHORT).show()
                    } else if (passwordInput != passwordUser) {
                        Toast.makeText(this, "Password salah", Toast.LENGTH_SHORT).show()
                    } else {
                        val intent = Intent(this, Main2::class.java)
                        startActivity(intent)
                        finish()
                    }
                }
            }
        }

    }