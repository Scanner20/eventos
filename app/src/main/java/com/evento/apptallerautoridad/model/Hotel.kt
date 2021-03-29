package com.evento.apptallerautoridad.model

data class Hotel (var id: Int = 0,
                  var nombre: String = "",
                  var direccion: String = "",
                  var estrellas: String = "",
                  var phone: String = "",
                  var web: String = "",
                  var latitud: Double = 0.0,
                  var longitud: Double = 0.0)