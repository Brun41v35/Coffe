package com.example.maquinadecafe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.maquinadecafe.ListaDeBebidas.ListaBebibasActivity
import kotlinx.android.synthetic.main.activity_cadastro.*
import kotlinx.android.synthetic.main.activity_welcome.*

class WelcomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        val intent = intent.getStringExtra("nome")
        txt_nameUser.text = intent

        co.setAnimation("co.json")
        co.playAnimation()
        co.loop(true)
    }

    fun irParaListaBebibidas(view: View) {
        val intent = Intent(this,ListaBebibasActivity::class.java)
        startActivity(intent)
    }
}
