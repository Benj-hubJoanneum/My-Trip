package at.fhj.iit.ims.mytrip.core.data.remote

import android.content.Context
import at.fhj.iit.ims.mytrip.core.data.remote.api.LandmarkApiService
import at.fhj.iit.ims.mytrip.secure.SecureRetrofit
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.OkHttpClient
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

object RetrofitModule {

    // currently spy server. should be changed to nice server
    private const val BASE_URL = "http://10.77.18.136:8080/"

    private val json = Json {
        ignoreUnknownKeys = true
        isLenient = true
        explicitNulls = false
    }

    fun api(context: Context): LandmarkApiService =
        SecureRetrofit.build(context, BASE_URL).create(LandmarkApiService::class.java)

    private val client: OkHttpClient by lazy {
        val logger = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BASIC
        }
        OkHttpClient.Builder()
            .addInterceptor(logger)
            .build()
    }

    val api: LandmarkApiService by lazy {
        val contentType = "application/json".toMediaType()
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(json.asConverterFactory(contentType))
            .build()
            .create(LandmarkApiService::class.java)
    }
}
