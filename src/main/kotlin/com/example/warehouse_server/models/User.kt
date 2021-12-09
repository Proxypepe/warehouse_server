package com.example.warehouse_server.models

import com.example.warehouse_server.dto.RequestDTO
import io.swagger.v3.oas.annotations.Parameter

data class User(
    @Parameter(required = true)
    val fullname: String,
    @Parameter(required = true)
    val email: String,
    @Parameter(required = false)
    val password: String?,
    @Parameter(required = true)
    val role: String,
    @Parameter(required = false)
    val requestDTOS: List<RequestDTO> = emptyList()
)
