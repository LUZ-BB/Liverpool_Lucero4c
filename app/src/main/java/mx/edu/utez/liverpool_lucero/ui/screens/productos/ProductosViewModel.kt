package mx.edu.utez.liverpool_lucero.ui.screens.productos

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import mx.edu.utez.liverpool_lucero.R
import mx.edu.utez.liverpool_lucero.ui.models.ProductDetail
import mx.edu.utez.liverpool_lucero.ui.models.Review

class ProductosViewModel : ViewModel() {

    private val _products = MutableStateFlow(
        listOf(
            ProductDetail(
                id = "1",
                brand = "PRO PLAN",
                name = "Croquetas PRO PLAN Sabor Pescado 10 kg",
                price = 850.0,
                rating = 4.8f,
                reviewCount = 120,
                isFreeShipping = true,
                description = "Alimento seco completo y equilibrado para gatos adultos con sabor a pescado.",
                image = R.drawable.croquetas,
                reviews = listOf(
                    Review(author = "Lucero B.", comment = "A mi gato le encanta este sabor.", rating = 5.0f),
                    Review(author = "Carlos M.", comment = "Excelente tamaño y buen precio.", rating = 5.0f),
                    Review(author = "Ana P.", comment = "Llegó rápido y en buen estado.", rating = 4.5f),
                    Review(author = "Jorge L.", comment = "Muy buen producto recomendado.", rating = 4.8f)
                ),
                isFavorite = false
            ),
            ProductDetail(
                id = "2",
                brand = "PETKIT",
                name = "Fuente de Agua Automática para Gatos 2L",
                price = 699.0,
                rating = 4.7f,
                reviewCount = 85,
                isFreeShipping = true,
                description = "Fuente inteligente y silenciosa con filtrado múltiple para agua fresca todo el día.( no incluye al michi)",
                image = R.drawable.fuente,
                reviews = listOf(
                    Review(author = "Sofía R.", comment = "Súper silenciosa y a mis gatos les fascina.", rating = 5.0f),
                    Review(author = "David G.", comment = "El agua se mantiene muy limpia.", rating = 4.5f),
                    Review(author = "Fernanda T.", comment = "Fácil de limpiar y armar.", rating = 4.8f),
                    Review(author = "Raúl V.", comment = "Excelente calidad en los materiales.", rating = 4.6f)
                ),
                isFavorite = false
            ),
            ProductDetail(
                id = "3",
                brand = "CATIT",
                name = "Rascador Torre de Cartón con Hierba Gatera",
                price = 320.0,
                rating = 4.6f,
                reviewCount = 45,
                isFreeShipping = false,
                description = "Diseñado para satisfacer el instinto natural de rascado de tu gato.",
                image = R.drawable.rascador,
                reviews = listOf(
                    Review(author = "Mariana S.", comment = "A mis gatos les duró bastante.", rating = 4.5f),
                    Review(author = "Héctor N.", comment = "Les encantó la hierba gatera.", rating = 5.0f),
                    Review(author = "Valeria C.", comment = "Buen tamaño y económico.", rating = 4.0f),
                    Review(author = "Gabriel E.", comment = "Cumple con su función a la perfección.", rating = 5.0f)
                ),
                isFavorite = false
            ),
            ProductDetail(
                id = "4",
                brand = "ROYAL CANIN",
                name = "Arena Sanitaria Aglutinante para Gatos 5 kg",
                price = 280.0,
                rating = 4.9f,
                reviewCount = 92,
                isFreeShipping = true,
                description = "Arena de alta absorción que forma grumos sólidos rápidamente facilitando la limpieza.",
                image = R.drawable.arena,
                reviews = listOf(
                    Review(author = "Paola D.", comment = "La mejor arena que he probado para el olor.", rating = 5.0f),
                    Review(author = "Mauricio K.", comment = "Agrupa muy bien y no hace tanto polvo.", rating = 5.0f),
                    Review(author = "Andrea F.", comment = "Rinde bastante bien.", rating = 4.8f),
                    Review(author = "Esteban R.", comment = "Excelente absorción.", rating = 4.5f)
                ),
                isFavorite = false
            ),
            ProductDetail(
                id = "5",
                brand = "TRIXIE",
                name = "Juguete Túnel Plegable para Gatos con Pompones",
                price = 249.0,
                rating = 4.5f,
                reviewCount = 30,
                isFreeShipping = false,
                description = "Túnel de juego crujiente para estimular la curiosidad y ejercicio de tu mascota.",
                image = R.drawable.tunel,
                reviews = listOf(
                    Review(author = "Karla M.", comment = "Se divierten muchísimo corriendo ahí.", rating = 5.0f),
                    Review(author = "Omar S.", comment = "Es fácil de doblar y guardar.", rating = 4.0f),
                    Review(author = "Daniela P.", comment = "Buena calidad de tela.", rating = 4.5f),
                    Review(author = "Luis G.", comment = "A mis gatitos les encantó.", rating = 5.0f)
                ),
                isFavorite = false
            )
        )
    )
    val products: StateFlow<List<ProductDetail>> = _products.asStateFlow()

    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery.asStateFlow()

    fun updateSearchQuery(query: String) {
        _searchQuery.value = query
    }

    fun toggleFavorite(productId: String) {
        _products.update { list ->
            list.map { product ->
                if (product.id == productId) {
                    product.copy(isFavorite = !product.isFavorite)
                } else {
                    product
                }
            }
        }
    }
}