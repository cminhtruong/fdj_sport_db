package app.el_even.fdj.presentation.team_list.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import app.el_even.fdj.domain.model.Team
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun TeamListItem(
    team: Team,
    onItemClick: (Team) -> Unit
) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .clickable { onItemClick(team) }
        .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween) {
        GlideImage(
            imageModel = team.badge,
            modifier = Modifier,
            loading = {
                CircularProgressIndicator(
                    modifier = Modifier.fillMaxSize()
                )
            },
            failure = {
                Text(text = "Image request failed")
            }
        )
    }
}