package com.evento.apptallerautoridad.network;

import java.util.Map;

import com.evento.apptallerautoridad.model.Agenda;
import com.evento.apptallerautoridad.model.Expositor;
import com.evento.apptallerautoridad.model.Hotel;
import com.evento.apptallerautoridad.model.LugarTuristico;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiService {


    @GET("/expositor/id/{idExpositor}")
    Call<Expositor> obtenerExpositor(@Path("idExpositor") String idExpositor);


   // @GET("/usuario/catalogo/{codCatalogo}/{codGrup}")
    //Call<GruposResponse> obtenerGrupos(@Path("codGrup") String codCatalogo, @Path("codGrup") String codGrup);




}
