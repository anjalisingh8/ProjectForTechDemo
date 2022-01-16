package com.piyush.otpdemo.controller

import com.piyush.otpdemo.dto.OTPDto
import com.piyush.otpdemo.dto.OtpResponseEntity
import com.piyush.otpdemo.dto.ServiceResponseEntity
import com.piyush.otpdemo.services.OtpServices
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("otpservice")
class OtpController(
    @Autowired val otpService: OtpServices
) {

    @PostMapping("/generate")
    fun generateOtp(@RequestBody incomingRequest : OTPDto) : OtpResponseEntity<ServiceResponseEntity<OTPDto>>? {
        return OtpResponseEntity("200", "Success", otpService.generateOtp(incomingRequest))
    }
}