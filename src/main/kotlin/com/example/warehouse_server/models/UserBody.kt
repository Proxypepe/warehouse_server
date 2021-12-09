package com.example.warehouse_server.models

import io.swagger.v3.oas.annotations.Parameter

data class UserBody(
    @Parameter(required = true)
    val fullname: String,
    @Parameter(required = true)
    val email: String,
    @Parameter(required = false)
    val password: String?,
    @Parameter(required = true)
    val role: String,
)
