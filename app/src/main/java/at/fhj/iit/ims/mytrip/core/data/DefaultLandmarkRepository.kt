package at.fhj.iit.ims.mytrip.core.data

import at.fhj.iit.ims.mytrip.core.data.local.FakeLandmarkDataSource
import at.fhj.iit.ims.mytrip.core.model.Landmark
import at.fhj.iit.ims.mytrip.core.model.LandmarkComment

/**
 * Default repository backed by an in-memory fake data source.
 * Replace [FakeLandmarkDataSource] with a Room/Network implementation later.
 */
class DefaultLandmarkRepository(
    private val dataSource: FakeLandmarkDataSource = FakeLandmarkDataSource()
) : LandmarkRepository {

    // Cache composed landmarks to avoid rebuilding on every call in this sample.
    private val items: List<Landmark> by lazy {
        dataSource.baseLandmarks.map { base ->
            val comments: List<LandmarkComment> = dataSource.commentsFor(base.id)
            Landmark(
                id = base.id,
                name = base.name,
                description = base.description,
                imageUrl = base.imageUrl,
                latitude = base.latitude,
                longitude = base.longitude,
                cashless = base.cashless,
                ticketURL = base.ticketURL,
                reservationURL = base.reservationURL,
                comments = comments
            )
        }
    }

    override fun getAll(): List<Landmark> = items

    override fun getById(id: Int): Landmark? = items.firstOrNull { it.id == id }
}
