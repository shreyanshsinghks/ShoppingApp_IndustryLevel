package com.shreyanshsinghks.data.repository

import com.shreyanshsinghks.domain.network.NetworkService
import com.shreyanshsinghks.domain.network.ResultWrapper
import com.shreyanshsinghks.domain.repository.ProductRepository

class ProductRepositoryImpl(private val networkService: NetworkService) : ProductRepository {
    override suspend fun getProducts(category: Int?): ResultWrapper<com.shreyanshsinghks.domain.model.ProductListModel> {
        return networkService.getProducts(category = category)
    }
}