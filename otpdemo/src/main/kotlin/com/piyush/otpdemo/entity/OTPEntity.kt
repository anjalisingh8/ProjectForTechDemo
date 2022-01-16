package com.piyush.otpdemo.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

@Document(value = "OTPDataEntity")
data class OTPEntity(
    @Id
    @Field(value = "userId")
    var userId: String? = "",

    @Field(value = "emailId")
    var emailId: String = "",

    @Field(value = "generatedOtp")
    var otpGenerated: String = ""
)