package com.example.appmuitastelas

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MenuActivity : AppCompatActivity() {

    private lateinit var btnImc : Button
    private lateinit var btnMedia : Button
    private lateinit var btnIdade : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)

        btnImc = findViewById(R.id.btnImc)
        btnMedia = findViewById(R.id.btnMedia)
        btnIdade = findViewById(R.id.btnIdade)

        btnImc.setOnClickListener {
            calcularIMC()
        }

        btnMedia.setOnClickListener {
            calcularMedia()
        }

        btnIdade.setOnClickListener {
            calcularIdade()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    private fun calcularIMC() {
        var telaIMC : Intent
        telaIMC = Intent(this, ImcActivity::class.java)
        startActivity(telaIMC)
        finish()
    }

    private fun calcularMedia() {
        var telaMedia : Intent
        telaMedia = Intent(this, MediaFinalActivity::class.java)
        startActivity(telaMedia)
        finish()
    }

    private fun calcularIdade() {
        var telaIdade : Intent
        telaIdade = Intent(this, IdadeActivity::class.java)
        startActivity(telaIdade)
        finish()
    }
}