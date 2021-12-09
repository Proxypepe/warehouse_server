package com.example.warehouse_server.dto

import org.hibernate.Hibernate
import java.util.*
import javax.persistence.*


@Entity
@Table(name = "request")
data class RequestDTO(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var requestId: Long = 0,
    @Column(name = "userId", nullable = false)
    val userId: Int,
    @Column(nullable = false)
    val productName: String,
    @Column(nullable = false)
    val amount: Int,
    @Column(nullable = false)
    val warehousePlace: Int,
    @Column(nullable = true)
    val arrivalDate: Date?,
    @Column(nullable = true)
    @Embedded
    val contact: Contact?,
    @Column(nullable = true)
    @Embedded
    val price: Price?
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as RequestDTO

        return requestId == other.requestId
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $requestId , userId = $userId , productName = $productName , amount = $amount , warehousePlace = $warehousePlace , arrivalDate = $arrivalDate , contact = $contact , price = $price )"
    }
}