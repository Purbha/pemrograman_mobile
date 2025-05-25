package com.example.latihan6

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    private lateinit var ePanjang: EditText
    private lateinit var eLebar: EditText
    private lateinit var bHitung: Button
    private lateinit var tHasil: TextView
    private val STATE_RESULT = "state_result"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initiate_Object()
        Listen_bHitung()
        if(savedInstanceState != null) {
            val result = savedInstanceState.getString(STATE_RESULT).toString()
            Log.d("CEK savedInstanceState",result)
            tHasil.text = savedInstanceState.getString(STATE_RESULT)
        }
    }

    fun initiate_Object() {
        ePanjang = findViewById(R.id.editText_Main_Panjang)
        eLebar = findViewById(R.id.editText_Main_Lebar)
        bHitung = findViewById(R.id.button_Main_Hitung)
        tHasil = findViewById(R.id.textView_Main_Hasil)
    }

    fun Listen_bHitung() {
        bHitung.setOnClickListener {
            val panjang = ePanjang.text.toString().trim()
            val lebar = eLebar.text.toString().trim()
            var inputKosong = false
            if(panjang.isEmpty()) {
                ePanjang.error = "Panjang tidak boleh kosong"
                inputKosong = true
            }
            if(lebar.isEmpty()) {
                eLebar.error = "Lebar tidak boleh kosong"
                inputKosong = true
            }
            if(!inputKosong){
                val luas: Int = panjang.toInt() * lebar.toInt()
                tHasil.text = luas.toString()
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val result = tHasil.text.toString()
        Log.d("CEK onSaveInstanceState",result)
        outState.putString(STATE_RESULT,result)
    }

}