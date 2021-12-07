package com.example.warehouse_server.dto

import javax.persistence.Embeddable

@Embeddable
data class Price(
    var price: Double,
    var currency: String
)
