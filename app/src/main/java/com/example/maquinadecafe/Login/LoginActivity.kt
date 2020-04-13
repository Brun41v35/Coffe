package com.example.maquinadecafe.Login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.example.maquinadecafe.R
import com.example.maquinadecafe.WelcomeActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private lateinit var preferences: PreferenciasCafe
    private lateinit var editUser: EditText
    private lateinit var editPass: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        coffe.setAnimation("coffe.json")
        coffe.playAnimation()
        coffe.loop(true)

        preferences = PreferenciasCafe(this)
        editUser = findViewById(R.id.id_user)
        editPass = findViewById(R.id.id_pass)
    }

    fun validarUser(view: View) {

        val user = editUser.text.toString()
        val pass = editPass.text.toString()

        if(user.equals("") || pass.equals("")) {
            Toast.makeText(this,"Preencha os campos", Toast.LENGTH_LONG).show()
        } else {
            if (user.equals(preferences.returnUser()) && pass.equals(preferences.returnPass())) {
                welcomeOpen()
            } else {
                Toast.makeText(this,"Acesso negado", Toast.LENGTH_LONG).show()
            }
        }
    }

    fun welcomeOpen() {
        val intent = Intent(this, WelcomeActivity::class.java)
        intent.putExtra("nome",preferences.returnUser())
        startActivity(intent)
    }

    fun fazerCadastro(view: View) {
        val intent = Intent(this, CadastroActivity::class.java)
        startActivity(intent)
    }
}
