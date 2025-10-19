package at.fhj.iit.ims.mytrip.core.data


import at.fhj.iit.ims.mytrip.core.model.Landmark


/**
 * Read‑only repository for landmark content.
 * You can later add write APIs (add/edit comments) or swap the data source.
 */
interface LandmarkRepository {
    /** Returns all landmarks, each enriched with its comments. */
    fun getAll(): List<Landmark>


    /** Returns a single landmark by [id] or null if not found. */
    fun getById(id: Int): Landmark?
}