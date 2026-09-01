package com.example.appmuitastelas

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginActivity : AppCompatActivity() {

    private lateinit var btnLogin : Button

    private lateinit var etUsuario : EditText
    private lateinit var etSenha : EditText
    private lateinit var tvResult : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        btnLogin = findViewById(R.id.btnLogin)
        etSenha = findViewById(R.id.etSenha)
        etUsuario = findViewById(R.id.etUsuario)
        tvResult = findViewById(R.id.tvResult)

        btnLogin.setOnClickListener {
            logar()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun logar() {
        var telaMenu: Intent
        var usuario: String
        var senha: String

        usuario = etUsuario.text.toString()
        senha = etSenha.text.toString()

        if (usuario == "Alex" && senha == "123") {
        telaMenu = Intent(this, MenuActivity::class.java)
        startActivity(telaMenu)
        finish()
    } else {
            tvResult.text = "Usuário ou senha incorretos"
        }
    }
}