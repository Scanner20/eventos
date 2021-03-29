package com.evento.apptallerautoridad.view

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.navOptions

import com.evento.apptallerautoridad.R
import com.evento.apptallerautoridad.viewmodels.DetalleExpositorViewModel

class DetalleExpositorFragment : Fragment() {

    companion object {
        fun newInstance() = DetalleExpositorFragment()
    }

    val options = navOptions {
        anim {
            exit = R.anim.slide_in_right
            enter = R.anim.slide_out_left
            popExit = R.anim.slide_in_left
            popEnter = R.anim.slide_out_right
        }
    }

    private lateinit var viewModel: DetalleExpositorViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.detalle_expositor_fragment, container, false)

        var title = ""

        arguments?.let {
            val id = it.getInt("id")
            val name = it.getString("nombre")
            val apellido = it.getString("apellido")
            val cargo = it.getString("cargo")
            val empresa = it.getString("empresa")
            val resenia = it.getString("resenia")

            title = "$name $apellido"

            view.findViewById<TextView>(R.id.expositor_nombre).text = name
            view.findViewById<TextView>(R.id.expositor_apellido).text = apellido
            view.findViewById<TextView>(R.id.expositor_cargo).text = cargo
            view.findViewById<TextView>(R.id.expositor_empresa).text = empresa
            view.findViewById<TextView>(R.id.expositor_resenia).text = resenia

            val drawable = when (id) {
                1 -> R.drawable.guillermo
                2 -> R.drawable.luis
                3 -> R.drawable.rene
                4 -> R.drawable.menotti
                5 -> R.drawable.olivio
                6 -> R.drawable.guillermoacosta
                7 -> R.drawable.zamora
                8 -> R.drawable.salvattore
                9 -> R.drawable.alvaro
                10 -> R.drawable.juanmanuelcarrasco
                11 -> R.drawable.dennis
                12 -> R.drawable.jaime
                13 -> R.drawable.carolina
                14 -> R.drawable.fernando
                15 -> R.drawable.miguel
                16 -> R.drawable.javier
                17 -> R.drawable.edgar
                else -> R.drawable.ic_user_default
            }

            view.findViewById<ImageView>(R.id.expositor_imagen).setImageResource(drawable)

            val ponencia = when (id) {
                1 -> "Inauguración del X Foro Taller Nacional PBIP Chiclayo - Miércoles 07 noviembre 2018 - 08:50 a 09:00 hrs \n\n" +
                        "El Crimen Organizado en los Puertos y su impacto en el Comercio Internacional - 09:10 a 09:50 hrs"
                2 -> "Objetivo del Foro – directivas para su desarrollo - Miércoles 07 noviembre 2018 - 09:00 a 09:10 hrs"
                3 -> "Exposición Foro Taller PBIP - Miércoles 07 noviembre 2018 - 09:50 a 10:35 hrs"
                4 -> "Exposición Foro Taller PBIP - Viernes 09 noviembre - 2018 11:25 a 12:10 hrs"
                5 -> "Seguridad Portuaria: “Efectos en el Desarrollo del país - Miércoles 07 noviembre 2018 - 14:30 a 15:15 hrs"
                6 -> "Exposición Foro Taller PBIP - Miércoles 07 noviembre 2018 - 15:35 a 16:20 hrs"
                7 -> "Marco legal del crimen organizado en el Perú - Jueves 08 noviembre 2018 - 09:00 a 09:45 hrs"
                8 -> "Fenómeno social de las organizaciones criminales que vienen afectando con sus actividades ilícitas el comercio internacional a través de los puertos de la República" +
                        " - Jueves 08 noviembre 2018 - 09:45 a 10:30 hrs"
                9 -> "Cómo el crimen organizado afecta el comercio internacional - Jueves 08 noviembre 2018 - 10:50 a 11:35 hrs"
                10 -> "Incidencia delictiva en vías de comunicación nacional - Jueves 08 noviembre 2018 - 11:35 a 12:20 hrs"
                11 -> "Rol de la UIF-Perú y Sistema de Prevención contra el Lavado de Activos - Viernes 09 noviembre 2018 - 09:00 a 09:45 hrs"
                12 -> "Vigilancia y Protección a Infraestructuras Críticas y Buques en los Puertos - Viernes 09 noviembre 2018 - 09:45 a 10:30 hrs"
                13 -> "La importancia de la tecnología para combatir el crimen organizado en los puertos - Viernes 09 noviembre 2018 - 10:50 a 11:05 hrs"
                14 -> "La Innovación como Instrumento para la Eficiencia en la Protección Portuaria y Nuevos Requerimientos Normativos para la Re-Certificación en el Código PBIP 2019-2024 - Viernes 09 noviembre 2018 - 11:05 a 11:35 hrs"
                15 -> "Exposición Foro Taller PBIP - Viernes 09 noviembre 2018 - 11:35 a 12:20 hrs"
                16 -> "Exposición Foro Taller PBIP - Viernes 09 noviembre 2018 - 11:35 a 12:20 hrs"
                17 -> "Clausura del X Foro Nacional PBIP CHICLAYO – 2018 - Viernes 09 noviembre 2018 - 13:00 a 13:15 horas"
                else -> ""
            }

            view.findViewById<TextView>(R.id.expositor_ponencia).text = ponencia
        }


        showToolbar(view, title)
        setHasOptionsMenu(true)

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(DetalleExpositorViewModel::class.java)
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
