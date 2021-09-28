package app.el_even.fdj.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import app.el_even.fdj.presentation.league_list.LeagueListScreen
import app.el_even.fdj.presentation.team_detail.TeamScreen
import app.el_even.fdj.presentation.team_list.TeamListScreen
import app.el_even.fdj.presentation.ui.theme.FDJTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FDJTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.MainScreen.route
                    ) {
                        composable(
                            route = Screen.TeamListScreen.route + "/{league}"
                        ) {
                            TeamListScreen(navController = navController)
                        }
                        composable(
                            route = Screen.TeamScreen.route + "/{name}"
                        ) {
                            TeamScreen()
                        }
                        composable(
                            route = Screen.MainScreen.route
                        ) {
                            LeagueListScreen(navController = navController)
                        }
                    }
                }
            }
        }
    }
}
