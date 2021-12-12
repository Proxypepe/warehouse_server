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
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/user/")
@Tag(name = "User Information related interface")
class UserController(private val userService: UserService) {

    @GetMapping("/{email}")
    @Operation(summary = "Get user info by email")
    @ApiResponses(
        ApiResponse(
            responseCode = "200", description = "Found the user by email", content =
            arrayOf(
                Content(
                    mediaType = "application/json",
                    schema = Schema(implementation = UserDTO::class)
                )
            )
        )
    )
    fun getUserByEmail(@PathVariable email: String): UserDTO{
        return userService.getUserByEmail(email)
    }

    @GetMapping("/all")
    @Operation(summary = "Get a list of users")
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


    @PutMapping("/update")
    @Operation(summary = "Updates user information")
    @ApiResponses(
        ApiResponse(
            responseCode = "200", description = "Updated user information", content =
            arrayOf(
                Content(
                    mediaType = "application/json",
                    schema = Schema(implementation = UserDTO::class)
                )
            )
        )
    )
    fun updateUser(@RequestBody user: UserDTO): UserDTO {
        return userService.save(user)
    }
}