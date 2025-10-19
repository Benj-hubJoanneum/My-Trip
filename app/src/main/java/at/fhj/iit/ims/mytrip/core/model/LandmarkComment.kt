package at.fhj.iit.ims.mytrip.core.model


/** A single user review attached to a [Landmark]. */
data class LandmarkComment(
    val id: Int,
    val landmarkId: Int,
    val title: String,
    val description: String,
    val rating: Int,
)