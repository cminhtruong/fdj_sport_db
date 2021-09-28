package app.el_even.fdj.presentation.team_list

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import app.el_even.fdj.presentation.Screen
import app.el_even.fdj.presentation.team_list.component.TeamListItem

@Composable
fun TeamListScreen(
    navController: NavController,
    viewModel: TeamListViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    val numberOfItemsByRow = LocalConfiguration.current.screenWidthDp / 200
    Box(modifier = Modifier.fillMaxWidth()) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(state.teams.chunked(numberOfItemsByRow)) { rowItems ->
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.padding(4.dp)
                ) {
                    for (team in rowItems) {
                        TeamListItem(team = team, onItemClick = {
                            navController.navigate(Screen.TeamScreen.route + "/${team.name}")
                        })
                    }
                }
            }
        }
        if (state.error.isNotBlank()) {
            Text(
                text = state.error,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)
            )
        }
        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}