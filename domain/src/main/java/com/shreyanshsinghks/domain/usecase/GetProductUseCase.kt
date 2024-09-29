package com.shreyanshsinghks.domain.usecase

import com.shreyanshsinghks.domain.repository.ProductRepository

class GetProductUseCase(private val repository: ProductRepository) {
    suspend operator fun invoke(category: String?) = repository.getProducts(category = category)
}