package com.example.latihan9

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var eNama: EditText
    private lateinit var bSubmit: Button
    private lateinit var bExit: Button
    private lateinit var checkGame1: CheckBox
    private lateinit var checkGame2: CheckBox
    private lateinit var checkGame3: CheckBox

    companion object {
        const val EXTRA_DATA = "extra_data"
    }

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
        Listen_bSubmit()
        Listen_bExit()
    }

    fun Inisial_Object() {
        eNama = findViewById(R.id.editText_Main_Nama)
        bSubmit = findViewById(R.id.button_Main_Submit)
        bExit = findViewById(R.id.button_Main_Exit)
        checkGame1 = findViewById(R.id.checkBox_Main_Game1)
        checkGame2 = findViewById(R.id.checkBox_Main_Game2)
        checkGame3 = findViewById(R.id.checkBox_Main_Game3)
    }

    fun Listen_bSubmit() {
        bSubmit.setOnClickListener {
            Log.d("CEK","Listen_bSubmit")
            if (cekEditTextKosong(eNama) == true) {
                Log.d("CEK","cekEditTextKosong == true")
                return@setOnClickListener
            }
            var listGame = ""
            if(checkGame1.isChecked) {
                listGame = listGame + checkGame1.text.toString() + " "
            }
            if(checkGame2.isChecked) {
                listGame = listGame + checkGame2.text.toString() + " "
            }
            if(checkGame3.isChecked) {
                listGame = listGame + checkGame3.text.toString() + " "
            }
            if(listGame.isEmpty()) {
                val strPesan = "Belum pilih game"
                Log.d("CEK",strPesan)
                val pesan = Toast.makeText(this,strPesan, Toast.LENGTH_LONG)
                pesan.show()
                return@setOnClickListener
            }
            Log.d("CEK","List Game: " + listGame)
            val strNama = eNama.text.toString()
            val dataOrang = Orang(strNama, listGame)
            val intent = Intent(this, HasilActivity::class.java)
            intent.putExtra(EXTRA_DATA, dataOrang)
            startActivity(intent)
        }
    }

    fun Listen_bExit() {
        bExit.setOnClickListener {
            Log.d("CEK","Listen_bExit")
            AlertDialog.Builder(this)
                .setTitle("Konfirmasi")
                .setMessage("Apakah Anda yakin ingin keluar?")
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

    fun cekEditTextKosong(vararg arrayEditText: EditText): Boolean {
        for (editText in arrayEditText) {
            if (editText.text.toString().trim().isEmpty()) {
                editText.error = "Field tidak boleh kosong"
                return true
            }
        }
        return false
    }

}