package at.fhj.iit.ims.mytrip.core.model


/**
 * Immutable domain model describing a point of interest shown in the app.
 *
 * @property id Stable unique identifier.
 * @property name Human‑readable name of the landmark.
 * @property description Short marketing/guide text.
 * @property imageUrl Public HTTP(S) URL to a representative image.
 * @property comments User generated reviews bound to this landmark.
 */
data class Landmark(
    val id: Int,
    val name: String,
    val description: String,
    val imageUrl: String,
    val latitude: Double,
    val longitude: Double,
    val cashless: Boolean = true,
    val ticketURL: String,
    val reservationURL: String,
    val comments: List<LandmarkComment> = emptyList()
) {
    /** Average rating across [comments]. Returns 0.0 if there are no comments. */
    val averageRating: Double = comments.map { it.rating }.average().takeIf { !it.isNaN() } ?: 0.0
    /** Total number of reviews. */
    val reviewCount: Int = comments.size
}