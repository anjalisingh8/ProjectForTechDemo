package com.piyush.otpdemo.services

import com.piyush.otpdemo.dto.OTPDto
import com.piyush.otpdemo.dto.ServiceResponseEntity

interface OtpServices {
    fun generateOtp(otpDto: OTPDto) : ServiceResponseEntity<OTPDto>
}