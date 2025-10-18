package at.fhj.iit.ims.mytrip.UI

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.platform.ComposeView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import at.fhj.iit.ims.mytrip.R
import at.fhj.iit.ims.mytrip.list.LandmarkRepository
import at.fhj.iit.ims.mytrip.model.Landmark


class FirstFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = ComposeView(requireContext()).apply {
        setContent {
            // MyTripTheme {  // <- uncomment if you have a Compose Material3 theme
            MaterialTheme {
                LandmarkGrid(
                    landmarks = LandmarkRepository.getAll(),
                    onLandmarkClick = { landmark ->
                        // If you have a detail screen, navigate to it and pass the id
                        // Replace action & arg with your actual IDs
                        runCatching {
                            findNavController().navigate(
                                /* actionId = */ R.id.action_FirstFragment_to_SecondFragment,
                                /* args     = */ bundleOf("landmarkId" to landmark.id)
                            )
                        }
                    }
                )
            }
            // }
        }
    }
}

@Composable
private fun LandmarkGrid(
    landmarks: List<Landmark>,
    onLandmarkClick: (Landmark) -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 160.dp),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier.fillMaxSize()
    ) {
        items(
            items = landmarks,
            key = { it.id }
        ) { lm ->
            LandmarkCard(
                landmark = lm,
                onClick = { onLandmarkClick(lm) }
            )
        }
    }
}

@Composable
private fun LandmarkCard(
    landmark: Landmark,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 120.dp)
            .clickable(onClick = onClick)
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Text(
                text = landmark.name,
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = landmark.description,
                style = MaterialTheme.typography.bodyMedium,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.padding(top = 6.dp)
            )
        }
    }
}
