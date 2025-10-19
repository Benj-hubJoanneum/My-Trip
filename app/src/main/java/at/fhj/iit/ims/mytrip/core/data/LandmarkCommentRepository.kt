package at.fhj.iit.ims.mytrip.core.data

import at.fhj.iit.ims.mytrip.core.model.LandmarkComment

object LandmarkCommentRepository {
    private val items = listOf(
        // Uhrturm (1)
        LandmarkComment(1, 1, "Great view", "Perfect meetup spot, nice skyline.", 5),
        LandmarkComment(2, 1, "Romantic", "Sunset was lovely.", 4),

        // Hauptbahnhof (2)
        LandmarkComment(3, 2, "Functional", "Busy but efficient.", 3),
        LandmarkComment(4, 2, "Crowded", "Too many people in rush hour.", 2),

        // Stadtpark (3)
        LandmarkComment(5, 3, "Chill", "Green and quiet.", 4),

        // Bermuda Dreieck (4)
        LandmarkComment(6, 4, "Party area", "Fun pubs all around.", 5),
        LandmarkComment(7, 4, "Loud", "Great at night, loud though.", 4),

        // Flan o'brien (5)
        LandmarkComment(8, 5, "Cozy pub", "Guinness on point.", 5),

        // Friendly Alien / Kunsthaus (6)
        LandmarkComment(9, 6, "Iconic", "Architecture is wild.", 5),
        LandmarkComment(10, 6, "Coffee stop", "Nice café inside.", 4),

        // Stadthalle (7)
        LandmarkComment(11, 7, "Great venue", "Acoustics decent.", 4),

        // Rathaus (8)
        LandmarkComment(12, 8, "Beautiful", "Lovely facade.", 5),

        // Kasematten (9)
        LandmarkComment(13, 9, "Atmospheric", "Open-air stage rocks.", 5),

        // Billa Eck (10)
        LandmarkComment(14, 10, "Convenient", "Good for quick snacks.", 3),

        // Dom im Berg (11)
        LandmarkComment(15, 11, "Unique", "Club inside a mountain!", 5),
        LandmarkComment(16, 11, "Cool vibes", "Lighting is amazing.", 4),

        // Hauptplatz (12)
        LandmarkComment(17, 12, "Centerpiece", "Fountain & markets.", 5),

        // Murinsel (14)
        LandmarkComment(18, 14, "Quirky", "Bridge-island café.", 4),

        // Mur Stage (15)
        LandmarkComment(19, 15, "Student spot", "Live shows are fun.", 4),
    )

    fun getAll(): List<LandmarkComment> = items

    fun getById(id: Int): LandmarkComment? = items.firstOrNull { it.id == id }

    fun forLandmark(landmarkId: Int): List<LandmarkComment> =
        items.filter { it.landmarkId == landmarkId }

    fun averageRatingFor(landmarkId: Int): Double {
        val ratings = forLandmark(landmarkId).map { it.rating }
        return if (ratings.isEmpty()) 0.0 else ratings.average()
    }
}
