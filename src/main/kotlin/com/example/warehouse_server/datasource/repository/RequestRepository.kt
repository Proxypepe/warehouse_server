package com.example.warehouse_server.datasource.repository

import com.example.warehouse_server.dto.RequestDTO
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface RequestRepository : JpaRepository<RequestDTO, Long> {

    @Query("select r from RequestDTO r where r.userId = ?1")
    fun getAllByUserId(userId: Int): List<RequestDTO>

}