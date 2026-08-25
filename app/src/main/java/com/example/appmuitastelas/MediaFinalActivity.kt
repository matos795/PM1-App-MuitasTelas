package com.example.appmuitastelas

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MediaFinalActivity : AppCompatActivity() {

    private lateinit var etNota1 : EditText
    private lateinit var etNota2 : EditText
    private lateinit var etFaltas : EditText
    private lateinit var btnCalcular : Button
    private lateinit var btnLimpar : Button
    private lateinit var btnSair : Button
    private lateinit var tvNotaFinal : TextView
    private lateinit var tvSituacao : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_media_final)

        etNota1 = findViewById(R.id.etNota1)
        etNota2 = findViewById(R.id.etNota2)
        etFaltas = findViewById(R.id.etFaltas)

        btnCalcular = findViewById(R.id.btnCalcular)
        btnLimpar = findViewById(R.id.btnLimpar)
        btnSair = findViewById(R.id.btnSair)

        tvNotaFinal = findViewById(R.id.tvNotaFinal)
        tvSituacao = findViewById(R.id.tvSituacao)

        btnCalcular.setOnClickListener {
            calcular()
        }

        btnLimpar.setOnClickListener {
            limpar()
        }

        btnSair.setOnClickListener {
            sair()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    private fun calcular() {
        var nota1 : Double
        var nota2 : Double
        var notaFinal : Double
        var faltas : Int
        var situacao : String

        nota1 = etNota1.text.toString().toDouble()
        nota2 = etNota2.text.toString().toDouble()
        faltas = etFaltas.text.toString().toInt()
        notaFinal = (nota1 + nota2) / 2

        if(notaFinal >= 6 && faltas<=20) {
            situacao = "Aprovado"
        } else if(faltas > 20 || notaFinal < 4) {
            situacao = "Reprovado"
        } else {
            situacao = "Exame"
        }

        tvNotaFinal.text = notaFinal.toString()
        tvSituacao.text = situacao
    }

    private fun limpar() {
        etNota1.setText("")
        etNota2.setText("")
        etFaltas.setText("")
        tvNotaFinal.text = ""
        tvSituacao.text = ""
        etNota1.requestFocus()
    }

    private fun sair() {
        finishAndRemoveTask()
    }
}