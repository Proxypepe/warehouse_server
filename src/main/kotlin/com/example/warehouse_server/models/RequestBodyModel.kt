package com.example.warehouse_server.models

import com.example.warehouse_server.dto.Contact
import com.example.warehouse_server.dto.Price
import io.swagger.v3.oas.annotations.Parameter
import java.util.*


data class RequestBodyModel(
    @Parameter(required = true)
    val userId: Int,
    @Parameter(required = true)
    val productName: String,
    @Parameter(required = true)
    val amount: Int,
    @Parameter(required = true)
    val warehousePlace: Int,
    @Parameter(required = false)
    val contact: Contact?,
    @Parameter(required = false)
    val price: Price?
)