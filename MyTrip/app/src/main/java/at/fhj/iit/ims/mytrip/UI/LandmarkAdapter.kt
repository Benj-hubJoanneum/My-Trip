package at.fhj.iit.ims.mytrip.UI

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import at.fhj.iit.ims.mytrip.R
import at.fhj.iit.ims.mytrip.model.Landmark

class LandmarkAdapter(
    private val landmarks: List<Landmark>,
    private val onClick: (Landmark) -> Unit
) : RecyclerView.Adapter<LandmarkAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.textViewName)
        val description: TextView = view.findViewById(R.id.textViewDescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_landmark, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val landmark = landmarks[position]
        holder.name.text = landmark.name
        holder.description.text = landmark.description
        holder.itemView.setOnClickListener { onClick(landmark) }
    }

    override fun getItemCount() = landmarks.size
}
