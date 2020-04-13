package com.example.maquinadecafe.SplashScreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.maquinadecafe.Login.LoginActivity
import com.example.maquinadecafe.R

class SplashActivity : AppCompatActivity() {

    //Criando uma variavel com tempo da splash
    private val tempoSplash: Long = 3000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        //Esse método vai ser executado quando o tempo finalizar
        Handler().postDelayed({

            //Incia seu aplicacativo
            startActivity(Intent(this, LoginActivity::class.java))

            //Fecha a tela
            finish()

        }, tempoSplash)
    }
}
