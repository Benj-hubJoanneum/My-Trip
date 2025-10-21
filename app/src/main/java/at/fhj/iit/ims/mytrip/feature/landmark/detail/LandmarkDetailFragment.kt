// app/src/main/java/at/fhj/iit/ims/mytrip/feature/landmark/detail/LandmarkDetailFragment.kt
package at.fhj.iit.ims.mytrip.feature.landmark.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import at.fhj.iit.ims.mytrip.core.data.DefaultLandmarkRepository

class LandmarkDetailFragment : Fragment() {
    private val repo = DefaultLandmarkRepository()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = ComposeView(requireContext()).apply {
        val selectedId = requireArguments().getInt("landmarkId", -1)
        val landmarks = repo.getAll()
        val startIndex = landmarks.indexOfFirst { it.id == selectedId }.let { if (it >= 0) it else 0 }

        setContent {
            MaterialTheme {
                LandmarkPager(
                    landmarks = landmarks,
                    startIndex = startIndex
                )
            }
        }
    }
}
