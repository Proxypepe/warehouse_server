package com.example.warehouse_server.controllers

import com.example.warehouse_server.dto.UserDTO
import com.example.warehouse_server.service.UserService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/auth")
@Tag(name = "Auth endpoint")
class AuthController(private val service: UserService) {

    @GetMapping()
    @ResponseBody
    @Operation(summary = "Check auth params")
    @ApiResponses( value = [
        ApiResponse(
            responseCode = "200", description = "Authorizes the user", content =
            arrayOf(
                 Content(
                     mediaType = "application/json",
                     schema = Schema(implementation = UserDTO::class)
                 )
            )
        )
    ]
    )
    fun checkAuth(@RequestParam email: String, @RequestParam password: String): UserDTO {
        return service.getUserByEmail(email)
    }
}