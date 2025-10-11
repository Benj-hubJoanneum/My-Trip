package at.fhj.iit.ims.mytrip.UI

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import at.fhj.iit.ims.mytrip.databinding.FragmentSecondBinding
import at.fhj.iit.ims.mytrip.list.LandmarkRepository

class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!

    private val args: SecondFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val landmark = LandmarkRepository.getById(args.landmarkId)
        binding.textviewSecond.text = landmark?.let {
            "${it.name}\n\n${it.description}"
        } ?: "Not found"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
