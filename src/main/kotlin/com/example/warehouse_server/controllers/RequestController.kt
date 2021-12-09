package com.example.warehouse_server.controllers

import com.example.warehouse_server.dto.Contact
import com.example.warehouse_server.dto.Price
import com.example.warehouse_server.dto.RequestDTO
import com.example.warehouse_server.models.RequestBodyModel
import com.example.warehouse_server.service.RequestService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/requests")
@Tag(name = "Requests endpoint")
class RequestController(private val requestService: RequestService){

    @GetMapping("/all")
    @Operation(summary = "Get all requests")
    fun getAllRequest(): List<RequestDTO> = requestService.getRequests()

    @GetMapping("/{userId}")
    @Operation(summary = "Get list of requests by userId")
    fun getRequestsByUserId(@PathVariable userId: Int): List<RequestDTO> {
        return requestService.getAllByUserId(userId)
    }

    @PostMapping("/add")
    @Operation(summary = "Create a new request")
    @ApiResponses
    fun addRequest(@RequestBody body: RequestBodyModel): RequestDTO {
        return save(body.userId, body.productName, body.amount, body.warehousePlace, body.contact, body.price)
    }

    @PutMapping("/update")
    @Operation(summary = "Update the request")
    @ApiResponses
    fun updateRequest(@RequestBody body: RequestDTO): RequestDTO {
        return requestService.save(body)
    }

    private fun save(userId: Int, productName: String, amount: Int, warehousePlace: Int, contact: Contact?, price: Price?)
    :RequestDTO {
        return requestService.save(
            RequestDTO(
                userId = userId,
                productName = productName,
                amount = amount,
                warehousePlace = warehousePlace,
                arrivalDate = null,
                contact = contact?.let{ Contact(it.contactName, it.phoneNumber) },
                price = price?.let { Price(it.price, it.currency) }
            )
        )
    }

}