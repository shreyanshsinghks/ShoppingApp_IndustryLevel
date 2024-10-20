package com.shreyanshsinghks.domain.usecase

import com.shreyanshsinghks.domain.repository.ProductRepository

class GetProductUseCase(private val repository: ProductRepository) {
    suspend fun execute(category: Int?) = repository.getProducts(category = category)
}