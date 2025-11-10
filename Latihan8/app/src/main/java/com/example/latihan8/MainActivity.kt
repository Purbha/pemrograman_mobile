package com.example.latihan8

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var eNama: EditText
    private lateinit var eEmail: EditText
    private lateinit var bSubmit: Button
    private lateinit var RG_Makanan: RadioGroup

    companion object {
        const val EXTRA_NAMA = "extra_nama"
        const val EXTRA_EMAIL = "extra_email"
        const val EXTRA_MAKANAN = "extra_makanan"
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
    }

    fun Inisial_Object() {
        RG_Makanan = findViewById<RadioGroup>(R.id.RG_Main_Makanan)
        eNama = findViewById(R.id.editText_Main_Nama)
        eEmail = findViewById(R.id.editText_Main_Email)
        bSubmit = findViewById(R.id.button_Main_Submit)
    }

    fun Listen_bSubmit() {
        bSubmit.setOnClickListener {
            Log.d("CEK","Listen_bSubmit")
            if (cekEditTextKosong(eNama, eEmail) == true) {
                Log.d("CEK","cekEditTextKosong == true")
                return@setOnClickListener
            }
            val selectedId = RG_Makanan.checkedRadioButtonId

            //Jika belum pilih makanan
            if (selectedId == -1) {
                Log.d("CEK","Belum pilih makanan.")
                val pesanMakanan = Toast.makeText(this,"Silakan pilih makanan!",
                    Toast.LENGTH_LONG)
                pesanMakanan.show()
                return@setOnClickListener
            }

            //Ambil teks di radioButton
            val selectedRadioButton = findViewById<RadioButton>(selectedId)
            val strMakanan = selectedRadioButton.text

            val strNama = eNama.text.toString()
            val strEmail = eEmail.text.toString()
            Log.d("CEK","strNama: " + strNama)

            //Validasi Input Email
            val patternEmail = Patterns.EMAIL_ADDRESS
            if(!patternEmail.matcher(strEmail).matches()) {
                val strPesanEmail = "Format email tidak valid.";
                Log.d("CEK",strPesanEmail)
                val pesanEmail = Toast.makeText(this,strPesanEmail,
                    Toast.LENGTH_LONG)
                pesanEmail.show()
                return@setOnClickListener
            }

            //Panggil aktivity hasil
            val callHasil = Intent(this, HasilActivity::class.java)
            callHasil.putExtra(EXTRA_NAMA, strNama)
            callHasil.putExtra(EXTRA_EMAIL, strEmail)
            callHasil.putExtra(EXTRA_MAKANAN, strMakanan)
            startActivity(callHasil)
            val pesan = Toast.makeText(this,"Submit Berhasil",
                Toast.LENGTH_SHORT)
            pesan.show()
        }
    }

    fun cekEditTextKosong(vararg arrayEditText: EditText): Boolean {
        //"vararg" memungkinkan kita mengirim banyak EditText sekaligus.
        for (editText in arrayEditText) {
            if (editText.text.toString().trim().isEmpty()) {
                //Jika kosong, akan menampilkan error langsung di EditText.
                editText.error = "Field tidak boleh kosong"
                return true
            }
        }
        //Jika fungsi ini mengembalikan nilai true berarti input ada yang kosong.
        return false
    }

}