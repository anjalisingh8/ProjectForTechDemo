package com.piyush.otpdemo.services

import com.piyush.otpdemo.dao.OtpDao
import com.piyush.otpdemo.dto.OTPDto
import com.piyush.otpdemo.dto.ServiceResponseEntity
import com.piyush.otpdemo.entity.OTPEntity
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class OtpServicesImpl(
    @Autowired var otpDao: OtpDao,
) : OtpServices{
    override fun generateOtp(otpDto: OTPDto): ServiceResponseEntity<OTPDto> {
        var otpGeneratedResponse = otpDao.generateOtp(otpDto.toOTPEntity()).toOTPDto()
        return ServiceResponseEntity("200", "OTP successfully generated", otpGeneratedResponse);
//        First converted to entity to send to DAO then converted back to DTO what we received from DAO
    }

//    Custom mapper made to map from DTO to entity
private fun OTPDto.toOTPEntity() = OTPEntity(
        userId = userId,
        emailId = emailId,
        otpGenerated = generatedOtp
    )

//    Custom mapper made to map from entity to DTO
private fun OTPEntity.toOTPDto() = OTPDto(
        userId = "$userId",
        emailId = "$emailId",
        generatedOtp = "$otpGenerated"
    )
}