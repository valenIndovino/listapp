package com.ort.listapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ort.listapp.R
import com.ort.listapp.entities.Producto

class ProductoAdapter(
    var productos: MutableList<Producto>,
    val context: Context,
    var onClick : (Int) -> Unit
) : RecyclerView.Adapter<ProductoAdapter.ProductoHolder>() {


    class ProductoHolder(v: View) : RecyclerView.ViewHolder(v){
        //Se escriben funciones que quiero que se ejecuten cuando se renderice cada item
        private var view: View
        init{
            this.view = v
        }
        //Se hace una función por cada cosa que pasa en el item
        fun setNombre(nombre:String){
            var txtNombre : TextView = view.findViewById(R.id.nombreListadoItem)
            txtNombre.text = nombre
        }
        fun setPrecio(precio:Double){
            var txtPrecio : TextView = view.findViewById(R.id.txtPrecioProducto)
            txtPrecio.text = "$" + precio.toString()
        }

        fun getCard(): CardView {
            return view.findViewById(R.id.card)
        }

        fun loadImg(url: String?){
            var albumCover: ImageView = view.findViewById(R.id.fotoProducto)
            if(url != null) {
                Glide.with(view).load(url).into(albumCover)
            }else{
                Glide.with(view).load(R.drawable.placeholder).into(albumCover)
            }
        }

      /*  fun setLista(productos: MutableList<Producto>) {

        }*/
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductoHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_producto,parent,false)
        return (ProductoHolder(view))
    }

    override fun onBindViewHolder(holder: ProductoHolder, position: Int) {
        //Iteración de la lista y va  usando las funciones set
        //Solamente itera sobre los elementos en pantalla e itera a medida que se scrollea
        holder.setNombre(productos[position].nombre)
        holder.setPrecio(productos[position].precioMax)
        holder.loadImg(productos[position].imgURL)


        //Se le settea un click listener a las cards
        holder.getCard().setOnClickListener(){
            onClick(position)
        }
    }

    override fun getItemCount(): Int {
        return productos.size
    }
}