package at.fhj.iit.ims.mytrip.core.data.remote.api

import at.fhj.iit.ims.mytrip.core.data.remote.LandmarkRemoteDao
import at.fhj.iit.ims.mytrip.core.model.Landmark

class LandmarkRemoteDaoImpl(
    private val api: LandmarkApiService
) : LandmarkRemoteDao {

    override suspend fun getAllLandmarks(): List<Landmark> =
        api.getLandmarks().map { it.toDomain() }

    override suspend fun getLandmarkById(id: Int): Landmark? =
        api.getLandmark(id)?.toDomain()
}
