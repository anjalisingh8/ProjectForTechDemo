package com.example.demo.entity

data class CustomerTransaction(
    var customer: Customer,
    var transactions: Transactions
) {
}