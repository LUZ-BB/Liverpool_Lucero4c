package mx.edu.utez.liverpool_lucero

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import mx.edu.utez.liverpool_lucero.ui.navigation.NavGraph
import mx.edu.utez.liverpool_lucero.ui.theme.Liverpool_LuceroTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Liverpool_LuceroTheme {
                val navController = rememberNavController()
                NavGraph(navController = navController)
            }
        }
    }
}