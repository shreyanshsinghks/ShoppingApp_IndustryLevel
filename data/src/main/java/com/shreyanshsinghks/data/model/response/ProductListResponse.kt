package com.shreyanshsinghks.data.model.response

import com.shreyanshsinghks.data.model.DataProductModel
import kotlinx.serialization.Serializable

@Serializable
data class ProductListResponse(
    val `data`: List<DataProductModel>,
    val msg: String
){
    fun toProductList() = com.shreyanshsinghks.domain.model.ProductListModel(
        products = `data`.map { it.toProduct() },
        msg = msg
    )
}