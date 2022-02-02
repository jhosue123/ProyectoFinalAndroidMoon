package com.example.proyectofinalandroid

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class AdapterAccesorios (private var listaproductos:List<ProductoModel>)
    : RecyclerView.Adapter<AdapterAccesorios.ViewHolder>(){

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

     //   val proId: TextView =itemView.findViewById(R.id.prod_id)
        val pre:TextView=itemView.findViewById(R.id.prod_precio)
        val can:TextView=itemView.findViewById(R.id.prod_stock)
        val name: TextView =itemView.findViewById(R.id.prod_name)
        val mar:TextView=itemView.findViewById(R.id.prod_marca)
        val imageview: ImageView =itemView.findViewById(R.id.prod_imagen)

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterAccesorios.ViewHolder {

        val layoutInflater= LayoutInflater.from(parent.context)
        return  ViewHolder(layoutInflater.inflate(R.layout.card_accesorios,
            parent,false))
    }


    override fun onBindViewHolder(holder: AdapterAccesorios.ViewHolder, position: Int) {

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