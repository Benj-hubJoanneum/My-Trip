package at.fhj.iit.ims.mytrip.ui.components


import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.StarHalf
import androidx.compose.material.icons.outlined.StarBorder
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


/** Displays a 5‑star rating with half‑star support. */
@Composable
fun RatingBar(average: Double, modifier: Modifier = Modifier) {
    Row(modifier = modifier) {
        for (i in 1..5) {
            val filled = average >= i
            val half = !filled && average >= (i - 0.5)
            val icon = when {
                filled -> Icons.Filled.Star
                half -> Icons.Filled.StarHalf
                else -> Icons.Outlined.StarBorder
            }
            Icon(imageVector = icon, contentDescription = null, modifier = Modifier.size(18.dp))
        }
    }
}