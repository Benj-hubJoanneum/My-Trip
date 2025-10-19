package at.fhj.iit.ims.mytrip.ui.components


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import at.fhj.iit.ims.mytrip.core.model.LandmarkComment


/** Card UI for a single review. */
@Composable
fun CommentCard(comment: LandmarkComment) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier.padding(12.dp)
        ) {
            Text(text = comment.title, style = MaterialTheme.typography.titleMedium)
            RatingBar(average = comment.rating.toDouble())
            Text(text = comment.description, style = MaterialTheme.typography.bodyMedium)
        }
    }
}