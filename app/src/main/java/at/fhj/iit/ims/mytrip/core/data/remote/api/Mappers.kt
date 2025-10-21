package at.fhj.iit.ims.mytrip.core.data.remote.api

import at.fhj.iit.ims.mytrip.core.model.Landmark
import at.fhj.iit.ims.mytrip.core.model.LandmarkComment

fun LandmarkDto.toDomain(): Landmark =
    Landmark(
        id = id,
        name = name,
        description = description,
        imageUrl = imageUrl,
        latitude = latitude,
        longitude = longitude,
        cashless = cashless,
        ticketURL = ticketUrl,
        reservationURL = reservationUrl,
        comments = comments.map { it.toDomain() }
    )

fun LandmarkCommentDto.toDomain(): LandmarkComment =
    LandmarkComment(
        id = id,
        landmarkId = landmarkId,
        title = title,
        description = description,
        rating = rating
    )
