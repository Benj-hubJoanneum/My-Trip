package at.fhj.iit.ims.mytrip.ui.components

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ConfirmationNumber
import androidx.compose.material.icons.outlined.EventSeat
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

private fun String.isNotBlankUrl(): Boolean = this.isNotBlank()

@Composable
fun TicketReservationButtons(
    ticketUrl: String,
    reservationUrl: String,
    modifier: Modifier = Modifier
) {
    if (!ticketUrl.isNotBlankUrl() && !reservationUrl.isNotBlankUrl()) return

    val context = LocalContext.current
    Column(modifier = modifier, verticalArrangement = Arrangement.spacedBy(8.dp)) {
        if (ticketUrl.isNotBlankUrl()) {
            Button(
                onClick = {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(ticketUrl))
                    context.startActivity(intent)
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(Icons.Outlined.ConfirmationNumber, contentDescription = null)
                Spacer(Modifier.width(8.dp))
                Text("Buy tickets")
            }
        }
        if (reservationUrl.isNotBlankUrl()) {
            OutlinedButton(
                onClick = {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(reservationUrl))
                    context.startActivity(intent)
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(Icons.Outlined.EventSeat, contentDescription = null)
                Spacer(Modifier.width(8.dp))
                Text("Book reservation")
            }
        }
    }
}
