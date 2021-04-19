package com.evento.apptallerautoridad.view

import android.content.Intent
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
import androidx.navigation.ActivityNavigator
import androidx.recyclerview.widget.LinearLayoutManager

import com.evento.apptallerautoridad.R
import com.evento.apptallerautoridad.adapter.AdapterLugarTuristico
import com.evento.apptallerautoridad.data.entity.LugarTuristico
import com.evento.apptallerautoridad.viewmodels.LugarTuristicoViewModel
import kotlinx.android.synthetic.main.lugar_turistico_fragment.*

class LugarTuristicoFragment : Fragment() {

    companion object {
        fun newInstance() = LugarTuristicoFragment()
    }

    val lista = arrayListOf<LugarTuristico>()

    private lateinit var adapter: AdapterLugarTuristico

    private lateinit var viewModel: LugarTuristicoViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.lugar_turistico_fragment, container, false)

        showToolbar(view, "Lugares Turísticos")
        setHasOptionsMenu(true)

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(LugarTuristicoViewModel::class.java)

        activity?.let {
            adapter = AdapterLugarTuristico(lista) { lugar -> lugarItemClicked(lugar) }

            rcViewLugar.apply {
                layoutManager = LinearLayoutManager(it)
                adapter = this@LugarTuristicoFragment.adapter
            }

            llenarLugar()
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

    fun llenarLugar() {
        lista.clear()

        lista.add(LugarTuristico(1, "Museo de Sitio Huaca Rajada y Sipan", "Ubicado a 35 Km. al sureste de la ciudad de Chiclayo (45 minutos en auto). Allí en 1987 se descubrió una tumba con los restos intacto de un personaje Mochica, el majestuoso Señor de Sipán. El hallazgo permite apreciar el ritual del funeral de un gobernante Mochica, quien estaba acompañado de un guerrero, un sacerdote, dos mujeres, un niño, un perro, una llama y guardián con los pies amputados. El ajuar funerario incluye numerosas joyas de oro y plata decorada con turquesas.",
                -6.799661253359545, -79.60031732448572))

        lista.add(LugarTuristico(2, "Reserva ecológica del Chaparri", "Territorio de 34 412 Ha. perteneciente a la comunidad campesina Muchik Santa Catalina de Chongoyape. Se trata de la primera área de conservación privada en el Perú. Su principal objetivo es la conservación de los bosques secos de la zona y de la rica bio diversidad que alberga; así como el establecimiento de mecanismos que permiten el aprovechamiento sostenible de los recursos naturales. Alberga importantes especies en peligros de extinción como el oso de anteojos, el guanaco, la pava ali blanca y el cóndor andino.",
                -6.698021, -79.358152))

        lista.add(LugarTuristico(3, "Santuario histórico Bosque de Pómac", "Este bosque seco es a su vez un refugio de algarrobos, aves y restos arqueológicos de la cultura Sicán. Se han hallado 20 estructuras pre incaicas, como Huaca Las Ventanas, Huaca Lucía, Huaca La Merced o Huaca Rodillona, entre otras. Los hallazgos arqueológicos han sorprendido por la cantidad de objetos de oro encontrados.",
                -6.486426, -79.773909))

        lista.add(LugarTuristico(4, "Museo Nacional Sicán", "Sicán o casa de la Luna es un museo que recoge el producto de las investigaciones que, por más de dos décadas, realizó el arqueólogo Izumi Shimada como director del proyecto arqueológico Sicán (1978). " +
                "La exhibición recopila los artefactos hallados en las excavaciones de los sitios de Batán Grande y los muestra tal como se usaron o se fabricaron. La intención es plasmar distintos aspectos vinculados a la Cultura Sipán, a través de la representación de detalles de la vida doméstica, de los procesos de manufactura o de las labores productivas.",
                -6.624058080704785, -79.7856671763785))

        lista.add(LugarTuristico(5, "Museo Nacional Tumbas Reales de Sipán", "De moderna arquitectura, alberga la colección de objetos arqueológicos de oro, plata y cobre, provenientes de la tumba del Señor de Sipán. El museo es dirigido por el arqueólogo Walter Alva, gestor y director del proyecto, y quien fuera el descubridor de dicho entierro en la zona arqueológica de Huaca Rajada, como en la localidad de Sipán-",
                -6.705037321613034, -79.89932294825661))

        lista.add(LugarTuristico(6, "Museo Nacional Arqueológico Bruning", "Exhibe la colección de objetos arqueológicos reunidos por el etnógrafo alemán Enrique Bruning. En sus cuatro pisos se exponen objetos de alfarería, textilería, trabajos en piedra, madera, etc. Todos ellos muestran el vigoroso carácter artístico y tecnológico de las culturas regionales de los últimos 5 000 años. La (Sala de Oro de este Museo es una muestra de incalculable valor histórico de América Pre colombina.",
                -6.704193289739393, -79.90376540188826))

        lista.add(LugarTuristico(7, "Mercado Artesanal de Monsefú", "Monsefú es reconocida por sus tejidos de paja: sombreros, cestas, carteras y alforjas de algodón e hilo. Además, son famosos sus bordados en los que incluso se utilizan oro y plata. Se puede adquirir delicadas servilletas, manteles, blusas, faldas, ponchos y mantas.",
                -6.8719033, -79.8692993))

        lista.add(LugarTuristico(8, "Catedral de la Ciudad de Chiclayo", "Horario de visita: En horarios de misa. Ubicación: Centro de la ciudad. De estilo neoclásico, construida en 1869. Portada de dos cuerpos sostenida por columnas dóricas que se anteponen a los tres arcos de la entrada",
                -6.771736420073154, -79.83791849490557))

        lista.add(LugarTuristico(9, "Palacio Municipal de Chiclayo", "Horario de visita: Durante el día. Ubicación: Calle San José N° 823. Lambayeque. Edificio republicano de amplios ventanales y puertas de fierro forjado. Construido en 1919, se calcula que costó algo de 30 mil libras de oro.",
                -6.771257, -79.838158))

        lista.add(LugarTuristico(10, "Balneario de Pimentel", "Horario de visita: Durante el día. Ubicación: A 11 Km al oeste de Chiclayo (20 minutos). Lambayeque. Moderno balneario ideal para la práctica del surf, motonáutica y windsurf. Además, se observan pescadores haciéndose al mar en ancestrales \"caballitos de totora\", balsa tradicional utilizada en la costa norte peruana desde la época precolombina.",
                -6.836731, -79.93831))

        lista.add(LugarTuristico(11, "Ciudad de Ferreñafe", "Horario de visita: Durante el día. Ubicación: A 18 Km al noreste de Chiclayo (30 minutos). Lambayeque. Poblada por agricultores dedicados al cultivo del arroz. Destaca la antigua iglesia de Santa Lucía (estilo barroco). Conocida como \"Tierra de la doble fe\" por mantener creencias católicas y chamánicas (brujería).",
                -6.639284, -79.788018))

        lista.add(LugarTuristico(12, "Ciudad de Lambayeque", "Ubicación: A 12 Km al noreste de Chiclayo (15 minutos). Conserva casonas virreinales como la Casa Descalzi, pero la más conocida es la Casa de la Logia Masónica, con un antiguo balcón tallado de más de 400 años, con 64 metros, considerado el más largo del Perú. La casa se ubica en la intersección de las calles Dos de Mayo y San Martín. Otros edificios importantes son la Iglesia de San Pedro del siglo XVI y la Ciudad Universitaria, sede de la Universidad Nacional Pedro Ruiz Gallo. ",
                -6.706481, -79.906445))

        adapter.notifyDataSetChanged()
    }

    fun lugarItemClicked(lugar: LugarTuristico) {
        activity?.let {
            val bundle = bundleOf("action" to "LugarMap",
                    "nombre" to lugar.nombre,
                    "latitud" to lugar.latitud,
                    "longitud" to lugar.longitud)

            ActivityNavigator(it)
                    .createDestination()
                    .setIntent(Intent(it, MapaActivity::class.java))
                    .navigate(bundle, null, null)

        }
    }

    private fun showToolbar(view: View, title: String = "") {
        val toolbar = view.findViewById<Toolbar>(R.id.toolbar)

        val let = activity as AppCompatActivity?
        let?.let {
            let.setSupportActionBar(toolbar)
            let.supportActionBar?.setDisplayHomeAsUpEnabled(true)
            let.supportActionBar?.title = title
        }
    }

}
