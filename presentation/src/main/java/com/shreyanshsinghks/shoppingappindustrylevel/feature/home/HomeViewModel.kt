package com.shreyanshsinghks.shoppingappindustrylevel.feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shreyanshsinghks.domain.model.Product
import com.shreyanshsinghks.domain.network.ResultWrapper
import com.shreyanshsinghks.domain.usecase.GetCategoryUseCase
import com.shreyanshsinghks.domain.usecase.GetProductUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getProductUseCase: GetProductUseCase,
    private val getCategoryUseCase: GetCategoryUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow<HomeScreenUIEvents>(HomeScreenUIEvents.Loading)
    val uiState = _uiState.asStateFlow()

    init {
        getAllProducts()
    }

    private fun getAllProducts() {
        viewModelScope.launch {
            _uiState.value = HomeScreenUIEvents.Loading
            val featured = getProducts("electronics")
            val popularProducts = getProducts("jewelery")
            val categories = getCategories()
            if (featured.isEmpty() || popularProducts.isEmpty() || categories.isEmpty()) {
                _uiState.value = HomeScreenUIEvents.Error("Failed to fetch products")
                return@launch
            }
            _uiState.value = HomeScreenUIEvents.Success(featured, popularProducts, categories)
        }
    }

    private suspend fun getCategories(): List<String> {
        getCategoryUseCase.execute().let { result ->
            when (result) {
                is ResultWrapper.Success -> {
                    return result.value
                }

                is ResultWrapper.Failure -> {
                    return emptyList()
                }
            }
        }
    }

    private suspend fun getProducts(category: String?): List<Product> {
        getProductUseCase.invoke(category = category).let { result ->
            when (result) {
                is ResultWrapper.Success -> {
                    return result.value
                }

                is ResultWrapper.Failure -> {
                    return emptyList()
                }
            }
        }
    }
}

sealed class HomeScreenUIEvents {
    data object Loading : HomeScreenUIEvents()
    data class Success(
        val featured: List<Product>,
        val popularProducts: List<Product>,
        val categories: List<String>
    ) :
        HomeScreenUIEvents()

    data class Error(val message: String) : HomeScreenUIEvents()
}