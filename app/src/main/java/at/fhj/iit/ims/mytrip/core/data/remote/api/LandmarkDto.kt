package at.fhj.iit.ims.mytrip.core.data.remote.api

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LandmarkDto(
    val id: Int,
    val name: String,
    val description: String,
    @SerialName("imageUrl") val imageUrl: String,
    val latitude: Double,
    val longitude: Double,
    val cashless: Boolean,
    @SerialName("ticketURL") val ticketUrl: String = "",
    @SerialName("reservationURL") val reservationUrl: String = "",
    val comments: List<LandmarkCommentDto> = emptyList()
)

@Serializable
data class LandmarkCommentDto(
    val id: Int,
    val landmarkId: Int,
    val title: String,
    val description: String,
    val rating: Int
)
