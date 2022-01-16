package com.demo.ProjectForTechDemo.entity


 data class User(
    var name: String,
    var country: String,
    var BankAccountExists : Boolean,
    var Kyc: Boolean,
    var age: Int,
    var dailyTransactions: Int,
    var monthlyTransactions: Int,
    var dailyTransactionsAmount: Long,
    var monthlyTransactionsAmount: Long,
    var ruleValidated : String,
 )
{

 }
