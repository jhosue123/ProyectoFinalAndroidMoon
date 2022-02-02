package com.example.proyectofinalandroid

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class AdapterCombos (private var listaproductos:List<ProductoModel>)
    : RecyclerView.Adapter<AdapterCombos.ViewHolder>(){

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {


        val name: TextView =itemView.findViewById(R.id.comb_name)
        val imageview: ImageView =itemView.findViewById(R.id.comb_imagen)
        val pre:TextView=itemView.findViewById(R.id.comb_precio)
        val can:TextView=itemView.findViewById(R.id.comb_stock)
        val mar:TextView=itemView.findViewById(R.id.comb_marca)

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterCombos.ViewHolder {

        val layoutInflater= LayoutInflater.from(parent.context)
        return  ViewHolder(layoutInflater.inflate(R.layout.card_combos,
            parent,false))
    }


    override fun onBindViewHolder(holder: AdapterCombos.ViewHolder, position: Int) {

        val item=listaproductos[position]

       // holder.proId.text=item.productoId.toString()
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