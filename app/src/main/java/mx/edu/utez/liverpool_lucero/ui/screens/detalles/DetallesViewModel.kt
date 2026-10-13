package mx.edu.utez.liverpool_lucero.ui.screens.detalles

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import mx.edu.utez.liverpool_lucero.ui.models.ProductDetail

class DetallesViewModel : ViewModel() {
    var esFavorito = mutableStateOf(false)
        private set

    fun cambiarFavorito() {
        esFavorito.value = !esFavorito.value
    }
}