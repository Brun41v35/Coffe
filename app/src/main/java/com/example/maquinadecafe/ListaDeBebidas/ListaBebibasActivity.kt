package com.example.maquinadecafe.ListaDeBebidas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.maquinadecafe.Adapter.BebidasAdapter
import com.example.maquinadecafe.Login.PreferenciasCafe
import com.example.maquinadecafe.Model.Bebidas
import com.example.maquinadecafe.PagamentoActivity
import com.example.maquinadecafe.R
import kotlinx.android.synthetic.main.activity_lista_bebibas.*

class ListaBebibasActivity : AppCompatActivity() {

    var bebidasStr = arrayOf("Café", "Leite", "Chocolate", "Café com leite",
        "Frappucino", "Pão", "Bolacha", "Suco", "Cold Brew","Bolo")

    var bebidasImg = arrayOf(
        R.drawable.cafe,
        R.drawable.leite,
        R.drawable.chocolate,
        R.drawable.cafe,
        R.drawable.frappucino,
        R.drawable.pao,
        R.drawable.bolacha,
        R.drawable.suco,
        R.drawable.cold,
        R.drawable.bolo
    )

    private lateinit var preferences: PreferenciasCafe

    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_bebibas)

        preferences = PreferenciasCafe(this)

        criarListaBebidas(carregaModeloBebidas(bebidasImg, bebidasStr))
    }

    fun criarListaBebidas(bebidas: ArrayList<Bebidas>){
        viewManager = LinearLayoutManager(this)
        viewAdapter = BebidasAdapter(bebidas) { texto -> bebidasItemClicked(texto)}

        rv_lista_bebidas.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter

        }
        rv_lista_bebidas.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
    }

    private fun bebidasItemClicked(bebida: Bebidas) {
        Toast.makeText(this, "Escolhi: ${bebida.nome}", Toast.LENGTH_SHORT).show()
        val intent = Intent (this,PagamentoActivity::class.java)
        intent.putExtra("nomeBebida",bebida)
        startActivity(intent)
    }


    fun carregaModeloBebidas(imagens: Array<Int>, nomes: Array<String>): ArrayList<Bebidas> {
        var bebidas: ArrayList<Bebidas> = ArrayList<Bebidas>()
        for (i in imagens.indices) {
            val bebida = Bebidas(imagens[i], nomes[i])
            bebidas.add(bebida)
        }
        return bebidas
    }
}
