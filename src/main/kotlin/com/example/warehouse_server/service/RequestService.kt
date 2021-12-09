package com.example.warehouse_server.service

import com.example.warehouse_server.datasource.repository.RequestRepository
import com.example.warehouse_server.dto.RequestDTO
import org.springframework.stereotype.Service

@Service
class RequestService(private val requestRepository: RequestRepository) {
    fun getRequests(): List<RequestDTO> = requestRepository.findAll()
    fun getAllByUserId(userId: Int): List<RequestDTO> = requestRepository.getAllByUserId(userId)

    fun save(requestDTO: RequestDTO): RequestDTO = requestRepository.save(requestDTO)
}