package com.provadomingo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.provadomingo.dominio.DadosClima
import com.teste1.services.RetrofitService
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun consultarClima(view: View) {
        val lat = latitude.text.toString().toDouble()
        val long = longitude.text.toString().toDouble()

        val serviceRetrofit = RetrofitService()
        serviceRetrofit.api?.obterDadosClima(lat, long)?.enqueue(object : Callback<DadosClima?> {
            override fun onResponse(
                call: Call<DadosClima?>,
                response: Response<DadosClima?>
            ) {
                val dados = response?.body()
                if (dados != null) {
                    if (dados.currently?.icon.toString() == "clear-day") {
                        tempo.setImageResource(R.drawable.clearday)
                    }
                    if (dados.currently?.icon.toString() == "clear-night") {
                        tempo.setImageResource(R.drawable.clearnight)
                    }

                    if (dados.currently?.icon.toString() == "rain") {
                        tempo.setImageResource(R.drawable.rain)
                    }

                    if (dados.currently?.icon.toString() == "snow") {
                        tempo.setImageResource(R.drawable.snow)
                    }

                    if (dados.currently?.icon.toString() == "sleet") {
                        tempo.setImageResource(R.drawable.sleet)
                    }

                    if (dados.currently?.icon.toString() == "wind") {
                        tempo.setImageResource(R.drawable.wind)
                    }

                    if (dados.currently?.icon.toString() == "fog") {
                        tempo.setImageResource(R.drawable.fog)
                    }

                    if (dados.currently?.icon.toString() == "cloudy") {
                        tempo.setImageResource(R.drawable.cloudy)
                    }

                    if (dados.currently?.icon.toString() == "partly-cloudy-day") {
                        tempo.setImageResource(R.drawable.partlycloudyday)
                    }

                    if (dados.currently?.icon.toString() == "partly-cloudy-night") {
                        tempo.setImageResource(R.drawable.partlycloudynight)
                    }

                    Log.d("Test", dados.currently?.icon.toString())
                }

            }

            override fun onFailure(call: Call<DadosClima?>, t: Throwable?) {
                Log.e("Erro", "************** erro **********\n" + t?.message.toString())
            }
        })
    }
}
