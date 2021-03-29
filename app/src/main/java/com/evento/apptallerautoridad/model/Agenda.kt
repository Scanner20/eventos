package com.evento.apptallerautoridad.model

import java.sql.Timestamp

data class Agenda (var id: Int = 0,
                   var tema: String = "",
                   var fecha: Timestamp = Timestamp(System.currentTimeMillis()))