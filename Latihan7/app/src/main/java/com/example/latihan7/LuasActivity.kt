package com.example.latihan7

import android.content.Intent
import android.os.Bundle
import android.os.Debug
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LuasActivity : AppCompatActivity() {

    private lateinit var txtLuas: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_luas)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        Inisial_Object()
        Set_Object()
    }

    fun Inisial_Object() {
        txtLuas = findViewById(R.id.textView_Luas_Hasil)
    }

    fun Set_Object() {
        val alas = intent.getStringExtra(MainActivity.EXTRA_ALAS)
        val tinggi = intent.getStringExtra(MainActivity.EXTRA_TINGGI)

        /*
        Kotlin tidak mengizinkan pemanggilan fungsi seperti toInt() langsung pada tipe
            nullable tanpa penanganan eksplisit.
        ?.toIntOrNull() akan mencoba konversi jika alas tidak null dan valid sebagai angka.
        ?: 0 akan memberikan nilai default 0 jika alas null atau bukan angka valid.
        */
        val nilaiAlas: Int = alas?.toIntOrNull() ?: 0
        val nilaiTinggi: Int = tinggi?.toIntOrNull() ?: 0

        val nilaiLuas: Double = (nilaiAlas * nilaiTinggi) * 0.5
        txtLuas.text = "Luas Segitiga: " + nilaiLuas.toString()
    }

}