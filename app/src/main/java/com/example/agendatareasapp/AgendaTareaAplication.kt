package com.example.agendatareasapp

import android.app.Application

/*
Autor: Juan Francisco Sánchez González
Fecha: 22/07/2024
Clase: Clase de inicio (hereda de Application), será la primera que se carga al iniciar la apicación.
Encargada de inicializar la variable que alamacenará los datos (tareas) recogidos de las SharedPreferences.
 */

class AgendaTareaAplication:Application() {

    // Como static en Java, que puede ser invocado sin la necesidad de tener que instanciar un objeto de la clase.
    companion object {
        // Variable que va a almacenar las SharedPreferences
        lateinit var prefs: Preferences
    }

    override fun onCreate() {
        super.onCreate()
        // Recogemos las SharedPreferences
        prefs  = Preferences(baseContext)
    }
}