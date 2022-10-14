package com.ort.listapp.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.ort.listapp.R
import com.ort.listapp.adapters.ProductoAdapter
import com.ort.listapp.adapters.ProductoListadoAdapter
import com.ort.listapp.data.ProductoRepository
import com.ort.listapp.entities.Producto

class HomeFragment : Fragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    lateinit var v: View

    lateinit var listaCompra: RecyclerView

    val repo = ProductoRepository()

    val prs = repo.getProductos()

    var productos : MutableList<Producto> = ArrayList<Producto>()

    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_home, container, false)
        listaCompra = v.findViewById(R.id.listaCompra)
        cargarProds()
        return v
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
    }

    override fun onStart() {
        super.onStart()
        listaCompra.setHasFixedSize(true)
        listaCompra.layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL,false)

        listaCompra.adapter = ProductoListadoAdapter(productos, requireContext())
    }

    fun onItemClick ( position : Int )  {
    }

    fun cargarProds(){
        prs.forEach {
            productos.add(
                Producto(
                    it.id,
                    it.id_Categoria,
                    it.id_subCategoria,
                    it.marca,
                    it.nombre,
                    it.precioMin,
                    it.precioMax,
                    it.presentacion,
                    it.imgURL
                )
            )
        }
    }

}