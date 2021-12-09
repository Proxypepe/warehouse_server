package com.example.warehouse_server.service

import com.example.warehouse_server.datasource.repository.UserRepository
import com.example.warehouse_server.dto.UserDTO
import com.example.warehouse_server.models.User
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) {
    fun save(user: UserDTO) : UserDTO = userRepository.save(user)

    fun getUserById(id: Long): UserDTO = userRepository.getById(id)
    fun getUsers(): List<UserDTO> = userRepository.findAll()

    fun getUserByEmail(email: String): UserDTO = userRepository.getUserByEmail(email)

}