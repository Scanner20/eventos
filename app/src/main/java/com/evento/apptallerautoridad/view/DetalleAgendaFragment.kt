package com.evento.apptallerautoridad.view

import android.content.Intent
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.provider.CalendarContract
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

import com.evento.apptallerautoridad.R
import com.evento.apptallerautoridad.utils.FechaConvertidor
import com.evento.apptallerautoridad.viewmodels.DetalleAgendaViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

import java.text.SimpleDateFormat

class DetalleAgendaFragment : Fragment() {

    val convertidor = FechaConvertidor()
    val date = SimpleDateFormat("dd/MM/yyyy HH:mm")

    companion object {
        fun newInstance() = DetalleAgendaFragment()
    }

    private lateinit var viewModel: DetalleAgendaViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.detalle_agenda_fragment, container, false)

        arguments?.let {il ->
            val id = il.getInt("id")
            val tema = il.getString("tema")
            val fecha = il.getString("fecha")

            showToolbar(view, "Detalle Fecha")
            setHasOptionsMenu(true)

            view.findViewById<TextView>(R.id.detalle_agenda_tema).text = tema
            view.findViewById<TextView>(R.id.detalle_agenda_fecha).text = fecha //convertidor.parsearFecha(Timestamp(date.parse(fecha).time))

            val ponente = when (id) {
                1 -> "Guillermo Bouroncle Calixto"
                2 -> "Luis García Lumbreras"
                3 -> "Guillermo Bouroncle Calixto"
                4 -> "Prefecto General (R) Sr. René Vicente Reibel"
                5 -> "Menotti Yáñez Ramírez"
                6 -> "Olivio Huancaruna Perales"
                7 -> "Guillermo Acosta Rodriguez "
                8 -> "Juan Carlos Portocarrero Zamora"
                9 -> "Salvattore Leonardo Tripi Rossel"
                10 -> "Alvaro Eloy Rodriguez Chavez"
                11 -> "Juan Manuel Carrasco Millones"
                12 -> "Denis Romani Seminario"
                13 -> "Jaime Navach Gamio"
                14 -> "Carolina Gonzalez Mejia"
                15 -> "Fernando Huarcaya Ugarte"
                16 -> "Gral. PNP (r) Miguel Hidalgo Medina – Cmdt. PNP Javier Reategui Bastas"
                17 -> "Edgar Patiño Garrido"
                else -> ""
            }

            view.findViewById<TextView>(R.id.detalle_agenda_ponente).text = ponente

            val fechaInTimes = FechaConvertidor().stringToDate(fecha)

            view.findViewById<FloatingActionButton>(R.id.fab_agenda).setOnClickListener {
                val intent = Intent(Intent.ACTION_EDIT)
                intent.type = "vnd.android.cursor.item/event"
                intent.putExtra(CalendarContract.Events.TITLE, tema)
                intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME,
                        fechaInTimes.time)
                /*intent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME,
                        endDateMillis)*/
                intent.putExtra(CalendarContract.Events.ALL_DAY, false)
                intent.putExtra(CalendarContract.Events.DESCRIPTION, "")
                startActivity(intent)
            }
        }

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(DetalleAgendaViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val activity = activity as AppCompatActivity?
        return when (item.itemId) {
            android.R.id.home -> {
                activity?.onBackPressed()
                false
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun showToolbar(view: View, title: String) {
        val toolbar = view.findViewById<Toolbar>(R.id.toolbar)

        val let = activity as AppCompatActivity?
        let?.let {
            let.setSupportActionBar(toolbar)
            let.supportActionBar?.setDisplayHomeAsUpEnabled(true)
            let.supportActionBar?.title = title
        }
    }

}
