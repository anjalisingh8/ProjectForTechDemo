package com.piyush.otpdemo.dao

import com.piyush.otpdemo.dto.OTPDto
import com.piyush.otpdemo.entity.OTPEntity

interface OtpDao {
    fun generateOtp(otpEntity: OTPEntity) : OTPEntity
}