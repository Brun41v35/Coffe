package com.example.maquinadecafe.Login

import android.content.Context
import android.content.SharedPreferences

class PreferenciasCafe(var context: Context) {

    private val NOME_ARQUIVO: String = "anotacao.preferencias"
    private val CHAVE_USER: String = "user"
    private val CHAVE_PASS: String = "pass"
    private val CHAVE_PAG: String = "pag"

    private var preferences: SharedPreferences = context.getSharedPreferences(NOME_ARQUIVO,0)
    private var editor: SharedPreferences.Editor = preferences.edit()

    fun saveInfo(user: String, pass: String, pag: String) {
        editor.putString(CHAVE_USER,user)
        editor.putString(CHAVE_PASS,pass)
        editor.putString(CHAVE_PAG,pag)
        editor.commit()
    }

    fun returnUser(): String? {
        return preferences.getString(CHAVE_USER,"")
    }

    fun returnPass(): String? {
        return preferences.getString(CHAVE_PASS,"")
    }

    fun returnPag(): String? {
        return preferences.getString(CHAVE_PAG,"")
    }
}