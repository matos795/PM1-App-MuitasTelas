package com.example.appmuitastelas

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ImcActivity : AppCompatActivity() {

    private lateinit var etPeso : EditText
    private lateinit var etAltura : EditText

    private lateinit var tvClassificacao : TextView
    private lateinit var tvResultado : TextView

    private lateinit var btnCalcular : Button
    private lateinit var btnLimpar : Button
    private lateinit var btnSair : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_imc)

        etAltura = findViewById(R.id.etAltura)
        etPeso = findViewById(R.id.etPeso)
        tvClassificacao = findViewById(R.id.tvClassificacao)
        tvResultado = findViewById(R.id.tvResultado)
        btnCalcular = findViewById(R.id.btnCalcular)
        btnLimpar = findViewById(R.id.btnLimpar)
        btnSair = findViewById(R.id.btnSair)

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
    private fun calcular(){
        var altura : Double
        var peso : Double
        var imc : Double

        altura = etAltura.text.toString().toDouble()
        peso = etPeso.text.toString().toDouble()
        imc = peso/(altura*altura)
        if (imc < 18.5){
            tvClassificacao.text = "Abaixo do peso"
        }
        else if (imc >= 18.5 && imc < 25){
            tvClassificacao.text = "Peso Normal"
        }
        else if (imc >= 25 && imc <30){
            tvClassificacao.text = "Sobrepeso"
        }
        else if (imc >=30 && imc <35){
            tvClassificacao.text = "Obesidade grau I"
        }
        else if (imc >=35 && imc <40){
            tvClassificacao.text = "Obesidade grau II"
        }
        else if (imc >=40){
            tvClassificacao.text = "Obesidade grau III ou mórbida"
        }

        tvResultado.text = imc.toString()
    }

    private fun limpar() {
        etAltura.setText("")
        etPeso.setText("")
        tvClassificacao.text = ""
        tvResultado.text = ""
    }

    private fun sair() {
        finishAndRemoveTask()
    }
}