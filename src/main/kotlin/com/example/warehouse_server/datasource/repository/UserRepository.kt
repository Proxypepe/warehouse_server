package com.example.warehouse_server.datasource.repository;

import com.example.warehouse_server.dto.UserDTO
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<UserDTO, Long> {

    @Query("SELECT * FROM user WHERE email = :email", nativeQuery = true)
    fun getUserByEmail(email: String): UserDTO
}