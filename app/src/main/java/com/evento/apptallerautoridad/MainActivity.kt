package com.evento.apptallerautoridad

import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment


class MainActivity : AppCompatActivity() {

    private lateinit var host: NavHostFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        host = supportFragmentManager
                .findFragmentById(R.id.nav_main_host_fragment) as NavHostFragment

        val navController = host.navController

        navController.addOnNavigatedListener { _, destination ->
            val dest: String = try {
                resources.getResourceName(destination.id)
            } catch (e: Resources.NotFoundException) {
                Integer.toString(destination.id)
            }
        }
    }

    override fun onBackPressed() {
        when (NavHostFragment.findNavController(host).currentDestination?.id) {
            R.id.inicioFragment -> {
                val alertDialog = AlertDialog.Builder(this)
                alertDialog.setTitle("¿Seguro desea salir?")
                alertDialog.setMessage("Al presionar Salir se va cerrar la aplicación.")

                alertDialog.setCancelable(false)
                        .setPositiveButton("Salir") { _, _ ->
                            finishAffinity()
                        }
                        .setNegativeButton("Cancelar") { dialog, _ ->
                            dialog.cancel()
                        }

                val alert = alertDialog.create()

                alert.show()
            }
            else -> {
                super.onBackPressed()
            }
        }
    }
}

private fun NavController.addOnNavigatedListener(any: Any) {

}
