package com.piyush.otpdemo.dao

import com.piyush.otpdemo.entity.OTPEntity
import com.piyush.otpdemo.repository.OtpRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class OtpDaoImpl(
    @Autowired var otpRepository: OtpRepository
) : OtpDao {

    override fun generateOtp(otpEntity: OTPEntity): OTPEntity {
        return otpRepository.save(otpEntity)
    }

    fun saveOtp(otpEntity: OTPEntity):OTPEntity {

        return otpEntity
    }
}