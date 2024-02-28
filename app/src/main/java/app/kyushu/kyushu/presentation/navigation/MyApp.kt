package app.kyushu.kyushu.presentation.navigation

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import app.kyushu.kyushu.presentation.screen_first.navigation.FirstScreenDestination
import app.kyushu.kyushu.presentation.screen_first.navigation.firstScreenGraph
import app.kyushu.kyushu.presentation.screen_second.navigation.secondScreenGraph
import app.kyushu.kyushu.theme.AppTheme

@Composable
fun MyApp() {
    AppTheme(
        darkTheme = true,
    ) {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            val navController = rememberNavController()
            NavHost(
                navController = navController,
                startDestination = FirstScreenDestination.route
            ) {
                firstScreenGraph(
                    navController = navController
                )

                secondScreenGraph(
                    navController = navController
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AppTheme {
        MyApp()
    }
}