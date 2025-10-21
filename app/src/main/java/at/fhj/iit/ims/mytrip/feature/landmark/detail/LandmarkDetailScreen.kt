package at.fhj.iit.ims.mytrip.feature.landmark.detail

import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import at.fhj.iit.ims.mytrip.core.model.Landmark
import at.fhj.iit.ims.mytrip.ui.components.CommentCard
import at.fhj.iit.ims.mytrip.ui.components.RatingBar
import at.fhj.iit.ims.mytrip.ui.components.PaymentInfoChip
import at.fhj.iit.ims.mytrip.ui.components.TicketReservationButtons
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent

@Composable
private fun NotFoundScreen(onBack: () -> Unit = {}) {
    Scaffold { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Item not found", style = MaterialTheme.typography.bodyLarge)
        }
    }
}

@Composable
fun LandmarkDetailScreen(landmark: Landmark?, onBack: () -> Unit = {}) {
    if (landmark == null) {
        NotFoundScreen(onBack)
    } else {
        Content(landmark)
    }
}

@Composable
private fun Content(landmark: Landmark) {
    Scaffold(
        floatingActionButton = { MapFab(landmark) },
        floatingActionButtonPosition = FabPosition.End,
        contentWindowInsets = WindowInsets.safeDrawing
    ) { inner ->
        val scroll = rememberScrollState()
        Column(
            modifier = Modifier
                .padding(inner)
                .fillMaxSize()
                .verticalScroll(scroll)
        ) {
            // --- Image ---
            SubcomposeAsyncImage(
                model = landmark.imageUrl,
                contentDescription = landmark.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp))
            ) {
                when (val state = painter.state) {
                    is AsyncImagePainter.State.Success -> {
                        val size = state.painter.intrinsicSize
                        val ratio =
                            if (size.width.isFinite() && size.height.isFinite() && size.height > 0f)
                                size.width / size.height
                            else 16f / 9f
                        SubcomposeAsyncImageContent(
                            modifier = Modifier
                                .fillMaxWidth()
                                .aspectRatio(ratio)
                        )
                    }
                    is AsyncImagePainter.State.Loading -> {
                        Box(
                            Modifier
                                .fillMaxWidth()
                                .height(220.dp),
                            contentAlignment = Alignment.Center
                        ) { CircularProgressIndicator() }
                    }
                    else -> {
                        Box(
                            Modifier
                                .fillMaxWidth()
                                .height(220.dp),
                            contentAlignment = Alignment.Center
                        ) { Text("Image unavailable", style = MaterialTheme.typography.labelMedium) }
                    }
                }
            }

            // --- Landmark info ---
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(text = landmark.name, style = MaterialTheme.typography.headlineSmall)

                Row(verticalAlignment = Alignment.CenterVertically) {
                    RatingBar(average = landmark.averageRating)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = if (landmark.reviewCount > 0)
                            "(${"%.1f".format(landmark.averageRating)} • ${landmark.reviewCount} reviews)"
                        else "(No reviews yet)",
                        style = MaterialTheme.typography.labelLarge
                    )
                }

                Text(text = landmark.description, style = MaterialTheme.typography.bodyLarge)

                // --- Payment info + actions (beneath description, above reviews) ---
                PaymentInfoChip(
                    cashless = landmark.cashless,
                    modifier = Modifier.padding(top = 4.dp)
                )
                TicketReservationButtons(
                    ticketUrl = landmark.ticketURL,
                    reservationUrl = landmark.reservationURL,
                    modifier = Modifier.padding(top = 8.dp)
                )
            }

            // --- Comments section ---
            LandmarkCommentsSection(landmark)
        }
    }
}

@Composable
private fun LandmarkCommentsSection(landmark: Landmark) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Divider()
        Text(
            text = "User Reviews",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(vertical = 4.dp)
        )

        if (landmark.comments.isEmpty()) {
            Text(
                text = "No reviews yet.",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(vertical = 8.dp)
            )
        } else {
            landmark.comments.forEach { comment ->
                CommentCard(comment)
            }
        }
    }
}

@Composable
private fun MapFab(landmark: Landmark) {
    val context = LocalContext.current
    FloatingActionButton(onClick = {
        val lat = landmark.latitude
        val lon = landmark.longitude
        val name = landmark.name

        val uri = Uri.parse("geo:$lat,$lon?q=$lat,$lon(${Uri.encode(name)})")
        val intent = Intent(Intent.ACTION_VIEW, uri)

        try {
            intent.setPackage("com.google.android.apps.maps")
            context.startActivity(intent)
        } catch (e: Exception) {
            val fallback = Intent(Intent.ACTION_VIEW, uri)
            try {
                context.startActivity(fallback)
            } catch (_: Exception) {
                Toast.makeText(context, "No map app found.", Toast.LENGTH_SHORT).show()
            }
        }
    }) {
        Icon(imageVector = Icons.Filled.LocationOn, contentDescription = "Open in Google Maps")
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LandmarkPager(
    landmarks: List<Landmark>,
    startIndex: Int
) {
    val pagerState = rememberPagerState(
        initialPage = startIndex,
        pageCount = { landmarks.size }
    )
    HorizontalPager(
        state = pagerState,
        modifier = Modifier.fillMaxSize() // important so swipes register
    ) { page ->
        LandmarkDetailScreen(landmark = landmarks[page])
    }
}
