package at.fhj.iit.ims.mytrip.feature.landmark.list
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import at.fhj.iit.ims.mytrip.core.model.Landmark
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LandmarkGrid(
    landmarks: List<Landmark>,
    onLandmarkClick: (Landmark) -> Unit
) {
    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Adaptive(180.dp),
        verticalItemSpacing = 1.dp,
        horizontalArrangement = Arrangement.spacedBy(1.dp),
        contentPadding = PaddingValues(1.dp),
        modifier = Modifier.fillMaxSize()
    ) {
        items(items = landmarks, key = { it.id }) { lm ->
            LandmarkTile(landmark = lm) { onLandmarkClick(lm) }
        }
    }
}


@Composable
private fun LandmarkTile(
    landmark: Landmark,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
    ) {
        SubcomposeAsyncImage(
            model = landmark.imageUrl,
            contentDescription = landmark.name,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxWidth()
        ) {
            when (val state = painter.state) {
                is AsyncImagePainter.State.Loading -> {
                    Box(
                        Modifier
                            .fillMaxWidth()
                            .heightIn(min = 140.dp),
                        contentAlignment = Alignment.Center
                    ) { CircularProgressIndicator() }
                }
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
                else -> {
                    Box(
                        Modifier
                            .fillMaxWidth()
                            .heightIn(min = 140.dp),
                        contentAlignment = Alignment.Center
                    ) { Text("Image unavailable", style = MaterialTheme.typography.labelMedium) }
                }
            }
        }
    }
}