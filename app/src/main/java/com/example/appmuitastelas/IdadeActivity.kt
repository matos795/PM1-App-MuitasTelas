package com.example.appmuitastelas

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class IdadeActivity : AppCompatActivity() {
    private lateinit var etAnoAtual : EditText
    private lateinit var etAnoNascimento : EditText

    private lateinit var tvAnos : TextView
    private lateinit var tvMeses : TextView
    private lateinit var tvDias : TextView
    private lateinit var tvHoras : TextView
    private lateinit var tvMinutos : TextView
    private lateinit var tvSegundos : TextView

    private lateinit var btnCalcular : Button
    private lateinit var btnLimpar : Button
    private lateinit var btnSair : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_idade)

        etAnoAtual = findViewById(R.id.etAnoAtual)
        etAnoNascimento = findViewById(R.id.etAnoNascimento)

        tvAnos = findViewById(R.id.tvAnos)
        tvMeses = findViewById(R.id.tvMeses)
        tvDias = findViewById(R.id.tvDias)
        tvHoras = findViewById(R.id.tvHoras)
        tvMinutos = findViewById(R.id.tvMinutos)
        tvSegundos = findViewById(R.id.tvSegundos)

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
    private fun calcular() {
        var anoAtual : Int
        var anoNascimento : Int
        var anos : Int
        var meses : Int
        var dias : Int
        var horas : Long
        var minutos : Long
        var segundos : Long

        anoAtual = etAnoAtual.text.toString().toInt()
        anoNascimento = etAnoNascimento.text.toString().toInt()

        anos = anoAtual - anoNascimento
        meses = anos * 12
        dias = meses * 30
        horas = (dias * 24).toLong()
        minutos = horas * 60
        segundos = minutos * 60

        tvAnos.text = anos.toString()
        tvMeses.text = meses.toString()
        tvDias.text = dias.toString()
        tvHoras.text = horas.toString()
        tvMinutos.text = minutos.toString()
        tvSegundos.text = segundos.toString()
    }

    private fun limpar() {
        etAnoAtual.setText("")
        etAnoNascimento.setText("")
        tvAnos.text = ""
        tvMeses.text = ""
        tvDias.text = ""
        tvHoras.text = ""
        tvMinutos.text = ""
        tvSegundos.text = ""
        etAnoAtual.requestFocus()
    }

    private fun sair() {
        finishAndRemoveTask()
    }
}