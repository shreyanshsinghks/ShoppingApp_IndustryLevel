package com.shreyanshsinghks.domain.repository

import com.shreyanshsinghks.domain.model.ProductListModel
import com.shreyanshsinghks.domain.network.ResultWrapper

interface ProductRepository {
    suspend fun getProducts(category: Int?): ResultWrapper<ProductListModel>
}