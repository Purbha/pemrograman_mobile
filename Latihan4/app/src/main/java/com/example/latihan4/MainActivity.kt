package com.example.latihan4

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // finding the button
        val clickMeButton = findViewById<Button>(R.id.button_Main_Btn1)
        val submitButton = findViewById<Button>(R.id.button_Main_Btn2)
        val editText_Main = findViewById<EditText>(R.id.editText_Main_Nama)

        val text = "Ini adalah contoh Toast"
        val duration = Toast.LENGTH_LONG
        val nama = editText_Main.text

        //Setting the onClick listener to the button
        clickMeButton.setOnClickListener() {
            val toast1 = Toast.makeText(this, text, duration)
            toast1.show()
        }

        submitButton.setOnClickListener() {
            val toast1 = Toast.makeText(this, "Halo apa kabar " + nama, duration)
            toast1.show()
        }
    }
}