package com.shreyanshsinghks.domain.repository

import com.shreyanshsinghks.domain.network.ResultWrapper

interface CategoryRepository {
    suspend fun getCategories(): ResultWrapper<List<String>>
}