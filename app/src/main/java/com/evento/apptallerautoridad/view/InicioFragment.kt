package com.evento.apptallerautoridad.view

import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions

import com.evento.apptallerautoridad.R
import com.evento.apptallerautoridad.viewmodels.InicioViewModel
import kotlinx.android.synthetic.main.inicio_fragment.*

class InicioFragment : Fragment(){


    companion object {
        fun newInstance() = InicioFragment()
    }

    private lateinit var viewModel: InicioViewModel

    private var options: NavOptions? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.inicio_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(InicioViewModel::class.java)
        // TODO: Use the ViewModel

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

        context?.let { it ->
            btn_agenda.setOnClickListener {
                findNavController().navigate(R.id.agendaFragment, null, options)
            }

            btn_expositores.setOnClickListener {
                findNavController().navigate(R.id.expositorFragment, null, options)
            }

            btn_informacion.setOnClickListener {
                findNavController().navigate(R.id.informacionFragment, null, options)
            }

            btn_grupo.setOnClickListener {
                val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://chat.whatsapp.com/EQUQGj5Ej1AJU7SHJ4ej7T"))
                startActivity(i)
            }

            btn_descargas.setOnClickListener {
                val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://mi.upc.edu.pe/"))
                startActivity(i)
            }
        }
    }
}
