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
            val tema = it.getString("tema")

            title = "$name $apellido"

            view.findViewById<TextView>(R.id.expositor_nombre).text = name
            view.findViewById<TextView>(R.id.expositor_apellido).text = apellido
            view.findViewById<TextView>(R.id.expositor_cargo).text = cargo
            view.findViewById<TextView>(R.id.expositor_empresa).text = empresa
            view.findViewById<TextView>(R.id.expositor_resenia).text = resenia
            view.findViewById<TextView>(R.id.expositor_tema).text = tema

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
