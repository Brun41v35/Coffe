package com.example.maquinadecafe.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.maquinadecafe.Model.Bebidas
import com.example.maquinadecafe.R
import kotlinx.android.synthetic.main.desinglistabebidas.view.*

class BebidasAdapter(val items: ArrayList<Bebidas>, private val clickListener: (Bebidas) -> Unit):
    RecyclerView.Adapter<BebidasAdapter.ViewHolder>() {

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.desinglistabebidas, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bind(items[position], clickListener)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(bebida: Bebidas, clickListener: (Bebidas) -> Unit) {
            itemView.tv_lista_bebidas.text = bebida.nome
            itemView.iv_bebida.setImageResource(bebida.icone)
            itemView.setOnClickListener { clickListener(bebida) }
        }
    }

}