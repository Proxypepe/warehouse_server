package com.example.warehouse_server.service

import com.example.warehouse_server.datasource.repository.UserRepository
import com.example.warehouse_server.dto.UserDTO
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) {
    fun getUserById(id: Long): UserDTO = userRepository.getById(id)
    fun getUsers(): List<UserDTO> = userRepository.findAll()
}