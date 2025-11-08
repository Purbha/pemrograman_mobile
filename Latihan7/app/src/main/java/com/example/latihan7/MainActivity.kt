package com.example.latihan7

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    /*
    Dalam Kotlin companion object adalah fitur yang memungkinkan kita mendefinisikan
        anggota statis dalam sebuah kelas—mirip dengan static di Java.
        Tapi karena Kotlin tidak memiliki keyword static,
        maka companion object digunakan sebagai gantinya.
    Anggota dalam companion object bisa diakses langsung melalui nama kelas,
        tanpa perlu membuat objek dari kelas tersebut.
    */
    companion object {
        const val EXTRA_ALAS = "extra_alas"
        const val EXTRA_TINGGI = "extra_tinggi"
    }

    private lateinit var eAlas: EditText
    private lateinit var eTinggi: EditText
    private lateinit var bHitung: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        Inisial_Object()
        Listen_bHitung()
    }
    fun Inisial_Object() {
        eAlas = findViewById(R.id.editText_Main_Alas)
        eTinggi = findViewById(R.id.editText_Main_Tinggi)
        bHitung = findViewById(R.id.button_Main_Hitung)
    }

    fun Listen_bHitung() {
        bHitung.setOnClickListener {
            Log.d("CEK","Listen_bHitung")
            val alas = eAlas.text.toString()
            val tinggi = eTinggi.text.toString()
            var pesanError = ""
            if(alas.isEmpty()) {
                pesanError = "Alas segitiga tidak boleh kosong"
                Log.d("CEK",pesanError)
                eAlas.error = pesanError
                return@setOnClickListener
            }
            if(tinggi.isEmpty()) {
                pesanError = "Tinggi segitiga tidak boleh kosong"
                Log.d("CEK",pesanError)
                eTinggi.error = pesanError
                return@setOnClickListener
            }
            Log.d("CEK","GoTo Luas")
            val callLuas = Intent(this, LuasActivity::class.java)
            callLuas.putExtra(EXTRA_ALAS, alas)
            callLuas.putExtra(EXTRA_TINGGI, tinggi)
            startActivity(callLuas)
        }
    }

}