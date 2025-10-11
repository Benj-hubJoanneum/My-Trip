package at.fhj.iit.ims.mytrip.UI

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import at.fhj.iit.ims.mytrip.databinding.FragmentFirstBinding
import at.fhj.iit.ims.mytrip.list.LandmarkRepository

class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val landmarks = LandmarkRepository.getAll()
        val adapter = LandmarkAdapter(landmarks) { selected ->
            // navigate to details fragment and pass landmark id
            val action = FirstFragmentDirections
                .actionFirstFragmentToSecondFragment(selected.id)
            findNavController().navigate(action)
        }

        binding.recyclerViewLandmarks.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewLandmarks.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}