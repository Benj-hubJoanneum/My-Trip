package at.fhj.iit.ims.mytrip.list

import at.fhj.iit.ims.mytrip.model.Landmark

object LandmarkRepository {
    private val items = listOf(
        Landmark(1, "uhrturm", "treffpunkt tinderdates"),
        Landmark(2, "hbf", "meet and greet with sandler"),
        Landmark(3, "stadpark Palace", "marktplatz für fragliche produkte")
    )

    fun getAll(): List<Landmark> = items

    fun getById(id: Int): Landmark? = items.firstOrNull { it.id == id }
}
