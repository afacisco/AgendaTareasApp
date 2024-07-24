package com.example.agendatareasapp

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.findViewTreeViewModelStoreOwner
import androidx.recyclerview.widget.RecyclerView

/*
Autor: Juan Francisco Sánchez González
Fecha: 22/07/2024
Clase: ViewHolder del RecyclerView para el renderizado de cada elemento (tarea)
 */

class TareaViewHolder(view: View): RecyclerView.ViewHolder(view) {
    // Controles del layout (CardView)
    private val tvTarea: TextView = view.findViewById(R.id.tv_tarea)
    private val imgvCheck: ImageView = view.findViewById(R.id.imgv_check)

    // Asignamos datos a los controles
    fun render(tarea: String, onItemCheck: (Int) -> Unit) {
        tvTarea.text = tarea
        // Listeners onClick para las imágenes de cada elemento (se pasa su posición dentro del listado)
        imgvCheck.setOnClickListener { onItemCheck(adapterPosition) }
    }
}