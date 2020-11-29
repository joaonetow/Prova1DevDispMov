package com.provadomingo

import com.provadomingo.dominio.DadosClima
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiEndPoint {
    @GET("forecast/8eeafa93fa171bb970bfac9b03caa3a3/{latitude},{longitude}?exclude =minutely,hourly,daily,flags,alerts")
    fun obterDadosClima(@Path("latitude") latitude: Double?, @Path("longitude") longitude: Double?): Call<DadosClima?>?
}