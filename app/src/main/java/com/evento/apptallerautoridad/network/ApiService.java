package com.evento.apptallerautoridad.network;

import com.evento.apptallerautoridad.data.entity.Expositor;
import com.evento.apptallerautoridad.data.entity.Agenda;
import com.evento.apptallerautoridad.data.entity.Hotel;

import kikopalomares.com.apicallsretrofit.data.remote.response.AgendaResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {


    @GET("/expositor/id/{idExpositor}")
    Call<Expositor> obtenerExpositor(@Path("idExpositor") String idExpositor);


    @GET("/agenda/id/{idAgenda}")
    Call<Agenda> obtenerAgenda(@Path("idAgenda") String idAgenda);

   // @GET("/usuario/catalogo/{codCatalogo}/{codGrup}")
    //Call<GruposResponse> obtenerGrupos(@Path("codGrup") String codCatalogo, @Path("codGrup") String codGrup);

    @GET("/hotel/codigo/{codigo}")
    Call<Hotel> obtenerHotel(@Path("codigo") String id);


}
