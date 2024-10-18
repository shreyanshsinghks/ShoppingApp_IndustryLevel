package com.shreyanshsinghks.domain.usecase

import com.shreyanshsinghks.domain.repository.CategoryRepository

class GetCategoryUseCase(private val categoryRepository: CategoryRepository) {
    suspend fun execute() = categoryRepository.getCategories()
}