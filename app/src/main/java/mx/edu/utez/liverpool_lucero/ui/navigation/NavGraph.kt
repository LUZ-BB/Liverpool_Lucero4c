package mx.edu.utez.liverpool_lucero.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import mx.edu.utez.liverpool_lucero.ui.screens.detalles.DetallesScreen
import mx.edu.utez.liverpool_lucero.ui.screens.productos.ProductosScreen
import mx.edu.utez.liverpool_lucero.ui.screens.productos.ProductosViewModel
import mx.edu.utez.liverpool_lucero.ui.screens.tituloLiverpool.TituloLiverpoolScreen

sealed class Route(val path: String) {
    object TituloLiverpool : Route("titulo_liverpool")
    object Productos : Route("productos")
    object Detalles : Route("detalles/{productId}") {
        fun createRoute(productId: String) = "detalles/$productId"
    }
}

@Composable
fun NavGraph(
    navController: NavHostController
) {
    val productosViewModel: ProductosViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = Route.TituloLiverpool.path
    ) {
        composable(Route.TituloLiverpool.path) {
            TituloLiverpoolScreen(
                onNavigateToProducts = {
                    navController.navigate(Route.Productos.path)
                }
            )
        }

        composable(Route.Productos.path) {
            val products by productosViewModel.products.collectAsStateWithLifecycle()

            ProductosScreen(
                elementos = products,
                onItemClick = { productId ->
                    navController.navigate(Route.Detalles.createRoute(productId))
                },
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }

        composable(
            route = Route.Detalles.path,
            arguments = listOf(navArgument("productId") { type = NavType.StringType })
        ) { backStackEntry ->
            val productId = backStackEntry.arguments?.getString("productId")
            val products by productosViewModel.products.collectAsStateWithLifecycle()
            val product = products.find { it.id == productId } ?: products.first()

            DetallesScreen(
                product = product,
                onFavoriteClick = {
                    productosViewModel.toggleFavorite(product.id)
                },
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}