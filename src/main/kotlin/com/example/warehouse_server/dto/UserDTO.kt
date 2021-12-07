package com.example.warehouse_server.dto

import javax.persistence.Entity
import javax.persistence.Table

import org.hibernate.Hibernate
import javax.persistence.*

@Entity
@Table(name = "user")
data class UserDTO(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val userId: Long = 0,
    val fullname: String,
    val email: String,
    val password: String?,
    val role: String,
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "userId")
    val requestDTOS: List<RequestDTO> = emptyList()
)