package app.kyushu.kyushu.presentation.screen_first.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import app.kyushu.kyushu.navigation.AppNavigationDestination
import app.kyushu.kyushu.presentation.screen_first.FirstScreen

object FirstScreenDestination : AppNavigationDestination {
    override val route = "screen_first_route"
    override val destination = "screen_first_destination"
}

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.firstScreenGraph(navController: NavController) {
    composable(route = FirstScreenDestination.route) {
        FirstScreen(
            navController = navController
        )
    }
}
