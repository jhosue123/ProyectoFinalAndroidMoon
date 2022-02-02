package com.example.proyectofinalandroid

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class AdapterLiquidos (private var listaproductos:List<ProductoModel>)
    : RecyclerView.Adapter<AdapterLiquidos.ViewHolder>(){

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {


        val name: TextView =itemView.findViewById(R.id.liq_name)
        val imageview: ImageView =itemView.findViewById(R.id.liq_imagen)
        val pre:TextView=itemView.findViewById(R.id.liq_precio)
        val can:TextView=itemView.findViewById(R.id.liq_stock)
        val mar:TextView=itemView.findViewById(R.id.liq_marca)

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterLiquidos.ViewHolder {

        val layoutInflater= LayoutInflater.from(parent.context)
        return  ViewHolder(layoutInflater.inflate(R.layout.card_liquidos,
            parent,false))
    }


    override fun onBindViewHolder(holder: AdapterLiquidos.ViewHolder, position: Int) {

        val item=listaproductos[position]
        holder.pre.text=item.precio
        holder.can.text=item.stock
        holder.mar.text=item.marca
        holder.name.text=item.nombre
        Picasso.get().load(item.imagen).into(holder.imageview)

    }


    override fun getItemCount(): Int {
        return listaproductos.size
    }
}