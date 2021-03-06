package com.example.warehouse_server

import com.example.warehouse_server.config.SwaggerConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Import
import org.springframework.web.servlet.config.annotation.EnableWebMvc

@SpringBootApplication
@EnableWebMvc
@Import(SwaggerConfiguration::class)
class WarehouseServerApplication

fun main(args: Array<String>) {
    runApplication<WarehouseServerApplication>(*args)
}
