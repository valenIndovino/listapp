package com.ort.listapp.domain.model

import com.google.firebase.Timestamp

data class Familia(
    var id: String = "",
    val nombre: String = "",
    val password: String = "",
    val usuarios: List<String> = listOf(),
    val productosPersonalizados: ArrayList<Producto> = arrayListOf(),
    var productosFavoritos: ArrayList<Producto> = arrayListOf(),
    var ultimaActualizacionPrecios: Timestamp? = Timestamp.now(),
    var listas: ArrayList<Lista> = arrayListOf(
        Lista(
            id = "listaCompras",
            nombre = "listaCompras",
            tipoLista = TipoLista.LISTA_DE_COMPRAS,
            productos = mutableListOf(
            )
        ),
        Lista(
            id = "alacenaVirtual",
            nombre = "Alacena Virtual",
            tipoLista = TipoLista.ALACENA_VIRTUAL,
            productos = mutableListOf(
            )
        )
    ),
)
