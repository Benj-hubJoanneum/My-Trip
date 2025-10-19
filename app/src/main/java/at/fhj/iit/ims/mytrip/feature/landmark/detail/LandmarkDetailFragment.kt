package at.fhj.iit.ims.mytrip.feature.landmark.detail


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import at.fhj.iit.ims.mytrip.core.data.DefaultLandmarkRepository


/** Hosts the landmark detail screen. */
class LandmarkDetailFragment : Fragment() {
    private val repo = DefaultLandmarkRepository()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = ComposeView(requireContext()).apply {
        val id = requireArguments().getInt("landmarkId", -1)
        setContent {
            MaterialTheme {
                LandmarkDetailScreen(landmark = repo.getById(id)) {
                    requireActivity().onBackPressedDispatcher.onBackPressed()
                }
            }
        }
    }
}