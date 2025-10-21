package at.fhj.iit.ims.mytrip.core.data.remote

import at.fhj.iit.ims.mytrip.core.model.Landmark

interface LandmarkRemoteDao {
    suspend fun getAllLandmarks(): List<Landmark>
    suspend fun getLandmarkById(id: Int): Landmark?
}