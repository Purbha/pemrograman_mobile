package com.example.latihan9

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class HasilActivity : AppCompatActivity() {

    private lateinit var txtNama: TextView
    private lateinit var txtGame: TextView
    private lateinit var bKembali: Button

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
        Listen_bKembali()
    }

    fun Inisial_Object() {
        txtNama = findViewById(R.id.textView_Hasil_Nama)
        txtGame = findViewById(R.id.textView_Hasil_Game)
        bKembali = findViewById(R.id.button_Hasil_Back)
    }

    fun Set_Object() {
        val dataOrang = intent.getParcelableExtra<Orang>(MainActivity.EXTRA_DATA)
        txtNama.text = "Nama saya adalah " + dataOrang?.nama
        txtGame.text = "Game favorit: " + dataOrang?.game
    }

    fun Listen_bKembali() {
        bKembali.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Konfirmasi")
                .setMessage("Apakah Anda yakin ingin kembali ke halaman sebelumnya?")
                .setPositiveButton("Ya") { dialog, _ ->
                    this.finish()
                    dialog.dismiss()
                }
                .setNegativeButton("Tidak") { dialog, _ ->
                    dialog.dismiss()
                }
                .setCancelable(false)
                .show()
        }
    }

}