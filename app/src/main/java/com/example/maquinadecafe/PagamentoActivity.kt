package com.example.maquinadecafe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.maquinadecafe.Login.PreferenciasCafe
import com.example.maquinadecafe.Model.Bebidas
import kotlinx.android.synthetic.main.activity_pagamento.*

class PagamentoActivity : AppCompatActivity() {

    private lateinit var preferences: PreferenciasCafe

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pagamento)

        ma.setAnimation("ma.json")
        ma.playAnimation()
        ma.loop(true)

        preferences = PreferenciasCafe(this)

        val receberInfo = intent.getSerializableExtra("nomeBebida") as Bebidas
        passarInfo(receberInfo)

        txt_Nome.text = preferences.returnUser()

        txt_FormaPagamento.text = preferences.returnPag()
    }

    fun passarInfo(bebidas: Bebidas) {
        val nomeBebida = bebidas.nome
        txt_bebida.text = nomeBebida
    }
}
