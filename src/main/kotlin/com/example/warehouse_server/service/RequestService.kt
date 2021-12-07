package com.example.warehouse_server.service

import com.example.warehouse_server.datasource.repository.RequestRepository
import org.springframework.stereotype.Service

@Service
class RequestService(private val requestRepository: RequestRepository) {

}