package com.evento.apptallerautoridad

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment

class StartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        val host = supportFragmentManager
                .findFragmentById(R.id.nav_start_host_fragment) as NavHostFragment

        val navController = host.navController
    }
}
