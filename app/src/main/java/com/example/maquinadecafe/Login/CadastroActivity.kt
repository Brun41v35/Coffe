package com.example.maquinadecafe.Login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.example.maquinadecafe.R
import kotlinx.android.synthetic.main.activity_cadastro.*
import kotlinx.android.synthetic.main.activity_login.*

class CadastroActivity : AppCompatActivity() {

    private lateinit var preferences: PreferenciasCafe
    private lateinit var editTextUser: EditText
    private lateinit var editTextPass: EditText
    private lateinit var editTextPag: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        pro.setAnimation("pro.json")
        pro.playAnimation()
        pro.loop(true)

        preferences = PreferenciasCafe(this)
        editTextUser = findViewById(R.id.edit_user)
        editTextPass = findViewById(R.id.edit_password)
        editTextPag = findViewById(R.id.edit_pagamento)
    }

    fun saveInfo(view: View) {
        val recoveredTextUser = editTextUser.text.toString()
        val recoveredTextPass = editTextPass.text.toString()
        val recoveredTextPag = editTextPag.text.toString()

        if(recoveredTextUser.equals("") || recoveredTextPass.equals("") || recoveredTextPag.equals("")) {
            Toast.makeText(this,"Preencha todos os campos", Toast.LENGTH_LONG).show()
        } else {
            preferences.saveInfo(recoveredTextUser,recoveredTextPass,recoveredTextPag)
            Toast.makeText(this,"Informações salvas com sucesso", Toast.LENGTH_LONG).show()
            voltarTelaLogin()
        }
    }

    fun voltarTelaLogin() {
        val intent = Intent (this, LoginActivity::class.java)
        startActivity(intent)
    }
}
