package com.shreyanshsinghks.domain.repository

import com.shreyanshsinghks.domain.model.Product
import com.shreyanshsinghks.domain.network.ResultWrapper

interface ProductRepository {
    suspend fun getProducts(): ResultWrapper<List<Product>>
}