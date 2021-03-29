package com.evento.apptallerautoridad.view

import android.content.Intent
import android.os.Build
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AlertDialog
import androidx.navigation.ActivityNavigator
import com.evento.apptallerautoridad.MainActivity

import com.evento.apptallerautoridad.R
import com.evento.apptallerautoridad.viewmodels.LoginViewModel
import kotlinx.android.synthetic.main.login_fragment.*

class LoginFragment : Fragment() {

    companion object {
        fun newInstance() = LoginFragment()
    }

    private lateinit var viewModel: LoginViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.login_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)

        context?.let {il ->
            val fadeIn = AnimationUtils.loadAnimation(il, R.anim.fade_in)
            val slideLeft = AnimationUtils.loadAnimation(il, R.anim.slide_left)

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                img_logo.startAnimation(slideLeft)

                /*btn_login.startAnimation(fadeIn)
                btn_registrarse.startAnimation(fadeIn)
                btn_salir.startAnimation(fadeIn)*/
                btn_continuar.startAnimation(fadeIn)
            }


            btn_continuar.setOnClickListener {
                goMainActivity()
                activity?.finish()
            }

            btn_salir.setOnClickListener { it ->
                val alertDialog = AlertDialog.Builder(il)
                alertDialog.setTitle("¿Seguro desea salir?")
                alertDialog.setMessage("Al presionar Ok se va cerrar la aplicación.")

                alertDialog.setCancelable(false)
                        .setPositiveButton("Salir") { _, _ ->
                            activity?.finish()
                        }
                        .setNegativeButton("Cancelar") { dialog, _ ->
                            dialog.cancel()
                        }

                val alert = alertDialog.create()


                alert.show()
            }
        }
    }

    private fun goMainActivity() {
        context?.let {
            ActivityNavigator(it)
                    .createDestination()
                    .setIntent(Intent(it, MainActivity::class.java))
                    .navigate(null, null, null)
        }
    }


}
