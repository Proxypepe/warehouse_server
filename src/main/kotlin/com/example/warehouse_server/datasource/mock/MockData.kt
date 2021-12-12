package com.example.warehouse_server.datasource.mock

import com.example.warehouse_server.datasource.repository.RequestRepository
import com.example.warehouse_server.datasource.repository.UserRepository
import com.example.warehouse_server.dto.Price
import com.example.warehouse_server.dto.RequestDTO
import com.example.warehouse_server.dto.UserDTO
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.ApplicationArguments
import org.springframework.stereotype.Component

@Component
class MockData(private val userRepository: UserRepository, private val requestRepository: RequestRepository): ApplicationRunner {

    override fun run(args: ApplicationArguments?) {
        userRepository.save(UserDTO(
            fullname="Alex",
            email="alex",
            password="123",
            role="admin",
        ))
        userRepository.save(UserDTO(
            fullname="Jyk",
            email="Jyk@bk.com",
            password="123",
            role="moder",
        ))
        userRepository.save(UserDTO(
            fullname="Pasha",
            email="Pasha@bk.com",
            password="123",
            role="moder",
        ))

        userRepository.save(UserDTO(
            fullname="",
            email="sds",
            password="123",
            role="admin",
        ))


        requestRepository.save( RequestDTO(
            userId = 1,
            productName = "Product",
            amount = 100,
            warehousePlace = 1,
            status = "Ok",
            arrivalDate = null,
            contact = null,
            price = Price(10.0, "RUB")
        ))
        requestRepository.save( RequestDTO(
            userId = 4,
            productName = "Product",
            amount = 100,
            warehousePlace = 1,
            status = "Ok",
            arrivalDate = null,
            contact = null,
            price = Price(10.0, "RUB")
        ))
        requestRepository.save( RequestDTO(
            userId = 4,
            productName = "Product",
            amount = 100,
            warehousePlace = 1,
            status = "Ok",
            arrivalDate = null,
            contact = null,
            price = Price(10.0, "RUB")
        ))

        println("All ok")
    }
}