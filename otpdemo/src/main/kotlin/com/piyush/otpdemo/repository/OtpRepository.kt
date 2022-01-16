package com.piyush.otpdemo.repository

import com.piyush.otpdemo.entity.OTPEntity
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface OtpRepository : MongoRepository<OTPEntity, String> {

}