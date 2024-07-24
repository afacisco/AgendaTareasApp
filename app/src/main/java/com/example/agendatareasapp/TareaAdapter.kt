package com.example.agendatareasapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

/*
Autor: Juan Francisco Sánchez González
Fecha: 22/07/2024
Clase: Adaptador personalizado para el RecyclerView. Se le pasa al constructor una lista (tareas) y
una función para gestionar la comunicación entre el ViewHolder y la Actividad, que sería para saber qué
imagen se pulsó para borrar el elemento (tarea) de la lista.
 */

class TareaAdapter(private val listTareas:List<String>, private val onItemCheck: (Int) -> Unit): RecyclerView.Adapter<TareaViewHolder>() {

    // Infla la vista de cada elemento del RecyclerView (CardView)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TareaViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return TareaViewHolder(layoutInflater.inflate(R.layout.item_rcv_tarea, parent, false))
    }

    // Número de elementos de la lista
    override fun getItemCount(): Int = listTareas.size

    // Llamada con cada elemento del listado a ViewHolder para su renderizado
    override fun onBindViewHolder(holder: TareaViewHolder, position: Int) {
        holder.render(listTareas[position], onItemCheck)
    }

}