package app.el_even.fdj.presentation.league_list.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import app.el_even.fdj.domain.model.League

@Composable
fun LeagueListItem(
    league: League,
    onItemClick: (League) -> Unit
) {
    Row(modifier = Modifier
        .fillMaxSize()
        .clickable { onItemClick(league) }
        .padding(10.dp),
        horizontalArrangement = Arrangement.Start) {
        Text(
            text = "{league.name}",
            style = MaterialTheme.typography.body1,
            overflow = TextOverflow.Ellipsis
        )
    }
}