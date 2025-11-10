package com.example.latihan8

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class HasilActivity : AppCompatActivity() {

    private lateinit var txtNama: TextView
    private lateinit var txtEmail: TextView
    private lateinit var txtMakanan: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_hasil)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        Inisial_Object()
        Set_Object()
    }

    fun Inisial_Object() {
        txtNama = findViewById(R.id.textView_Hasil_Nama)
        txtEmail = findViewById(R.id.textView_Hasil_Email)
        txtMakanan = findViewById(R.id.textView_Hasil_Makanan)
    }

    fun Set_Object() {
        txtNama.text = "Nama saya adalah " +
                intent.getStringExtra(MainActivity.EXTRA_NAMA)
        txtEmail.text = "Email saya adalah " +
                intent.getStringExtra(MainActivity.EXTRA_EMAIL)
        txtMakanan.text = "Kesukaan saya adalah makan " +
                intent.getStringExtra(MainActivity.EXTRA_MAKANAN)
    }

}