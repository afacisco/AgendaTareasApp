package com.example.agendatareasapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.agendatareasapp.AgendaTareaAplication.Companion.prefs

/*
Autor: Juan Francisco Sánchez González
Fecha: 22/07/2024
Clase: Actividad principal con un listado (RecyclerView y CardView) de tareas, se podrán eliminar y
añadir nuevas. Se utiliza un adaptador personalizado para el listado y SharedPreferences para la
persistencia de los datos.
 */

class MainActivity : AppCompatActivity() {

    // Controles vista
    lateinit var btnAdd: Button
    lateinit var etTarea: EditText
    lateinit var rcvTareas: RecyclerView

    // Adaptador listado tareas RecyclerView
    lateinit var tareaAdapter: TareaAdapter

    // Estructura que almacena las tareas
    var listTareas = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Empezamos con nuestra lógica
        initUi()
    }

    // Inicializamos todos nuestros componentes
    private fun initUi() {
        initView()
        initListeners()
        initRecyclerView()
    }

    // Recoge listado de tareas e inicaliza el RecyclerView
    private fun initRecyclerView() {
        // SharedPreferences con las tareas
        listTareas = prefs.recogerTareas()
        // Asignamos tipo de layout y adaptador al RecyclerView
        rcvTareas.layoutManager = LinearLayoutManager(this)
        tareaAdapter = TareaAdapter(listTareas) { position -> delTarea(position) }
        rcvTareas.adapter = tareaAdapter
    }

    // Borra tarea (Listado y SharedPreferences)
    private fun delTarea(pos: Int) {
        listTareas.removeAt(pos)
        // Notificamos los cambios al adaptador
        tareaAdapter.notifyDataSetChanged()
        prefs.guardarTareas(listTareas)
    }

    // Listeners de la actividad
    private fun initListeners() {
        // Botón añadir tarea
        btnAdd.setOnClickListener { addTarea() }
    }

    // Añadir tarea (Listado y SharedPreferences)
    private fun addTarea() {
        val tareaNueva = etTarea.text.toString()
        listTareas.add(tareaNueva)
        // Notificamos los cambios al adaptador
        tareaAdapter.notifyDataSetChanged()
        etTarea.text.clear()
        prefs.guardarTareas(listTareas)
    }

    // Asignamos los controles de la vista a sus variables
    private fun initView() {
        btnAdd = findViewById(R.id.btn_add)
        etTarea = findViewById(R.id.et_tarea)
        rcvTareas = findViewById(R.id.rcv_tareas)
    }
}