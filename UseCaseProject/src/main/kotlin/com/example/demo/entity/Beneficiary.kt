package com.example.demo.entity

data class Beneficiary(
     var walletStatus :String,
     var kycType : String,
     var smallPPIMonths : Int,
     var beneficiaryStatus : String
) {
}