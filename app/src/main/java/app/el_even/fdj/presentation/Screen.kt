package app.el_even.fdj.presentation

sealed class Screen(val route: String) {
    object MainScreen : Screen("main")
    object TeamListScreen : Screen("teams")
    object TeamScreen : Screen("team")
}
