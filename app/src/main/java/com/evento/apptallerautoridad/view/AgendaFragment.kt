package com.evento.apptallerautoridad.view

import android.os.Build
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.os.bundleOf
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import androidx.recyclerview.widget.LinearLayoutManager

import com.evento.apptallerautoridad.R
import com.evento.apptallerautoridad.adapter.AdapterAgenda
import com.evento.apptallerautoridad.model.Agenda
import com.evento.apptallerautoridad.utils.FechaConvertidor
import com.evento.apptallerautoridad.viewmodels.AgendaViewModel
import kotlinx.android.synthetic.main.agenda_fragment.*
import java.sql.Timestamp
import java.text.SimpleDateFormat

class AgendaFragment : Fragment() {

    companion object {
        fun newInstance() = AgendaFragment()
    }

    val lista = arrayListOf<Agenda>()

    private lateinit var viewModel: AgendaViewModel

    private lateinit var adapter: AdapterAgenda

    var options: NavOptions? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.agenda_fragment, container, false)

        showToolbar(view, "Agenda")
        setHasOptionsMenu(true)

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(AgendaViewModel::class.java)

        val toolbar = activity?.findViewById<Toolbar>(R.id.collapsing_toolbar_agenda)
        (activity as AppCompatActivity).setSupportActionBar(toolbar)

        activity?.let {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                options = navOptions {
                    anim {
                        enter = R.anim.slide_in_right
                        exit = R.anim.slide_out_left
                        popEnter = R.anim.slide_in_left
                        popExit = R.anim.slide_out_right
                    }
                }
            }


            adapter = AdapterAgenda(lista) { eventoItem: Agenda -> eventoItemClicked(eventoItem) }

            rcViewAgenda.apply {
                layoutManager = LinearLayoutManager(it)
                adapter = this@AgendaFragment.adapter
            }

            llenarAgenda()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val activity = activity as AppCompatActivity?
        return when (item.itemId) {
            android.R.id.home -> {
                activity?.onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }


    fun llenarAgenda() {
        lista.clear()

        val date = SimpleDateFormat("dd/MM/yyyy HH:mm:ss")

        lista.add(Agenda(1, "Inauguración del X Foro Taller Nacional PBIP Chiclayo - 2018", Timestamp(date.parse("07/11/2018 08:50:00").time))) // 1
        lista.add(Agenda(2, "Objetivo del Foro – Directivas para su Desarrollo", Timestamp(date.parse("07/11/2018 09:00:00").time))) // 2
        lista.add(Agenda(3, "El Crimen Organizado en los Puertos y su impacto en el Comercio Internacional", Timestamp(date.parse("07/11/2018 09:10:00").time))) //3
        lista.add(Agenda(4, "Exposición Foro Taller PBIP", Timestamp(date.parse("07/11/2018 09:50:00").time))) // 4
        lista.add(Agenda(5, "Exposición Foro Taller PBIP", Timestamp(date.parse("07/11/2018 11:25:00").time))) // 5
        lista.add(Agenda(6, "Seguridad Portuaria: “Efectos en el Desarrollo del País\"", Timestamp(date.parse("07/11/2018 14:30:00").time))) // 6
        lista.add(Agenda(7, "Exposición Foro Taller PBIP", Timestamp(date.parse("07/11/2018 15:35:00").time))) // 7

        // Dia 2
        lista.add(Agenda(8, "Marco legal del crimen organizado en el Perú",
                Timestamp(date.parse("08/11/2018 09:00:00").time)))
        lista.add(Agenda(9, "Fenómeno social de las organizaciones criminales que vienen afectando con sus actividades ilícitas el comercio internacional a través de los puertos de la República",
                Timestamp(date.parse("08/11/2018 09:45:00").time)))
        lista.add(Agenda(10, "Cómo el crimen organizado afecta el comercio internacional", Timestamp(date.parse("08/11/2018 10:50:00").time)))
        lista.add(Agenda(11, "Incidencia delictiva en vías de comunicación nacional", Timestamp(date.parse("08/11/2018 11:35:00").time)))

        // Dia 3
        lista.add(Agenda(12, "Rol de la UIF-Perú y Sistema de Prevención contra el Lavado de Activos", Timestamp(date.parse("09/11/2018 09:00:00").time)))
        lista.add(Agenda(13, "Vigilancia y Protección a Infraestructuras Críticas y Buques en los Puertos", Timestamp(date.parse("09/11/2018 09:45:00").time)))
        lista.add(Agenda(14, "La importancia de la tecnología para combatir el crimen organizado en los puertos", Timestamp(date.parse("09/11/2018 10:50:00").time)))
        lista.add(Agenda(15, "La Innovación como Instrumento para la Eficiencia en la Protección Portuaria y Nuevos Requerimientos Normativos para la Re-Certificación en el Código PBIP 2019-2024", Timestamp(date.parse("09/11/2018 11:05:00").time)))
        lista.add(Agenda(16, "Exposición Foro Taller PBIP", Timestamp(date.parse("09/11/2018 11:35:00").time)))
        lista.add(Agenda(17, "Clausura del X Foro Nacional PBIP CHICLAYO – 2018", Timestamp(date.parse("09/11/2018 13:00:00").time)))


        adapter.notifyDataSetChanged()
    }

    private fun eventoItemClicked(evento: Agenda) {
        val format = FechaConvertidor().dateToString(evento.fecha)

        context?.let {
            val bundle = bundleOf("id" to evento.id,
                    "tema" to evento.tema, "fecha" to format)

            findNavController().navigate(R.id.detalleAgendaFragment, bundle, options)
        }
    }

    private fun showToolbar(view: View, title: String = "") {
        val toolbar = view.findViewById<Toolbar>(R.id.collapsing_toolbar_agenda)

        val let = activity as AppCompatActivity?
        let?.let {
            let.setSupportActionBar(toolbar)
            let.supportActionBar?.setDisplayHomeAsUpEnabled(true)
            let.supportActionBar?.title = title
        }
    }

}
