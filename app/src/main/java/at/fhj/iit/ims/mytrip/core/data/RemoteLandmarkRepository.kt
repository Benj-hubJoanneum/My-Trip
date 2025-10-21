package at.fhj.iit.ims.mytrip.core.data

import at.fhj.iit.ims.mytrip.core.data.remote.LandmarkRemoteDao
import at.fhj.iit.ims.mytrip.core.model.Landmark
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

/**
 * Remote-backed repository that adapts suspend DAO calls to the current
 * non-suspend LandmarkRepository interface.
 *
 * NOTE: This blocks the calling thread. Prefer to move the interface to suspend
 * and call from a ViewModel coroutine long-term.
 */
class RemoteLandmarkRepository(
    private val remote: LandmarkRemoteDao
) : LandmarkRepository {

    override fun getAll(): List<Landmark> = runBlocking {
        withContext(Dispatchers.IO) { remote.getAllLandmarks() }
    }

    override fun getById(id: Int): Landmark? = runBlocking {
        withContext(Dispatchers.IO) { remote.getLandmarkById(id) }
    }
}
