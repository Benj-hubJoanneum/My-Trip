package at.fhj.iit.ims.mytrip.feature.landmark.list


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.core.os.bundleOf
import at.fhj.iit.ims.mytrip.R
import at.fhj.iit.ims.mytrip.core.data.DefaultLandmarkRepository


/** Hosts the landmark list Compose UI inside a Fragment for navigation. */
class LandmarkListFragment : Fragment() {
    private val repo = DefaultLandmarkRepository()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = ComposeView(requireContext()).apply {
        setContent {
            MaterialTheme {
                LandmarkGrid(
                    landmarks = repo.getAll(),
                    onLandmarkClick = { landmark ->
                        runCatching {
                            findNavController().navigate(
                                R.id.action_LandmarkList_to_LandmarkObjectPageFragment,
                                bundleOf("landmarkId" to landmark.id)
                            )
                        }
                    }
                )
            }
        }
    }
}