package com.example.warehouse_server.dto

import javax.persistence.Embeddable

@Embeddable
data class Contact(
    var contactName: String,
    var phoneNumber: String
)