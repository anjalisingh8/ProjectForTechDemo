package com.example.demo.entity

import com.sun.org.apache.xpath.internal.operations.Bool

data class Customer(
    var walletStatus : String,
    var typeOfTransaction :String,
    var kycType : String,
    var customerStatus : String,
    var accountBalance : Long,
    var accountLimits : Long
) {


}