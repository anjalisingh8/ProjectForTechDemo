package com.piyush.otpdemo.dto

import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash

@RedisHash("uniqueIdVal")
data class OTPDto(
//    NOTE :- We never keep userId in DTO because it comes from the Databse
//    Won be storing timestamp like data in the dto but will be passing in the entity
    @get:Id
    var userId : String? = null,
    var emailId : String,
    var generatedOtp : String
)