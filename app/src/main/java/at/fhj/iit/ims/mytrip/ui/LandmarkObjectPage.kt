package at.fhj.iit.ims.mytrip.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import at.fhj.iit.ims.mytrip.list.LandmarkRepository
import at.fhj.iit.ims.mytrip.model.Landmark
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent
import androidx.compose.foundation.layout.aspectRatio

@Composable
fun LandmarkObjectPage(
    landmarkId: Int,
    onBack: () -> Unit = {}
) {
    val landmark = LandmarkRepository.getById(landmarkId)
    if (landmark == null) {
        NotFoundScreen(onBack)
    } else {
        LandmarkObjectPage(landmark = landmark, onBack = onBack)
    }
}

@Composable
fun LandmarkObjectPage(
    landmark: Landmark,
    onBack: () -> Unit = {}
) {
    Scaffold(

    ) { inner ->
        val scroll = rememberScrollState()
        Column(
            modifier = Modifier
                .padding(inner)
                .fillMaxSize()
                .verticalScroll(scroll)
        ) {
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

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(text = landmark.name, style = MaterialTheme.typography.headlineSmall)
                Text(text = landmark.description, style = MaterialTheme.typography.bodyLarge)
            }
        }
    }
}

@Composable
private fun NotFoundScreen(onBack: () -> Unit) {
    Scaffold(

    ) { inner ->
        Box(
            modifier = Modifier
                .padding(inner)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) { Text("Item not found", style = MaterialTheme.typography.bodyLarge) }
    }
}
