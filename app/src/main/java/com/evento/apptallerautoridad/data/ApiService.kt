package kikopalomares.com.apicallsretrofit.data.remote


import kikopalomares.com.apicallsretrofit.data.remote.response.ExpositoresResponse
import kikopalomares.com.apicallsretrofit.data.remote.response.AgendaResponse
import kikopalomares.com.apicallsretrofit.data.remote.response.HotelResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface ApiService {

    @GET("id/{idExpositor}")
    fun getAllPosts(@Path("idExpositor") id : String): Call<ExpositoresResponse>


    @GET("id/{idAgenda}")
    fun getAllAgenda(@Path("idAgenda") id : String): Call<AgendaResponse>

    @GET("codigo/{codigo}")
    fun getAllHotel(@Path("codigo") codigo : String): Call<HotelResponse>


}


