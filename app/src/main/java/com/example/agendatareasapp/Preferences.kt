package com.example.agendatareasapp

import android.content.Context
import android.content.SharedPreferences

/*
Autor: Juan Francisco Sánchez González
Fecha: 22/07/2024
Clase: Encargada de la lógica de las SharedPreferences.
 */

class Preferences(ctx: Context) {

    // Constantes, tienen que ser companion object (static en Java)
    companion object {
        // Id de la BD de Tareas utilizando SharedPreferences
        const val PREFES_NAME = "myDataBase"
        // Clave para el StringSet de Tareas
        const val TAREAS_VALUES = "tareas_values"
    }

    // Cargamos las SharedPreferences
    val prefs: SharedPreferences = ctx.getSharedPreferences(Companion.PREFES_NAME, 0)

     // Guardamos el listado de Tareas en la BD de las SharedPreferences
    fun guardarTareas(listTareas: List<String>) {
        prefs.edit().putStringSet(TAREAS_VALUES, listTareas.toSet()).apply()
    }

    // Pasamos la BD
    fun recogerTareas(): MutableList<String> = prefs.getStringSet(TAREAS_VALUES, emptySet<String?>())?.toMutableList() ?: mutableListOf()
}