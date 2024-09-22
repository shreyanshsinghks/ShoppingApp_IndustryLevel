package com.shreyanshsinghks.shoppingappindustrylevel.feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shreyanshsinghks.domain.model.Product
import com.shreyanshsinghks.domain.network.ResultWrapper
import com.shreyanshsinghks.domain.usecase.GetProductUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeViewModel(private val getProductUseCase: GetProductUseCase) : ViewModel() {
    private val _uiState = MutableStateFlow<HomeScreenUIEvents>(HomeScreenUIEvents.Loading)
    val uiState = _uiState.asStateFlow()

    init {
        getProducts()
    }

    private fun getProducts() {
        viewModelScope.launch {
            getProductUseCase.invoke().let { result ->
                when (result) {
                    is ResultWrapper.Success -> {
                        val data = result.value
                        _uiState.value = HomeScreenUIEvents.Success(data)
                    }

                    is ResultWrapper.Failure -> {
                        _uiState.value = HomeScreenUIEvents.Error(
                            result.exception.message ?: "Something went wrong"
                        )
                    }
                }
            }
        }
    }
}

sealed class HomeScreenUIEvents {
    data object Loading : HomeScreenUIEvents()
    data class Success(val data: List<Product>) : HomeScreenUIEvents()
    data class Error(val message: String) : HomeScreenUIEvents()
}