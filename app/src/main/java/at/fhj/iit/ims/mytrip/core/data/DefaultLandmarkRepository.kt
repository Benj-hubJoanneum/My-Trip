package at.fhj.iit.ims.mytrip.core.data

import at.fhj.iit.ims.mytrip.core.data.remote.LandmarkRemoteDao
import at.fhj.iit.ims.mytrip.core.data.remote.RetrofitModule
import at.fhj.iit.ims.mytrip.core.data.remote.api.LandmarkRemoteDaoImpl
import at.fhj.iit.ims.mytrip.core.model.Landmark
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

class DefaultLandmarkRepository(
    private val remote: LandmarkRemoteDao = LandmarkRemoteDaoImpl(RetrofitModule.api)
) : LandmarkRepository {

    override fun getAll(): List<Landmark> = runBlocking {
        withContext(Dispatchers.IO) { remote.getAllLandmarks() }
    }

    override fun getById(id: Int): Landmark? = runBlocking {
        withContext(Dispatchers.IO) { remote.getLandmarkById(id) }
    }
}
