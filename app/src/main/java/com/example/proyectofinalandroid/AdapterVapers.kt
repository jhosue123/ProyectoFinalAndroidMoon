package com.example.proyectofinalandroid

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class AdapterVapers (private var listaproductos:List<ProductoModel>)
    : RecyclerView.Adapter<AdapterVapers.ViewHolder>(){

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {


        val name: TextView =itemView.findViewById(R.id.vap_name)
        val imageview: ImageView =itemView.findViewById(R.id.vap_imagen)
        val pre:TextView=itemView.findViewById(R.id.vap_precio)
        val can:TextView=itemView.findViewById(R.id.vap_stock)
        val mar:TextView=itemView.findViewById(R.id.vap_marca)

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterVapers.ViewHolder {

        val layoutInflater= LayoutInflater.from(parent.context)
        return  ViewHolder(layoutInflater.inflate(R.layout.card_vapes,
            parent,false))
    }


    override fun onBindViewHolder(holder: AdapterVapers.ViewHolder, position: Int) {

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