package com.example.warehouse_server.controllers

import com.example.warehouse_server.dto.UserDTO
import com.example.warehouse_server.service.UserService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.ArraySchema
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses

import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/user/")
@Tag(name = "User Information related interface")
class UserController(private val userService: UserService) {


//    @GetMapping("/{id}")
//    fun getUserById(@PathVariable id: Long): UserDTO = userService.getUserById(id)

    @GetMapping("/all")
    @Operation(summary = "Get a list of user")
    @ApiResponses(
        ApiResponse(
            responseCode = "200", description = "Found the users", content =
            arrayOf(
                Content(
                    mediaType = "application/json",
                    array = ArraySchema(schema = Schema(implementation = UserDTO::class))
                )
            )
        )
    )
    fun getUsers() = userService.getUsers()
}