package at.fhj.iit.ims.mytrip

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import at.fhj.iit.ims.mytrip.objectpage.LandmarkObjectPage

class LandmarkObjectPageFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = ComposeView(requireContext()).apply {
        val id = requireArguments().getInt("landmarkId", -1)
        setContent {
            MaterialTheme {
                LandmarkObjectPage(landmarkId = id) {
                    requireActivity().onBackPressedDispatcher.onBackPressed()
                }
            }
        }
    }
}
