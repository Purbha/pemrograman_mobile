package com.example.latihan5

import android.os.Bundle
import android.os.Debug
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.io.Console

class MainActivity2 : AppCompatActivity() {

    private lateinit var buttonKembali: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        Initiate_Object()
        Listen_ButtonBack()
        val toast = Toast.makeText(this, "onCreate dipanggil", Toast.LENGTH_SHORT) // in Activity
        toast.show()
    }

    fun Initiate_Object() {
        buttonKembali = findViewById(R.id.button_Main2_Back)
    }

    fun Listen_ButtonBack() {
        buttonKembali.setOnClickListener {
            this.finish()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        val toast = Toast.makeText(this, "onDestroy dipanggil", Toast.LENGTH_SHORT) // in Activity
        toast.show()
    }
}