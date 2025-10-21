package at.fhj.iit.ims.mytrip.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AttachMoney
import androidx.compose.material.icons.outlined.CreditCard
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun PaymentInfoChip(cashless: Boolean, modifier: Modifier = Modifier) {
    val (icon, label, clickable) = if (cashless) {
        Triple(Icons.Outlined.CreditCard, "Cashless accepted", false)
    } else {
        Triple(Icons.Outlined.AttachMoney, "Cash only", false)
    }

    SuggestionChip(
        onClick = {},
        label = { Text(label) },
        icon = { Icon(icon, contentDescription = null) },
        modifier = modifier,
        enabled = !clickable
    )
}
