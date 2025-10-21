package at.fhj.iit.ims.mytrip.core.data.remote.api

import retrofit2.http.GET
import retrofit2.http.Path

interface LandmarkApiService {
    @GET("landmarks")
    suspend fun getLandmarks(): List<LandmarkDto>

    @GET("landmarks/{id}")
    suspend fun getLandmark(@Path("id") id: Int): LandmarkDto?
}
