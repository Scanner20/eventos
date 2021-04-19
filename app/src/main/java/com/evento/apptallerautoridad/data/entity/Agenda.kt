package com.evento.apptallerautoridad.data.entity

import java.sql.Timestamp

data class Agenda  (var id: Int = 0,
                   var tema: String = "",
                   var fecha: Timestamp = Timestamp(System.currentTimeMillis()),
                    var nombre : String? = "",
                    var apellido : String? = ""



)
