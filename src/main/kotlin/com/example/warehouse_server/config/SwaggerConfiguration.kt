package com.example.warehouse_server.config

import com.example.warehouse_server.controllers.UserController
import com.example.warehouse_server.dto.UserDTO
import org.springdoc.core.GroupedOpenApi
import org.springdoc.core.SwaggerUiConfigParameters
import org.springdoc.core.SwaggerUiOAuthProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

@Configuration
@Import(
    org.springdoc.core.SpringDocConfigProperties::class,
    org.springdoc.webmvc.core.MultipleOpenApiSupportConfiguration::class,
    org.springdoc.core.SpringDocConfiguration::class,
    org.springdoc.webmvc.core.SpringDocWebMvcConfiguration::class
)
class SwaggerConfiguration() {
    @Bean
    fun warehouseApi(): GroupedOpenApi? {
        return GroupedOpenApi.builder()
            .group("Api")
            .pathsToExclude("/user/**","/auth/**", "/register/**", "/requests/**")
            .packagesToScan("com.example.warehouse_server.controllers")
            .pathsToMatch("/user/**",  "/auth/**", "/register/**", "/requests/**")
            .build()
    }
}