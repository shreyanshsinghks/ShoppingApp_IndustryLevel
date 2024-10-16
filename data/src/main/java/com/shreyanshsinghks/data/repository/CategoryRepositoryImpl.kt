package com.shreyanshsinghks.data.repository

import com.shreyanshsinghks.domain.network.NetworkService
import com.shreyanshsinghks.domain.network.ResultWrapper
import com.shreyanshsinghks.domain.repository.CategoryRepository

class CategoryRepositoryImpl(private val networkService: NetworkService): CategoryRepository {
    override suspend fun getCategories(): ResultWrapper<List<String>> {
        return networkService.getCategories()
    }

}